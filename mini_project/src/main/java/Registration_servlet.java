

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Registration_servlet
 */
public class Registration_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name  = request.getParameter("name");	
		String password  = request.getParameter("password");	
		
       
        
        try { 
        	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do_list","root","");
			
			 
			
			String sql = "insert into today_work (name, password) value (?,?)";
        	
        	PreparedStatement pst = conn.prepareStatement(sql);
        	pst.setString(1, name);
        	pst.setString(2, password);
        	
        	int rs = pst.executeUpdate();
        	
       
        		response.sendRedirect("login.jsp");
      
        	   conn.close();
        	   pst.close();
        	      
        	
        	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
		
	}

}
