<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML lang="en">
	<head>
		<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="Wan Jong Kim, MoviesDB, Movies, Database">
		<meta name="description" content="Website that shows you everything about movies">
		<link href="css/layout.css" rel="stylesheet">
		<link href="css/fonts.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Cardo:400,700" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Archivo+Black" rel="stylesheet">
		<title>Movies Database</title>
	</head>
	<body>
		<div class="full_page">
			<img class="bg full_page" src="images/background.jpg" alt="">
			<div class="title"> 
				<h1 class="oswald big yellow">MoviesDB</h1>
				<p class="cardo light_grey medium website_desc">Find All Your Movie Needs Here</p>
				<br/>
				<a href="https://github.com/wanjongkim/MoviesDB" target="_blank"><img id="github" src="images/GitHub-Mark-Light-64px.png" width="32" height="32" alt="GitHub"></a>
				<a href="https://www.linkedin.com/in/wanjongkim/" target="_blank"><img src="images/LI-In-Bug.png" width="32" height="32" alt="LinkedIn"></a>
			</div>
		</div>
		
		<div class="flex_col_wrap" id="now_playing">
			<div class="flex_row">
				<h1 class="medium_big archivo orange">Now Playing</h1>
			</div>
			<c:forEach var="movie" items="${movies}" varStatus="loop">
				<a href="/movie/${movie.movie.id}" class="no_deco overview_link">
					<div class="flex_row bg_white link">
						<img class="movies_img" alt="Image not found" src="https://image.tmdb.org/t/p/w500${movie.movie.poster}">
						<div class="flex_col movies_desc">
							<h3 class="small_medium">${movie.movie.title}</h3>
							<p class="margin_items small">${movie.movie.overview}</p>
							<p class="small">
								<c:forEach var="genres" items="${movie.genres}" varStatus="loop2">
									<c:if test="${not loop2.last}">
										${genres.type},
									</c:if> 
									<c:if test="${loop2.last}">
										${genres.type}
									</c:if> 
								</c:forEach>
							</p>
						</div>
					</div>
				</a>
			</c:forEach>
			</a>
		</div>
	</body>
</HTML>