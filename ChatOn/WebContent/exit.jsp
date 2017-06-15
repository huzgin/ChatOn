<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- BootStrap--> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style> 
.button {color: white;}
.round { border-radius: 0px 20px;}
.round2 { border-radius: 0px 50px;}
.collight{background-color:#48CFAD;}
.coldark{background-color:#37BC9B;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bye :(</title>
</head>
<body class="collight" >
<%
		String cemail = null;
		Cookie c[] = request.getCookies();
		c[0].setMaxAge(0);
%>
<div class="row round coldark" >
<br>
<br>
	<div class="container  round " >
		<div class="col-md-12  round2 collight" >
			<center><h1 class="form-signin-heading">Bye Bye :(</h1></center>
			<center><h3> Click Below To Go back to home.</h3> </center>
			<center><input type="button" class="btn btn-lg button round coldark" value="Home" onclick="location.href = 'index.jsp';"></center>
			<br>
		</div>
		
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
</body>
</html>