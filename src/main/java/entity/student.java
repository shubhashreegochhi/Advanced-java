package entity;

public class student {
    private int id;
    private String name;
    private String email;
    private int redgno;

    public student(int id, String name, String email, int redgno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.redgno = redgno;
    }
    public student() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getRedgno() {
        return redgno;
    }
    public void setRedgno(int redgno) {
        this.redgno = redgno;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", redgno=" + redgno +
                '}';
    }
}
