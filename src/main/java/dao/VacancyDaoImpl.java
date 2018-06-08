package dao;

import model.Vacancy;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        try {
            PreparedStatement ps = conn.getConnectionDB().prepareStatement(sql);
            ps.setInt(1, vacancy.getId());
            ps.setString(2, simpleDateFormat.format(vacancy.getPublishDate()));
            ps.setString(3, vacancy.getVacancyName());
            ps.setString(4, vacancy.getDescription());
            ps.setString(5, vacancy.getDetails());
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("sql query failed: " + e.getMessage());
            Logger.getLogger(VacancyDaoImpl.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }
}
