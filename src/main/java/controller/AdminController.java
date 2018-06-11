package controller;

import dao.*;
import model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminController", value = {"/admin"})
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;
        String msg = "";

        switch (action) {
            case "login":
                if (session.getAttribute("person") == null) {
                    req.setAttribute("message", msg);
                    requestDispatcher = req.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    requestDispatcher = req.getRequestDispatcher("/admin.jsp");
                    requestDispatcher.forward(req, resp);
                }
                break;
            case "create":
                if (session.getAttribute("person") == null) {
                    msg = "Access Denied";
                    req.setAttribute("message", msg);
                    requestDispatcher = req.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    requestDispatcher = req.getRequestDispatcher("/frmvacancy.jsp");
                    requestDispatcher.forward(req, resp);
                }
                break;
            case "delete":
                if (session.getAttribute("person") == null) {
                    msg = "Access Denied";
                    req.setAttribute("message", msg);
                    requestDispatcher = req.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    this.deleteVacancy(req, resp);
                }
                break;
            case "logout":
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/homepage");
                break;
        }
    }

    private void deleteVacancy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int idVacancyParam = Integer.parseInt(req.getParameter("idVacancy"));
        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        int response = vacancyDao.delete(idVacancyParam);
        String msg;
        if (response == 1) {
            msg = "La vacancy was deleted correctly";
        } else {
            msg = "There was an error. The vacancy was not deleted";
        }
        conn.disconnectDB();
        req.setAttribute("message", msg);
        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/message.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userParam = req.getParameter("user");
        String passParam = req.getParameter("pass");
        String msg;

        HttpSession session = req.getSession();

        ConnectDB conn = new ConnectDB();
        PersonDao personDao = new PersonDaoImpl(conn);

        Person person = personDao.login(userParam, passParam);
        conn.disconnectDB();

        RequestDispatcher requestDispatcher;

        if (person.getId() >= 0) {
            session.setAttribute("person", person);
            requestDispatcher = req.getRequestDispatcher("/admin.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            msg = "user and/or password incorrect";
            req.setAttribute("message", msg);
            requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}
