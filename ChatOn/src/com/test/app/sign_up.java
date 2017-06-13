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
			String un = request.getParameter("username");
			String pass = request.getParameter("password");
			PrintWriter out = response.getWriter();
			
			// Creating A String to Confirm Registration
			StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html>");
			htmlBuilder.append("<head>");
			htmlBuilder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
			htmlBuilder.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
			htmlBuilder.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
			htmlBuilder.append("</head>");
			htmlBuilder.append("<body>");
			htmlBuilder.append(" <br> <br><center> <h1>Congrats! You're one of us now! </h1></center> ");
			htmlBuilder.append("<center><input type='button' class='btn btn-lg' value='Go To Home' onclick='location.href = 'index.jsp';'></center>");
			htmlBuilder.append("</body>");
			htmlBuilder.append("</html>");
			String html = htmlBuilder.toString();
			// End Of confirmation String
			
			ctx = new InitialContext();
			System.out.println("Context Running");
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			con = ds.getConnection();
			ps = con.prepareStatement(Query);
			ps.setString(1, un);
			ps.setString(2, pass);
			System.out.println("Retval Called");
			int retval = ps.executeUpdate();
			System.out.println("Retval is:"+ retval);
			if(retval == 1)
			{
				out.println(html);
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
