package controller;

import dao.ConnectDB;
import dao.VacancyDao;
import dao.VacancyDaoImpl;
import model.Vacancy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VacancyController", urlPatterns = {"/vacancy"})
public class VacancyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String details = req.getParameter("details");

        Vacancy vacancy = new Vacancy(0);
        vacancy.setVacancyName(name);
        vacancy.setDescription(description);
        vacancy.setDetails(details);

        System.out.println(vacancy);

        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        boolean status = vacancyDao.insert(vacancy);

        String msg = "";
        if(status) {
            msg = "The vacancy was saved correctly";
        } else {
            msg = "There was an error. The vacancy was not saved";
        }
        conn.disconnectDB();

        req.setAttribute("message", msg);

        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/mensaje.jsp");
        requestDispatcher.forward(req, resp);
    }
}