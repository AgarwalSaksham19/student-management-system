import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String course = request.getParameter("course");
        String email = request.getParameter("email");


        try {
            if (name == null || ageStr == null || course == null || email == null ||
                    name.isEmpty() || ageStr.isEmpty() || course.isEmpty() || email.isEmpty()) {
                throw new RuntimeException("All fields are required");
            }

            int age = Integer.parseInt(ageStr);

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("viewStudents");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}