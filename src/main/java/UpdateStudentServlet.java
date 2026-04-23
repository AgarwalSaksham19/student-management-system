import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        try {
            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);

            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name=?, age=?, email=?, course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.setString(4, course);
            ps.setInt(5, id);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("viewStudents");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}