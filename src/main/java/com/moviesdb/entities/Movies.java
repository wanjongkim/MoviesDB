package com.moviesdb.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Movies {
	@Id
	private Integer id;
	private String title;
	private String homepage;
	private String imdb_id;
	private String overview;
	private String poster;
	private Date release_Date;
	private Integer runtime;
	private Float vote_Avg;
	private Integer vote_Count;
	private String tag_Line;
	@ManyToOne
	@JoinColumn(name="Status", referencedColumnName="ID", foreignKey = @ForeignKey(name="movies_ibfk_1"))
	private Status status;
	
	public Movies() {}
	
	public Movies(Integer id, String title, String homepage, String imdb_id, String overview, String poster, Date release_Date,
			Integer runtime, Float vote_Avg, Integer vote_Count, String tag_Line, Status status) {
		this.setId(id);
		this.setTitle(title);
		this.homepage = homepage;
		this.imdb_id = imdb_id;
		this.overview = overview;
		this.poster = poster;
		this.release_Date = release_Date;
		this.runtime = runtime;
		this.vote_Avg = vote_Avg;
		this.vote_Count = vote_Count;
		this.tag_Line = tag_Line;
		this.status = status;
	}
	
	
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Date getRelease_Date() {
		return release_Date;
	}
	public void setRelease_Date(Date release_Date) {
		this.release_Date = release_Date;
	}
	public Integer getRuntime() {
		return runtime;
	}
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	public Float getVote_Avg() {
		return vote_Avg;
	}
	public void setVote_Avg(Float vote_Avg) {
		this.vote_Avg = vote_Avg;
	}
	public Integer getVote_Count() {
		return vote_Count;
	}
	public void setVote_Count(Integer vote_Count) {
		this.vote_Count = vote_Count;
	}
	public String getTag_Line() {
		return tag_Line;
	}
	public void setTag_Line(String tag_Line) {
		this.tag_Line = tag_Line;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
