
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
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.print("id  "+id);
		out.println("name  "+ name);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do_list", "root", "");
			String sql = "UPDATE today_work SET name = ?, password = ? WHERE id = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, password);
			psmt.setString(3, id);

			int rowsUpdated = psmt.executeUpdate();

			if (rowsUpdated > 0) {
				// The update was successful
				response.sendRedirect("index.jsp");
			} else {
				// No rows were updated (user with given ID not found)
				response.getWriter().println("No employee found with the specified ID.");
			}

			psmt.close();
			conn.close();
		} catch (ClassNotFoundException | NumberFormatException e) {
			response.getWriter().println("Error: Database driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			response.getWriter().println("Error: SQL Exception - " + e.getMessage());
			e.printStackTrace();
		}

	}

}
