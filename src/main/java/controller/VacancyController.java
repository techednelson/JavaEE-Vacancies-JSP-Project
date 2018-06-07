package controller;

import model.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class VacancyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String details = request.getParameter("details");

        Vacancy vacancy = new Vacancy(0);


    }
}