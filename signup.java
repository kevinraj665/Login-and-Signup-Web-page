package p1;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="jdbc:mysql://localhost:3306/reddit";
		String username="root";
		String pass="test";
		
		
		String Firstname=request.getParameter("firstname");
		String Lastname=request.getParameter("lastname");
		String Email=request.getParameter("email");
		String Username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("password");
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, pass);
			Statement stmt=con.createStatement();
			int x=stmt.executeUpdate("insert into signup values('"+Firstname+"','"+Lastname+"','"+Email+"','"+Username+"','"+password+"','"+confirmpassword+"')");
			if(x>0) {
				p.println("<p font-size='20'>Signed up succesfully !!</p>");
			}
			else{
				p.println("<p font-size='20'>signed up failed !!</p>");
				p.println("<a font color='red' font-size='20' href='Signup.jsp'>try again </a>");
				p.println( "<a href='delete.jsp'>to delete your account....!!</a>");
			}
		
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}


		
	}


