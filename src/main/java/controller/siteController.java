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

@WebServlet(name = "siteController", urlPatterns = {"/homepage"})
public class siteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;
        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);
        List<Vacancy> list = vacancyDao.getRecent();
        conn.disconnectDB();
        req.setAttribute("recent", list);
        requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
