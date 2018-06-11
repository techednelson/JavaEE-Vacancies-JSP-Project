package dao;

import model.Person;

public interface PersonDao {

    Person login(String user, String password);

}
