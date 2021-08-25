package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "not null")
    @Size(min = 1, max = 10, message = "min 1 max 10")
    private String name;


    private Date date;

    @Pattern(regexp = "^[\\w]{10,}$", message = "min")
    private String address;


    private String phone;

    private String email;

    @ManyToOne
    private Classroom classroom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student(long id, String name, Date date, String address, String phone, String email, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom = classroom;
    }

    public Student() {
    }
}
