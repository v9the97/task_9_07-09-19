package com.vinod;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class book
 */
@WebServlet("/book")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod", "root", "root");

		
    	
    	String BookName,AudhorName,subject,date;
    	int price;
		PrintWriter out=response.getWriter();
				 
   BookName=request.getParameter("name");	 
   subject=request.getParameter("subject");	 
    price=Integer.parseInt(request.getParameter("price"));	 
   
    
    PreparedStatement stmt= con.prepareStatement("insert into book(name,subject,price) values(?,?,?)");  
    stmt.setString(1,BookName);//1 specifies the first parameter in the query  
    stmt.setString(2,subject);  
    stmt.setInt(3,price);//1 specifies the first parameter in the query  
    
    int i=stmt.executeUpdate();  
    out.print("successfully added ");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	
	}

}
