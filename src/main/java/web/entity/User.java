package web.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, max = 25, message = "Name must be 3 to 25 characters long")
    @Pattern(regexp = "^[A-z]*$", message = "Must contain only latin letters")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname must not be empty")
    @Size(min = 2, max = 25, message = "Surname must be 2 to 25 characters long")
    @Pattern(regexp = "^[A-z]*$", message = "Must contain only latin letters")
    private String surname;

    @Column(name = "department")
    @NotEmpty(message = "Department must not be empty")
    @Pattern(regexp = "^[A-z]*$", message = "Must contain only latin letters")
    private String department;

    @Column(name = "salary")
    @Min(value = 0, message = "Salary must be greater than zero")
    private int salary;

    public User() {

    }

    public User(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
