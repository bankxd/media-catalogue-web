<%@page import="za.co.sfy.domain.ApplicationSettings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Media Catalogue V3</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div id="container">
		<div class="w3-row" id="topbar">
			<div class="w3-third">
				<a><img src="Images/mediaCatImg.png" /></a>
			</div>
			<div class="w3-twothird" style="text-decoration: none;" id="navBar">
				<a href="index.jsp" id="navelement">Home</a> <a href="about.jsp" id="navelement">About</a>
				<a href="cataloguehome.jsp" id="navelement">Catalogue</a> <a href="websettings.jsp" id="navelement">Web-Settings</a>
			</div>
		</div>
		<div id="midbar">
			<div id="midblock">
				<h1 style="font-size: 15px; text-align: left; margin-left: 10px">
					About</h1>
				<hr>
				<div style="margin: 20px;">
					<a><img src="Images/mediaCatImg.png" /></a>
				</div>
				<p id="midtext"> Media Catalogue V3 allows users to add, update, delete and view all media types in the database.</p>
				<br>
				<hr>
			</div>
		</div>
		<div id="footerbar">
			<p id="footerText">© 2020 Media Catalogue</p>
		</div>
	</div>
</body>
<% ApplicationSettings appSett = (ApplicationSettings) request.getSession().getAttribute("ApplicationSettings"); %>
<style>
html{
    --theme-color-1: <%= appSett.getBackgroundColour1() %>;
    --theme-color-2: <%= appSett.getBackgroundColour2() %>;
    --font-style: <%= appSett.getFontStyle() %>;
}
body {
	font-family: var(--font-style);
	font-size: 19px;
}

#container {
	margin: 5% auto 5% auto;
	padding: 5px 5px 5px 5px;
	border: 5px solid white;
	width: 50%;
	overflow: auto;
	box-shadow: 2px 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	text-align: center;
	font-size: 22px;
	position: relative;
}

#topbar {
	background-color: var(--theme-color-1);
	width: 100%;
	height: 61px;
	position: relative;
}

#midbar {
	background-color: var(--theme-color-2);
	width: 100%;
	height: 320px;
	justify-content: center;
	align-items: center;
	display: flex;
}

#navelement:hover {
	text-decoration: underline;
}

#navelement {
	text-decoration: none;
	padding: 15px;
}

#footerbar {
	background-color: var(--theme-color-1);
	width: 100%;
	height: 55px;
}

#navBar {
	font-size: 19px;
	color: white;
	margin-top: 18px;
	display: inline-block;
}

#footerText {
	color: white;
	font-size: 16px;
	position: absolute;
	left: 10px;
}

#midblock {
	width: 60%;
	height: 90%;
	background-color: #D3D3D3;
	margin: 0% auto 0% auto;
	padding: 5px 5px 5px 5px;
	border: 1px solid black;
	border-radius: 25px;
	position: relative;
}

#midtext{
	font-size: 14px;
	margin: 20px;
}

hr {
    height: 0px;
    border: none;
    border-top: 1px solid black;
	margin: 8px 8px 8px 8px;
}
</style>
</html>