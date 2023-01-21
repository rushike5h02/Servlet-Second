package com.second;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username = request.getParameter("username");
			System.out.println("username>>" + username);
			String password = request.getParameter("password");
			System.out.println("password>>" + password);
			
	         Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement stmt = con.prepareStatement("insert into servlate(username,password)values(?,?)");

			
			stmt.setString(1, username ); //1 first parameter in query.
			stmt.setString(2,  password);
			

			int i=stmt.executeUpdate();
			
			System.out.println("Record is inserted."+i);

			con.close();
			stmt.close();
			//}
			//System.out.println("table updated succefully");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
