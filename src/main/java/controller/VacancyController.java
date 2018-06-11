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
import java.util.List;

@WebServlet(name = "VacancyController", urlPatterns = {"/vacancy"})
public class VacancyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if(action.equals("see")) {
           this.seeDetails(req, resp);
       } else if(action.equals("list")) {
           this.seeAll(req, resp);
       }
    }

    protected void seeAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        List<Vacancy> list = vacancyDao.getAll();
        conn.disconnectDB();

        req.setAttribute("vacancies", list);
        RequestDispatcher requestDispatcher;

        requestDispatcher = req.getRequestDispatcher("/vacancies.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void seeDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idVacancy = Integer.parseInt(req.getParameter("id"));
        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        Vacancy vacancy = vacancyDao.getById(idVacancy);
        conn.disconnectDB();

        req.setAttribute("vacancy", vacancy);
        RequestDispatcher requestDispatcher;

        requestDispatcher = req.getRequestDispatcher("/detail.jsp");
        requestDispatcher.forward(req, resp);
    }

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