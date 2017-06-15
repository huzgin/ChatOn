package com.test.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class sign_up
 */
@WebServlet("/sign_up")
public class sign_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String Query = "insert into users values(?,?)";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_up() {
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
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			PrintWriter out = response.getWriter();
			StringBuilder htmlBuilder2 = new StringBuilder();
			htmlBuilder2.append("<html>");
			htmlBuilder2.append("<head>");
			htmlBuilder2.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
			htmlBuilder2.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
			htmlBuilder2.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
			htmlBuilder2.append("<style> .button {color: white;} .round { border-radius: 0px 20px;} .round2 { border-radius: 0px 50px;} .collight{background-color:#26C281;} .coldark{background-color:#006442;} </style>");
			htmlBuilder2.append("</head>");
			htmlBuilder2.append("<body class='coldark'><div class='container round collight'>");
			htmlBuilder2.append(" <br> <br><center> <h2>Don't leave this blank! Enter a value. Go back and do this again </h2></center> ");
			htmlBuilder2.append("<center><a href='index.jsp' class='btn btn-lg button'><h1>Home</h1></a></center>");
			htmlBuilder2.append("</div></body>");
			htmlBuilder2.append("</html>");
			String html2 = htmlBuilder2.toString();
			
			if(mail.equals(null) || pass.equals(null))
			{
				out.println(html2);
			}
			else
			{
			
			// Creating A String to Confirm Registration
			StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html>");
			htmlBuilder.append("<head>");
			htmlBuilder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
			htmlBuilder.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
			htmlBuilder.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
			htmlBuilder.append("<style> .button {color: white;} .round { border-radius: 0px 20px;} .round2 { border-radius: 0px 50px;} .collight{background-color:#26C281;} .coldark{background-color:#006442;} </style>");
			htmlBuilder.append("</head>");
			htmlBuilder.append("<body class='coldark'><div class='container round collight'>");
			htmlBuilder.append(" <br> <br><center> <h1>Congrats! You're one of us now! </h1></center> ");
			htmlBuilder.append("<center><a href='index.jsp' class='btn btn-lg button'><h1>Home</h1></a></center>");
			htmlBuilder.append("</div></body>");
			htmlBuilder.append("</html>");
			String html = htmlBuilder.toString();
			// End Of confirmation String
			
			ctx = new InitialContext();
			System.out.println("Context Running");
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			con = ds.getConnection();
			ps = con.prepareStatement(Query);
			ps.setString(1, mail);
			ps.setString(2, pass);
			int retval = ps.executeUpdate();
			if(retval == 1)
			{
				out.println(html);
			}
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
