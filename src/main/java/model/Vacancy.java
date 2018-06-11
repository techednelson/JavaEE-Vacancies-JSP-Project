package model;

import java.util.Date;

public class Vacancy {

    private int id;
    private Date date;
    private String vacancyName;
    private String description;
    private String details;

    public Vacancy(int id) {
        this.date = new Date();
        this.id = id;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getVacancyName() { return vacancyName; }

    public void setVacancyName(String vacancyName) { this.vacancyName = vacancyName; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }

    @java.lang.Override
    public java.lang.String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", date=" + date +
                ", vacancyName='" + vacancyName + '\'' +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}