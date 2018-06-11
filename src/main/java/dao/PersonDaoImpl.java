package dao;

import model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {
    ConnectDB conn;

    public PersonDaoImpl(ConnectDB conn) {
        this.conn = conn;
    }

    @Override
    public Person login(String user, String password) {

        try {
            String sql = "select * from person where username = ? and password = md5(?) and status = 'active' limit 1";
            PreparedStatement preparedStatement = conn.getConnectionDB().prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            Person person = new Person(0);

            while(resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setPersonName(resultSet.getString("person_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPersonName(resultSet.getString("person_name"));
                person.setUserName(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                person.setProfile(resultSet.getString("profile"));
                person.setStatus(resultSet.getString("status"));
            }

            return person;

        } catch(SQLException e) {
            System.out.println("Query failed PersonDao.login: " + e.getMessage());
            return null;
        }

    }
}
