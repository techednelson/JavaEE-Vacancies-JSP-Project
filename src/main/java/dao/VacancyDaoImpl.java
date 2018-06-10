package dao;

import model.Vacancy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VacancyDaoImpl implements VacancyDao {
    private ConnectDB conn;

    public VacancyDaoImpl(ConnectDB conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(Vacancy vacancy) {
        String sql = "insert into Vacancy values(?, ?, ?, ?, ?)";
        java.util.Date javaUtilDate = vacancy.getPublishDate();
        java.sql.Date javaSqlDate = new java.sql.Date(javaUtilDate.getTime());

        try {
            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql);
            preparedStatement.setInt(1, vacancy.getId());
            preparedStatement.setDate(2, javaSqlDate);
            preparedStatement.setString(3, vacancy.getVacancyName());
            preparedStatement.setString(4, vacancy.getDescription());
            preparedStatement.setString(5, vacancy.getDetails());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("sql query failed: " + e.getMessage());
            Logger.getLogger(VacancyDaoImpl.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public List<Vacancy> getRecent() {

        try {
            String sql = "select * from vacancy order by id desc limit 3";
            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Vacancy> list = new LinkedList<>();
            Vacancy vacancy;

            while(resultSet.next()) {
                vacancy = new Vacancy(resultSet.getInt("id"));
                vacancy.setPublishDate(resultSet.getDate("publish_date"));
                vacancy.setVacancyName(resultSet.getString("vacancy_name"));
                vacancy.setDescription(resultSet.getString("description"));
                vacancy.setDetails(resultSet.getString("details"));

                list.add(vacancy);
            }

            return list;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Vacancy getById(int idVacancy) {
        try {
            String sql = "select * from vacancy where id = ? limit 1";
            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql);
            preparedStatement.setInt(1, idVacancy);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vacancy vacancy = new Vacancy(0);

            while(resultSet.next()) {
                vacancy.setId(resultSet.getInt("id"));
                vacancy.setPublishDate(resultSet.getDate("publish_date"));
                vacancy.setVacancyName(resultSet.getString("vacancy_name"));
                vacancy.setDescription(resultSet.getString("description"));
                vacancy.setDetails(resultSet.getString("details"));
            }

            return vacancy;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


}
