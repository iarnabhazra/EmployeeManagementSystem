package Employee.management.EmployeeManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String first_name;

    @Column(name = "LastName")
    private String last_name;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "phone_number")
    private String phone_number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Employee() {
    }

    public Employee(String first_name, String last_name, String email_id, String phone_number) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.phone_number = phone_number;
    }
}
