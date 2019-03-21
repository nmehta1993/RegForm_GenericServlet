package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;




/**
 * Servlet implementation class RegFormServlet
 */
@WebServlet("/RegFormServlet")
public class RegFormServlet extends GenericServlet{
	
       

	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email= req.getParameter("email");
		String address=req.getParameter("address");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			java.sql.PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3,email);
			pst.setString(4, address);
			int i=pst.executeUpdate();
			if(i>0) {
				out.println("Registration succses");
			}else {
				out.println("Registration fail");
			}
			
		} catch (Exception e) {
			out.println("Registration fail");
		}
	}

}
