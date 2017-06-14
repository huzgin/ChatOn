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
<div class="container" >

  <form class="form-horizontal" action="msg_send" method="post">
<div class="form-group">
	<h4>Group Chat </h4>
  <!--  <textarea class="form-control" rows="15" id="comment"></textarea>-->
  
  <%
	Context ctx;
	DataSource ds;
	Connection con;
	Statement stmt = null;
	String Query2 = "select * from Chatdata order by msgdate ASC";
	
	String[] sender1 = new String[1000];
	String[] date1 = new String[1000];
	String[] msg1 = new String[1000];
	int i =0;
	
	try {
		ctx = new InitialContext();
		System.out.println("Context Running");
		ds = (DataSource)ctx.lookup("jdbc/lib_db");
		con = ds.getConnection();
		
		stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(Query2);
		while(rs.next())
		{
			System.out.println("In loop 2");
			sender1[i]=rs.getString("SENDER");
			date1[i] =rs.getString("MSGDATE");
			msg1[i] = rs.getString("MESSAGE");
			i++;
		}
		int len = i;
		
		for(int j=0;j<len;j++)
		{
			out.println("Sender: "+sender1[j]+"on: "+date1[j]+"Msg: "+msg1[j]);
		}
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