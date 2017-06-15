<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script><style> 
.button {color: white;}
.round { border-radius: 0px 20px;}
.round2 { border-radius: 0px 50px;}
.collight{background-color:#48CFAD;}
.coldark{background-color:  #37BC9B;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body class="coldark">
<br>
<br>
<div class="container collight round2"  >
<center><h1 class="form-signin-heading">Come Join The Group.</h1></center>
<form class="form-horizontal" action="sign_up" method="post">
    <br>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pass">Password:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control"name="pass">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-12">
        <center><button type="submit" class="btn btn-lg button round coldark">Let's Go!</button></center>
      </div>
    </div>
  </form>
</div>



</body>
</html>