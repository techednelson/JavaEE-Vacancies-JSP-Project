package dao;

import model.Application;

import java.util.List;

public interface ApplicationDao {

    int insert(Application application);

    List<Application> getAll();

}
