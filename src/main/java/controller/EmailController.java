package controller;

import services.Mail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmailController", urlPatterns = {"/email"})
public class EmailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("destiny");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");
        String msg = null;
        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;
        try {
            if (session.getAttribute("person") != null) {

                Mail mail = new Mail();

                msg = mail.sendMail(email, subject,message);
                req.setAttribute("message", msg);
                requestDispatcher = req.getRequestDispatcher("/message_admin.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                msg = "User and/or password incorrect";
                req.setAttribute("message", msg);
                requestDispatcher = req.getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("Error: EmailController.doPost: " + e.getMessage());
        }

    }

}
