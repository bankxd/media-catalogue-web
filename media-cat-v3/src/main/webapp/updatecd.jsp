<%@page import="za.co.sfy.domain.ApplicationSettings"%>
<%@page import="za.co.sfy.domain.CD"%>
<%@page import="za.co.sfy.domain.DVD"%>
<%@page import="za.co.sfy.domain.MediaType"%>
<%@page import="java.util.ArrayList"%>
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
				<a href="index.jsp" id="navelement">Home</a> <a href="about.jsp"
					id="navelement">About</a> <a href="cataloguehome.jsp" id="navelement">Catalogue</a>
				<a href="websettings.jsp" id="navelement">Web-Settings</a>
			</div>
		</div>
		<div id="midbar">
		<%CD cd = (CD) request.getSession().getAttribute("selectedCD"); %>
			<div id="midblock">
				<form action="server" method="POST">
					<h1>
						Update <%= cd.getTitle() %>:
						<button type="submit" name="tablebut" value="submitcdupdate">Update</button>
					</h1>
					<hr>
					<div id="formdiv">
						<label><b>Title</b></label><br> <input type="text" placeholder="<%= cd.getTitle() %>" name="titlefieldcd" required><br>
						<label><b>Duration</b></label><br> <input type="text" name="lengthfieldcd" required><br>
						<label><b>Genre</b></label><br> <input type="text" name="genrefieldcd" required><br>
						<label><b>Tracks</b></label><br> <input type="text" name="tracksfield" required><br>
						<label><b>Artists</b></label><br> <input type="text" name="artistsfield" required><br>
						<br>
					</div>
				</form>
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
	font-size: 15px;
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
	position: relative;
}

#topbar {
	background-color: var(--theme-color-1);
	width: 100%;
	height: 61px;
	position: relative;
	overflow: hidden;
}

#midbar {
	background-color: var(--theme-color-2);
	width: 100%;
	height: 320px;
	justify-content: center;
	align-items: center;
	display: flex;
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
	overflow: hidden;
}

hr {
    height: 0px;
    border: none;
    border-top: 1px solid black;
	margin: 8px 7px 8px 7px;
}

#navelement {
	text-decoration: none;
	padding: 15px;
}

button {
	background-color: var(--theme-color-1);
	border: none;
	color: white;
	padding-left: 10px;
	padding-right: 10px;
	transition-duration: 0.4s;
	font-size: 16px;
}

button:hover {
	background-color: var(--theme-color-2);
	color: white;
}

#navelement:hover {
	text-decoration: underline;
}

table {
	font-size: 10px;
	border-collapse: collapse;
	width: 100%;
	border-radius: 5px;
}

.tablediv {
	overflow-y: auto;
	height: 198px;
	margin: 12px 8px 14px 8px;
}

.tablediv thead th {
	position: sticky;
	top: 0;
}

table, td, th {
	border: 1px solid black;
}

th {
	background-color: teal;
	color: white;
}

h1 {
	text-align: left;
	margin: 4px 10px 2px 10px;
	font-size: 12px;
}

form {
	margin: 4px 8px 4px 8px;
	left: 10px;
	font-size: 11px;
}

#formdiv {
	height: 200px;
}
</style>
</html>
