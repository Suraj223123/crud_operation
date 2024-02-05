import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class contactus extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public contactus() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do_list", "root", "");

            String sql = "insert into contact_us (name, email, message) value (?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, message);

            int rs = pst.executeUpdate();
             PrintWriter out = response.getWriter();
            		 out.print("thank you Your message submit  ");
            response.sendRedirect("index.jsp");

            conn.close();
            pst.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception properly, e.g., log or display an error message
        }
    }
}
