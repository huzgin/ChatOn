package com.test.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class msg_send
 */
@WebServlet("/msg_send")
public class msg_send extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String Query = "insert into chatdata values(?,?,?)";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public msg_send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<head>");
		htmlBuilder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		htmlBuilder.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
		htmlBuilder.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
		htmlBuilder.append("</head>");
		htmlBuilder.append("<body>");
		htmlBuilder.append(" <br> <br><center> <h1>Msg Sent</h1></center> ");
		htmlBuilder.append("<center><a href='chat_home.jsp' class='btn btn-lg'><h1>Home</h1></a></center>");
		htmlBuilder.append("</body>");
		htmlBuilder.append("</html>");
		String html = htmlBuilder.toString();
		
		
		response.setContentType("text/html");
		String msg = request.getParameter("msg");
		if(msg==null)
		{
			request.getRequestDispatcher("chat_home.jsp").forward(request, response);
		}
		PrintWriter out = response.getWriter();
		
		

		SimpleDateFormat newdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		Date date = new Date(); 
		String dateString=newdate.format(date);
		System.out.println(dateString);
		String email = null;
		
		Cookie c[] = request.getCookies();
		for(Cookie c1: c)
		{
			email = c1.getName();
		
			System.out.println(email);
		}
		
		
		try {
			ctx = new InitialContext();
			System.out.println("Context Running");
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			con = ds.getConnection();
			ps = con.prepareStatement(Query);
			ps.setString(1, dateString);
			ps.setString(2, msg);
			ps.setString(3, email);
			int retval = ps.executeUpdate();
			if(retval == 1)
			{
				out.println(html);
			}
			request.getRequestDispatcher("chat_home.jsp").forward(request, response);
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
		
	}

}
