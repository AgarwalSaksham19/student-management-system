import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='/style.css'>");
        out.println("</head><body>");

        out.println("<div class='card'>");
        out.println("<h2>Edit Student</h2>");
        out.println("<a href='home'>Home</a>");

        out.println("<form action='updateStudent' method='post'>");

        out.println("<input type='hidden' name='id' value='" + id + "'>");

        out.println("<input type='text' name='name' placeholder='Name' required>");
        out.println("<input type='number' name='age' placeholder='Age' required>");
        out.println("<input type='text' name='email' placeholder='Email' required>");
        out.println("<input type='text' name='course' placeholder='Course' required>");

        out.println("<button type='submit'>Update</button>");

        out.println("</form>");
        out.println("</div>");

        out.println("</body></html>");
    }
}