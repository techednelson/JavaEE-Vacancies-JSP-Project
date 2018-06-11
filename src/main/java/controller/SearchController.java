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

@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = req.getParameter("query");
        List<Vacancy> list;
        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        list = vacancyDao.getByQuery(query);
        conn.disconnectDB();
        RequestDispatcher requestDispatcher;
        req.setAttribute("vacancies", list);
        requestDispatcher = req.getRequestDispatcher("/vacancies.jsp");
        requestDispatcher.forward(req, resp);
    }
}
