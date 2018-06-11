package dao;

import model.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ApplicationDaoImpl implements ApplicationDao {

    private ConnectDB conn;

    public ApplicationDaoImpl(ConnectDB conn) {
        this.conn = conn;
    }

    @Override
    public int insert(Application application) {

        String sql = "insert into application values (?,?,?,?,?,?,?,?)";
        java.util.Date javaUtilDate = application.getDate();
        java.sql.Date javaSqlDate = new java.sql.Date(javaUtilDate.getTime());

        try {

            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, application.getId());
            preparedStatement.setDate(2, javaSqlDate);
            preparedStatement.setString(3, application.getName());
            preparedStatement.setString(4, application.getEmail());
            preparedStatement.setString(5, application.getPhone());
            preparedStatement.setString(6, application.getAddress());
            preparedStatement.setString(7, application.getFile());
            preparedStatement.setInt(8, application.getVacancy().getId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idApplication = 0;
            if (rs.next()) {
                idApplication = rs.getInt(1);
            }
            return idApplication;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error ApplicationDaoImpl.insert: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Application> getAll() {

        try {

            String sql = "select * from application order by id desc";

            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Application> list = new LinkedList<>();
            Application application;
            VacancyDao vacancyDao = new VacancyDaoImpl(conn);
            while (resultSet.next()) {
                application = new Application(resultSet.getInt("id"));
                application.setDate(resultSet.getDate("publish_date"));
                application.setName(resultSet.getString("candidate_name"));
                application.setEmail(resultSet.getString("email"));
                application.setPhone(resultSet.getString("phone"));
                application.setAddress(resultSet.getString("address"));
                application.setFile(resultSet.getString("file"));
                application.setVacancy( vacancyDao.getById(resultSet.getInt("idVacancy")) );

                list.add(application);

            }

            return list;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error ApplicationDaoImpl.getAll: " + e.getMessage());
            return null;
        }
    }
}
