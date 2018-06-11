package controller;

import dao.ConnectDB;
import dao.PersonDao;
import dao.PersonDaoImpl;
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
