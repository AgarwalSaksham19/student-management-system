import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='/style.css'>");
        out.println("</head><body>");

        out.println("<div class='card'>");

        out.println("<h2>Welcome admin</h2><br>");

        out.println("<a href='addStudent.html'>Add Student</a><br><br>");
        out.println("<a href='viewStudents'>View Students</a><br><br>");
        out.println("<a href='logout'>Logout</a>");

        out.println("</div>");

        out.println("</body></html>");
    }
}