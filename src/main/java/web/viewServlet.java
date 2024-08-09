package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import user.user;
import userDao.userDao;
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        userDao userdao = new userDao();
        List<user> list = userdao.selectUser();
        resp.setContentType("text/html");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Submitted Book Details</title>");

        out.print("<style>");
        out.print("table { width: 100%; border-collapse: collapse; margin: 20px 0; font-family: Arial, sans-serif; }");
        out.print("th, td { padding: 12px; text-align: left; border: 1px solid #ddd; }");
        out.print("th { background-color: #4CAF50; color: white; }");
        out.print("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.print("tr:hover { background-color: #ddd; }");
        out.print("a { text-decoration: none; color: #4CAF50; }");
        out.print("a:hover { color: #45a049; }");
        out.print(".btn-back {");
        out.print("display: inline-block;");
        out.print("margin-top: 20px;");
        out.print("padding: 10px 15px;");
        out.print("background-color: #007bff;");
        out.print("color: white;");
        out.print("text-decoration: none;");
        out.print("border-radius: 5px;");
        out.print("text-align: center;");
        out.print("}");
        out.print(".btn-back:hover {");
        out.print("background-color: #0056b3;");
        out.print("}");
        out.print("</style>");

        out.print("</head>");
        out.print("<body>");

        // Display the submitted book details in a table
        out.print("<table>");
        out.print("<tr>");
        out.print("<th>ID</th>");
        out.print("<th>Book Name</th>");
        out.print("<th>Author Name</th>");
        out.print("<th>Price</th>");
        out.print("<th>Publisher</th>");
        out.print("<th>ISBN</th>");
        out.print("<th>Edit</th>");
        out.print("<th>Delete</th>");
        out.print("</tr>");

        for (user book : list) {
            out.print("<tr>");
            out.print("<td>" + book.getSlno() + "</td>");
            out.print("<td>" + book.getName() + "</td>");
            out.print("<td>" + book.getAuthor_name() + "</td>");
            out.print("<td>" + book.getPrice() + "</td>");
            out.print("<td>" + book.getPublisher() + "</td>");
            out.print("<td>" + book.getIsbn() + "</td>");
            out.print("<td><a href='useridServlet?slno=" + book.getSlno() + "'>Edit</a></td>");
            out.print("<td><a href='deleteServlet?slno=" + book.getSlno() + "'>Delete</a></td>");
            out.print("</tr>");
        }

        out.print("</table>");

        // Add a back button to navigate to the form page
        out.print("<a href='index.jsp' class='btn-back'>Back</a>");

        out.print("</body>");
        out.print("</html>");
    }
}
