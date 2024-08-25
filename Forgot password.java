package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="jdbc:mysql://localhost:3306/reddit";
		String username="root";
		String password="test";
		String query="update signup set password=?,confirmpassword=? where username=?";
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		String confirmpass=request.getParameter("password");
	
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, confirmpass);
			ps.setString(3, user);
		
			
		    int x= ps.executeUpdate();
			if(x>0) {
		
				RequestDispatcher r=request.getRequestDispatcher("welcome.jsp");
				r.forward(request, response);
				p.println("<p size='300'>Updated successfully!!!</p>");
				
			}
				else {
					p.println("<p size='300'>not updated</p>");
					p.println("<a font-size='200' href='create.jsp'>Try again</a>");
				}
				
			con.close();	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
