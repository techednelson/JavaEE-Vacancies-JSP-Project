package model;

import java.util.Date;

public class Application {
    private int id;
    private Date date;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String file;
    private Vacancy vacancy;

    public Application(int id) { this.id = id; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getFile() { return file; }

    public void setFile(String file) { this.file = file; }

    public Vacancy getVacancy() { return vacancy; }

    public void setVacancy(Vacancy vacancy) { this.vacancy = vacancy; }

    @Override
    public String toString() {
        return "Application{" + "id=" + id + ", date=" + date + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", file=" + file + ", vacancy=" + vacancy + '}';
    }

}
