package com.test.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class log_in
 */
@WebServlet("/log_in")
public class log_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Context ctx;
	DataSource ds;
	Connection con;
	Statement stmt = null;
	String Query = "select * from users order by EMAIL ASC";
	String emails[]= new String [100];
	String passes[]= new String [100];
	int i=0,j=0;
	int len=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log_in() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//Values passed
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Cookie mailcookie = new Cookie("email",mail);
		response.addCookie(mailcookie);

		//System.out.println("Cookies added");
		
		PrintWriter out = response.getWriter();
		//System.out.println("Reached dopost");
		try
		{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			//System.out.println("DataSource Created");
			con = ds.getConnection();
			//System.out.println("Got Connection");
			stmt=con.createStatement();
			
			StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html>");
			htmlBuilder.append("<head>");
			htmlBuilder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
			htmlBuilder.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
			htmlBuilder.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
			htmlBuilder.append("<style> .button {color: white;} .round { border-radius: 0px 20px;} .round2 { border-radius: 0px 50px;} .collight{background-color:#48CFAD;} .coldark{background-color:#37BC9B;} </style>");
			htmlBuilder.append("</head>");
			htmlBuilder.append("<body class='coldark'> <br> <br><div class='container round collight'>");
			htmlBuilder.append(" <br> <br><center> <h3>Wrong Password! Click below to Retry. </h3></center> ");
			htmlBuilder.append("<center><input type='button' class='btn btn-lg button round coldark' value='Home' onclick='location.href = 'index.jsp';'>"); //<a href='index.jsp' class='btn btn-lg button'><h1>Home</h1></a></center>
			htmlBuilder.append("</div></body>");
			htmlBuilder.append("</html>");
			String html = htmlBuilder.toString();
			
			ResultSet rs = stmt.executeQuery(Query);
			//System.out.println("Query run");
			//System.out.println(rs.next());
			while(rs.next())
			{
				//System.out.println("In loop1");
				emails[i] = rs.getString("EMAIL");
				passes[i] = rs.getString("PASSWORD");
				//System.out.println("Emails:  "+emails[i]+" Pass:"+ passes[i]);
				i++;
			}
			//System.out.println("Out of loop1");
			len = i;
			i=0;
			//System.out.println("length is :" + len + "i is: " +i);
			for(j=0;j<len;j++)
			{
				
				if(mail.toString().equalsIgnoreCase(emails[j]))	
				{
					if(pass.toString().equalsIgnoreCase(passes[j]))	
					{
						request.getRequestDispatcher("chat_home.jsp").forward(request,response);
					}
				}
				
			}
			if(j==len)
			{
			//System.out.println("Going to index");
			out.println(html);
			}
			rs.close();
			stmt.close();
			con.close();
			ctx.close();
		} 
		catch (NamingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
