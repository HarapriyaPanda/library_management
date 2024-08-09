package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.user;
import userDao.userDao;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author_name = req.getParameter("author_name");
        int price = Integer.parseInt(req.getParameter("price"));
        String publisher = req.getParameter("publisher");
        int isbn = Integer.parseInt(req.getParameter("isbn"));
        int slno = Integer.parseInt(req.getParameter("slno"));
        user u = new user();
        u.setName(name);
        u.setAuthor_name(author_name);
        u.setPrice(price);
        u.setPublisher(publisher);
        u.setIsbn(isbn);
        u.setSlno(slno);
        int hp = userDao.updateUser(u);
        if (hp == 1) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Update Status</title>");

            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
            out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }");
            out.print("h2 { color: #4CAF50; }");
            out.print(".btn-back { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
            out.print(".btn-back:hover { background-color: #0056b3; }");
            out.print("</style>");

            out.print("</head>");
            out.print("<body>");

            out.print("<div class='container'>");
            out.print("<h2>Successfully Updated!</h2>");
            out.print("<a href='viewServlet' class='btn-back'>Back</a>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");
        } else {
            // Failed update
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Update Status</title>");

            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
            out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }");
            out.print("h2 { color: #f44336; }");
            out.print(".btn-back { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
            out.print(".btn-back:hover { background-color: #0056b3; }");
            out.print("</style>");

            out.print("</head>");
            out.print("<body>");

            out.print("<div class='container'>");
            out.print("<h2>Update Failed!</h2>");
            out.print("<a href='viewServlet' class='btn-back'>Back</a>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");
        }

    }
}
