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
	String Query = "select * from users";
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
		//Values passed
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Cookie mailcookie = new Cookie("email",mail);
		
		response.addCookie(mailcookie);

		System.out.println("Cookies added");
		
		PrintWriter out = response.getWriter();
		System.out.println("Reached dopost");
		try
		{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/lib_db");
			//System.out.println("DataSource Created");
			con = ds.getConnection();
			//System.out.println("Got Connection");
			stmt=con.createStatement();
			
			/*StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html>");
			htmlBuilder.append("<head>");
			htmlBuilder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
			htmlBuilder.append(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'> ");
			htmlBuilder.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
			htmlBuilder.append("</head>");
			htmlBuilder.append("<body>");
			htmlBuilder.append(" <br> <br><center> <h1>Yaay! You're one of us! </h1></center> ");
			htmlBuilder.append("<center><a href='chat_home.jsp' class='btn btn-lg'><h1>Home</h1></a></center>");
			htmlBuilder.append("</body>");
			htmlBuilder.append("</html>");
			String html = htmlBuilder.toString(); edit*/
			
			ResultSet rs = stmt.executeQuery(Query);
			//System.out.println("Query run");
			//System.out.println(rs.next());
			while(rs.next())
			{
				System.out.println("In loop");
				emails[i] = rs.getString("EMAIL");
				passes[i] = rs.getString("PASSWORD");
				//System.out.println("Email: "+emails[i]+" Pass: " + passes[i]);
				i++;
			}
			//System.out.println("Out of loop");
			len = i-1;
			//System.out.println("length is :" + len);
			int flag=1;
			for(int j=0;j<len;j++)
			{
				//System.out.println(j);
				if(mail.toString().equals(emails[j]))	
				{
					if(pass.toString().equals(passes[j]))	
					{
						//out.println(html);
						flag=0;
						request.getRequestDispatcher("chat_home.jsp").forward(request,response);
					}
				}
				
			}
			if(flag!=1)
			{
			System.out.println("Going to index");
			request.getRequestDispatcher("index.jsp").forward(request,response);
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
