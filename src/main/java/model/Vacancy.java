package model;

import java.util.Date;

public class Vacancy {

    private int id;
    private Date publishDate;
    private String vacancyName;
    private String description;
    private String details;

    public Vacancy(int id) {
        this.id = id;
    }

    public Date getPublishDate() { return publishDate; }

    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }

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
                ", publishDate=" + publishDate +
                ", vacancyName='" + vacancyName + '\'' +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}