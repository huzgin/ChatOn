<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- BootStrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Page</title>
</head>
<body style="background-color:#D3D3D3;">

<!-- Send msg box -->
<div class="container" >

  <form class="form-horizontal" action="msg_send" method="post">
<div class="form-group">
	<h4>Group Chat </h4>
  <textarea class="form-control" rows="15" id="comment"></textarea>
</div>
    <div class="form-group">
      <br>
      <label>Msg:</label>
      <input type="text" class="form-control " placeholder="Enter msg" name="msg">
    	<br>
  
    <button type="submit" class="btn">Submit</button>
      <input type="button" class="btn " value="Exit" onclick="location.href = 'index.jsp';">
    </div>
  </form>
</div>


</body>
</html>