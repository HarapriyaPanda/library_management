package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.user;
import userDao.userDao;
import java.io.IOException;
@WebServlet("/submitservlet")
public class submitservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name= req.getParameter("name");
     String author_name=req.getParameter("author_name");
     int price= Integer.parseInt(req.getParameter("price"));
     String publisher =req.getParameter("publisher");
     int isbn= Integer.parseInt(req.getParameter("isbn"));

     user u = new user();
     u.setName(name);
     u.setAuthor_name(author_name);
     u.setPrice(price);
     u.setPublisher(publisher);
     u.setIsbn(isbn);
     userDao.saveDetails(u);

    }
}
