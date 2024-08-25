package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="jdbc:mysql://localhost:3306/reddit";
		String username="root";
		String password="test";
		String query=" delete from signup where username=?";
		
		String user=request.getParameter("username");
		System.out.println(user);
		
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			System.out.println(con);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, user);
		
			
			int x=ps.executeUpdate();
			if(x>0) {
				p.println("<p font-size='20'>deleted succesfully !!</p>");
			}
				else {
				p.println("<p font-size='20'>not deleted !!</p>");
				}
			con.close();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		
	}


	
	}


