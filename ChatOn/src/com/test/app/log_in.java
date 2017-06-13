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
	String Query = "select email,password from users;";
	String emails[]= new String [100];
	String passes[]= new String [100];
	int i=0;
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
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		
		try
		{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			con = ds.getConnection();
			ResultSet rs = stmt.executeQuery(Query);
			while(rs.next())
			{
				emails[i] = rs.getString("EMAIL");
				passes[i] = rs.getString("PASSWORD");
				i++;
			}
			
			len = emails.length;
			
			for(int j=0;j<len;j++)
			{
				if (emails[i].equals(mail) && passes[i].equals(pass))
				{
					out.println("Login successful");
				}
			}
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
