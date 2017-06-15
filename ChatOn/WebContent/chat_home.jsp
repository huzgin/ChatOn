<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- BootStrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style> 
.button {color: white;}
.round { border-radius: 0px 20px;}
.round2 { border-radius: 0px 50px;}
.collight{background-color:#48CFAD;}
.coldark{background-color:  #37BC9B;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Page</title>
</head>
<body class="coldark">
<br>
<br>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="javax.naming.Context"  %>
<%@ page import=" javax.sql.DataSource"  %>
<%@ page import= "javax.naming.InitialContext" %>
<%@ page import= "javax.naming.NamingException" %>
<%@ page import= "java.sql.SQLException"%>
<!-- Send msg box -->
<div class="container collight round2" >

  <form class="form-horizontal row-md-8 " action="msg_send" method="post">
<center><div class=" button col-db-2">
	<h1>Group Chat </h1>
</div> </center>
    <div class="container round " >
    <div class="form-group col-xs-12">
      <label>Msg:</label>
      <input type="text" class="form-control" placeholder="Enter msg" name="msg">
    	<br>
    <button type="submit" class="btn">Submit</button>
    <input type="button" class="btn " value="Exit" onclick="location.href = 'exit.jsp';">
    </div>
    </div>
  </form>

  <%
	Context ctx;
	DataSource ds;
	Connection con;
	Statement stmt = null;
	String Query2 = "select * from Chatdata order by msgdate DESC";
	
	String[] sender1 = new String[1000];
	String[] date1 = new String[1000];
	String[] msg1 = new String[1000];
	int i =0;
	try {
		ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("jdbc/lib_db");
		con = ds.getConnection();
		
		
		String cemail = null;
		
		stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(Query2);
		while(rs.next())
		{
			
			sender1[i]=rs.getString("SENDER");
			date1[i] =rs.getString("MSGDATE");
			msg1[i] = rs.getString("MESSAGE");
			i++;
		}
		int len = i;
		out.println("<div class='container button'> <div class='table-responsive'> <table class='table'> <thead> <tr> <th>Sender</th> <th>Time</th> <th>Message</th></tr> </thead> <tbody>");
		for(int j=0;j<len;j++)
		{
			//out.println("<hr> <p style='font-size:10px'>"+sender1[j]+" on: "+date1[j]+"</p><h4> Msg: "+msg1[j]+"</h4>");
			out.println("<tr> <td>"+sender1[j]+"</td><td>"+date1[j]+"</td><td>"+msg1[j]+"</td></tr>");
		}
		out.println("</tbody> </table> <br></div></div>");
	} 
	catch (NamingException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		
	}
%>
</div>
<br>
<br>
</body>
</html>