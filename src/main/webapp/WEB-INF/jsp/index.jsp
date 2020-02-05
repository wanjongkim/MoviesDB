<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML lang="en">
	<head>       
		<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="Wan Jong Kim, MoviesDB, Movies, Database">
		<meta name="description" content="Website that shows you everything about movies">
		<!-- <link href="layout.css" rel="stylesheet">
		<link href="fonts.css" rel="stylesheet"> -->
		<link href="css/layout.css" rel="stylesheet">
		<link href="css/fonts.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Montserrat:800&display=swap" rel="stylesheet"> 
		<link href="https://fonts.googleapis.com/css?family=Arvo&display=swap" rel="stylesheet"> 
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Movies Database</title>
	</head>
	<body class="dark_gray">
		<div class="navbar">
			<div id="site_header" class="col_nowrap center">
				<span class="montserrat light_white">MoviesDB</span>
			</div>
			<div id="search">
			</div>
			<div class="row_nowrap center">
				<a href="" target="_blank"><img src="images/GitHub.png" alt="GitHub" width="32" height="32"></a>
			</div>
		</div>
		<div id="main" class="row_nowrap">
			<div class="side">
				<a href="/" class="menu current_page">
					<div class="menu_tags">
						<span class="current_page">New Releases</span>
					</div>
				</a>
				<a href="/popular" class="menu">
					<div class="menu_tags">
						<span>Popular</span>
					</div>
				</a>
				<a href="/coming" class="menu">
					<div class="menu_tags">
						<span>Coming Soon</span>
					</div>
				</a>
			</div>
			<c:forEach var="movie" items="${movies}" varStatus="loop">
				<div class="movie fade">
					<div class="trailer">
						<h1 class="light_white">${movie.movie.title}</h1>
						<div class="vid row_nowrap">
							<a onclick="slide(-1)" class="cursor_pointer"><img src="images/arrow.png" alt="Previous" width="32" height="32" style="transform: rotate(180deg);"></a>
							<iframe class="videos fade" src="https://www.youtube.com/embed/${movie.videos[0].videoId.path}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
							<a onclick="slide(1)" class="cursor_pointer"><img src="images/arrow.png" alt="Next" width="32" height="32"></a>
						</div>
					</div>
					<div class="movie_info">
						<p>${movie.movie.overview}</p>
						<p class="light_blue"">
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
			</c:forEach>
		</div>
		<!--Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a> -->
	<!-- <script src="main.js"></script> -->
	<script src="js/main.js"></script>
	</body>
</html>