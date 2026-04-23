import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='/style.css'>");
        out.println("</head><body>");

        out.println("<h2>Student List</h2>");
        out.println("<a class='home-btn' href='home'>Home</a>");
        out.println("<a href='addStudent.html'>Add Student</a><br><br>");

        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Course</th><th>Actions</th></tr>");

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                int id = rs.getInt("id");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getInt("age") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");

                out.println("<td>");
                out.println("<a href='editStudent?id=" + id + "'>Edit</a> ");
                out.println("<a href='deleteStudent?id=" + id + "'>Delete</a>");
                out.println("</td>");

                out.println("</tr>");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}