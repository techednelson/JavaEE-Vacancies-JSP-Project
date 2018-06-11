package dao;

import model.Vacancy;

import java.util.List;

public interface VacancyDao {

    boolean insert(Vacancy vacancy);

    List<Vacancy> getRecent();

    Vacancy getById(int idVacancy);

    List<Vacancy> getAll();

    List<Vacancy> getByQuery(String query);
}
