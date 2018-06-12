package controller;

import dao.*;
import model.Application;
import model.Vacancy;
import services.Utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ApplicationController", urlPatterns = {"/application"})
public class ApplicationController extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nameParam = req.getParameter("name");
        String emailParam = req.getParameter("email");
        String phoneParam = req.getParameter("phone");
        String addressParam = req.getParameter("address");
        int idVacancyParam = 0;

        if(req.getParameter("idVacancy") != null) {
           idVacancyParam = Integer.parseInt(req.getParameter("idVacancy"));
        }

        Application application = new Application(0);
        application.setDate(new Date());
        application.setName(nameParam);
        application.setEmail(emailParam);
        application.setPhone(phoneParam);
        application.setAddress(addressParam);
        ConnectDB conn = new ConnectDB();
        VacancyDao vacancyDao = new VacancyDaoImpl(conn);

        Vacancy vacancy = vacancyDao.getById(idVacancyParam);

        application.setVacancy(vacancy);


        String applicationPath = req.getServletContext().getRealPath("");

        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        Part file = req.getPart("file");
        String fileParam = file.getSubmittedFileName();
        RequestDispatcher requestDispatcher;

        String msg;
        if (fileParam.endsWith("pdf") || fileParam.endsWith("doc") || fileParam.endsWith("docx")) {

            String fileUpload = Utility.randomAlphaNumeric(10) + fileParam.replace(" ", "_");

            application.setFile(fileUpload);

            ApplicationDao applicationDao = new ApplicationDaoImpl(conn);
            applicationDao.insert(application);
            conn.disconnectDB();
            msg = "<b>" + application.getName() + "</b> We have receive your CV."
                    + "<br> We will contact you as soon as possible.<br><br>Thanks.";
            req.setAttribute("message", msg);

            file.write(uploadFilePath + File.separator + fileUpload);
            requestDispatcher = req.getRequestDispatcher("/message_guest.jsp");
            requestDispatcher.forward(req, resp);
        } else {

            msg = "PDF, DOC y DOCX files allowed only";
            req.setAttribute("message", msg);

            req.setAttribute("application", application);

            req.setAttribute("vacancy", application.getVacancy());
            requestDispatcher = req.getRequestDispatcher("/frm_cv.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;
        switch (action) {
            case "applications":
                if (session.getAttribute("person") == null) {
                    requestDispatcher = req.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    this.seeApplications(req, resp);
                }
                break;
            case "respond":
                if (session.getAttribute("person") == null) {
                    requestDispatcher = req.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    this.respond(req, resp);
                }
                break;
        }

    }

    protected void seeApplications(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher;
        String msg = null;
        List<Application> list;
        ConnectDB conn = new ConnectDB();
        ApplicationDao applicationDao = new ApplicationDaoImpl(conn);
        list = applicationDao.getAll();
        conn.disconnectDB();

        req.setAttribute("message", msg);
        req.setAttribute("applications", list);
        requestDispatcher = req.getRequestDispatcher("/applications.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void respond(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        RequestDispatcher requestDispatcher;
        req.setAttribute("email", email);

        requestDispatcher = req.getRequestDispatcher("/email.jsp");
        requestDispatcher.forward(req, resp);
    }


}
