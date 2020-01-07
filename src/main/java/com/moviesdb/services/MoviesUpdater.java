package com.moviesdb.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesdb.entities.Genre;
import com.moviesdb.entities.ImageId;
import com.moviesdb.entities.Images;
import com.moviesdb.entities.MovieGenreId;
import com.moviesdb.entities.Movies;
import com.moviesdb.entities.MoviesGenre;
import com.moviesdb.entities.Status;
import com.moviesdb.entities.VideoId;
import com.moviesdb.entities.Videos;
import com.moviesdb.repositories.GenreRepository;
import com.moviesdb.repositories.ImageRepository;
import com.moviesdb.repositories.MovieGenreRepository;
import com.moviesdb.repositories.MovieRepository;
import com.moviesdb.repositories.StatusRepository;
import com.moviesdb.repositories.VideoRepository;

@Service
public class MoviesUpdater {
	@Autowired
	StatusRepository repo;
	@Autowired
	VideoRepository vidRepo;
	@Autowired
	MovieRepository movieRepo;
	@Autowired
	ImageRepository imgRepo;
	@Autowired
	MovieGenreRepository movGenRepo;
	@Autowired
	GenreRepository genRepo;
	
	private String key = "32825c5d3799d37ff4916bd51f0c0eae";
	
	public void updatePlaying() {
		String URL = "https://api.themoviedb.org/3/movie/now_playing?api_key="+key+"&language=en-US&page=1";
		JSONParser parser = new JSONParser();
		JSONArray data = retrieveRestData(URL);
        if(data != null) {
        	for(int i=0; i<data.size(); i++) {
            	JSONObject singleMovie = (JSONObject) data.get(i);
                long movieID = (long) singleMovie.get("id");
                String urlForMovieDetails = "https://api.themoviedb.org/3/movie/"+movieID+"?api_key="+key+"&append_to_response=videos,images";
                JSONObject movieDetails = null;
                try {
					URL u2 = new URL(urlForMovieDetails);
					URLConnection con2 = u2.openConnection();
	                BufferedReader br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
	                String json = br2.readLine();
	                movieDetails = (JSONObject) parser.parse(json);
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
					return;
				}
                String title = movieDetails.get("title").toString();
                String poster = movieDetails.get("poster_path").toString();
                String homepage = movieDetails.get("homepage").toString();
                String imdb = movieDetails.get("imdb_id").toString();
                String overview = movieDetails.get("overview").toString();
                String date = movieDetails.get("release_date").toString();
                String status = movieDetails.get("status").toString();
                String tagline = movieDetails.get("tagline").toString();
                double vote_average = (double) movieDetails.get("vote_average");
                long vote_count = (long) movieDetails.get("vote_count");
                long runtime = (long) movieDetails.get("runtime");
                
                Status statusObj = new Status(status);
                Status li = repo.findByStatus(status);
                int statusInt = 0;
                if(li == null) {
                	repo.save(statusObj);
                	li = repo.findByStatus(status);
                }
                else {
                	statusInt = li.getID();
                }
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd"); 
                Date release_date = null;
				try {
					release_date = dt.parse(date);
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
                int intid = (int) movieID;
                Movies movie = movieRepo.findById(((Integer)intid)).orElse(null);
                
                if(movie == null) {
                	movieRepo.save(new Movies((Integer) intid, title, homepage, imdb, overview, poster, release_date, 
                			Integer.valueOf((int)runtime), Float.valueOf((float)vote_average),
                			Integer.valueOf((int)vote_count), tagline, li));
                	movie = movieRepo.findById((Integer) intid).orElse(null);
                }
                else {
                	continue;
                }
                insertImages(movieDetails, movie);
                insertVideos(movieDetails, movie);
                insertGenres(movieDetails, movie);
        	}
        }
	}
	
	public JSONArray retrieveRestData(String URL) {
		JSONParser parser = new JSONParser();
		try {
			URL oracle = new URL(URL);
	        URLConnection yc = oracle.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        yc.connect();
	        String movieInfo = in.readLine();
	        JSONObject entireJSON = (JSONObject) parser.parse(movieInfo);
	        JSONArray results = (JSONArray) entireJSON.get("results");
	        in.close();
	        return results;
		} catch(IOException | ParseException ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public void insertVideos(JSONObject movieDetails, Movies movie) {
		JSONArray videos = (JSONArray) ((JSONObject) movieDetails.get("videos")).get("results");
        for(int j=0; j<videos.size(); j++) {
        	JSONObject video = (JSONObject) videos.get(j);
        	Object languageObj = video.get("iso_639_1");
        	if(languageObj != null && languageObj.toString().equalsIgnoreCase("en")) {
            	VideoId videosId = new VideoId(video.get("key").toString(), movie);
            	Videos vid = new Videos(videosId, video.get("name").toString());
            	vidRepo.save(vid);	
        	}
        }
	}
	
	public void insertImages(JSONObject movieDetails, Movies movie) {
		JSONArray videos = (JSONArray) ((JSONObject) movieDetails.get("images")).get("posters");
        for(int j=0; j<videos.size(); j++) {
        	JSONObject imageJSON = (JSONObject) videos.get(j);
        	Object languageObj = imageJSON.get("iso_639_1");
        	if(languageObj == null || languageObj.toString().equalsIgnoreCase("en")) {
        		ImageId imageId = new ImageId(imageJSON.get("file_path").toString(), movie);
            	Images img = new Images(imageId);
            	imgRepo.save(img);
        	}
        }
	}
	
	public void insertGenres(JSONObject movieDetails, Movies movie) {
		JSONArray genres = (JSONArray) movieDetails.get("genres");
		for(int i=0; i<genres.size(); i++) {
			JSONObject obj = (JSONObject) genres.get(i);
			String type = obj.get("name").toString();
			Genre genre = genRepo.findByType(type);
			if(genre == null) {
				Genre newGenre = new Genre(type);
				genRepo.save(newGenre);
				newGenre = genRepo.findByType(type);
				movGenRepo.save(new MoviesGenre(new MovieGenreId(movie, newGenre)));
			}
		}
		
	}
}
