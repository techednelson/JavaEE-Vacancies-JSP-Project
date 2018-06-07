package model;

public class Person {
    private int id;
    private String email;
    private String userName;
    private String password;
    private String profile;
    private String status = "active";

    public Person(int id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @java.lang.Override
    public java.lang.String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}