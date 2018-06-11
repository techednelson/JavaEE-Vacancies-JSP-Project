package controller;

import services.Mail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EmailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("destiny");
        String asunto = request.getParameter("subject");
        String mensaje = request.getParameter("message");
        String msg=null;
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        try {
            if (session.getAttribute("person") != null) {

                Mail mail = new Mail();

                msg = mail.sendMail(email, asunto,mensaje);
                request.setAttribute("message", msg);
                rd = request.getRequestDispatcher("/message_admin.jsp");
                rd.forward(request, response);
            } else {
                msg = "User and/or password incorrect";
                request.setAttribute("message", msg);
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error: EmailController.doPost: " + e.getMessage());
        }

    }

}
