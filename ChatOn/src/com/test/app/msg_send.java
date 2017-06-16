package com.test.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
	Statement stmt = null;
	String Query = "insert into chatdata values(?,?,?)";
	/*String Query2 = "select * from Chatdata order by msgdate ASC";
	
	String[] sender1 = new String[1000];
	String[] date1 = new String[1000];
	String[] msg1 = new String[1000];
	int i =0;
	*/
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
		response.setContentType("text/html");
		String msg = request.getParameter("msg");
		//PrintWriter out = response.getWriter();
		SimpleDateFormat newdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		Date date = new Date(); 
		String dateString=newdate.format(date);
		//System.out.println(dateString);
		String email = null;
		
		Cookie c[] = request.getCookies();
			email = c[0].getValue();
		
		try {
			ctx = new InitialContext();
			//System.out.println("Context Running");
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			con = ds.getConnection();
			ps = con.prepareStatement(Query);
			ps.setString(1, dateString);
			ps.setString(2, msg);
			ps.setString(3, email);
			int retval = ps.executeUpdate();
			if(retval == 1)
			{
				
				request.getRequestDispatcher("chat_home.jsp").forward(request, response);
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
			request.getRequestDispatcher("chat_home.jsp").forward(request, response);
		}
		}
		
	}
