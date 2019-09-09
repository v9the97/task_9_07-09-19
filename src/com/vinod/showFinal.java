package com.vinod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Application;

/**
 * Servlet implementation class showFinal
 */
@WebServlet("/showFinal")
public class showFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//PrintWriter out=response.getWriter();
    	
    	String name=request.getParameter("name");
    	int dot=name.lastIndexOf('.');
    	String extention=name.substring(dot);
    	
    	FileInputStream fin=new FileInputStream("d:/vinod/"+name);
    	byte b[]=new byte[fin.available()];
    	fin.read(b);
     ServletOutputStream sout=response.getOutputStream();
    	if(extention.equals(".pdf"))
    	{
   response.setContentType("Application/pdf");	
    	}
    	else if(extention.equals(".docx"))
    	{
    		response.setContentType("Application/msword");	
    	}
    	sout.write(b);
    	sout.close();
    	
		
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
