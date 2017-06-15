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
.collight{background-color:#26C281;}
.coldark{background-color:#006442;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body class="collight" >

<div class="row round coldark" >
<br>
<br>
	<div class="container  round " >
		<div class="col-md-12  round2 collight" >
			<center><h1 class="form-signin-heading">Welcome to ChatOn.</h1></center>
			<center><h3> Click Below To Log In: </h3> </center>
			<center><input type="button" class="btn btn-lg button round coldark" value="Log In" onclick="location.href = 'log_in.jsp';"></center>
			<center><h3> New here? Click Below to Sign Up: </h3></center>
			<br>
			<center><input type="button" class="btn btn-lg  button round coldark" value="Sign Up" onclick="location.href = 'sign_up.jsp';"></center>
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