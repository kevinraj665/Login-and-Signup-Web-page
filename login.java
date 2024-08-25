package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public login() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="jdbc:mysql://localhost:3306/reddit";
		String username="root";
		String password="test";
		String query="select username from signup where username=? and password=?";
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
	
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
		
			ResultSet rs=ps.executeQuery();
		    
			if(rs.next()) {
				p.println("<p font-size='200'>Login successful!!!</p>");
				
			
			}
				else {
					p.println("<p font-size='200'>login failed</p>");
					p.println("<a font-size='200' href='login.jsp'>Try again</a>");
				}
				
			con.close();	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
