package domain;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;

    @NotEmpty(message = "{student.name.notEmpty}")
    @Size(min=5, max=20, message = "{student.name.size}")
    private String name;

    @Max(150)
    @Min(1)
    private Integer age;
    @NotEmpty
    private String gender;
    @NotEmpty
    //@Size(min = 11, max = 11)
    private String telephone;
    @NotEmpty
    @Size(max = 50)
    private String email;

    private Classes classes;

    public Student() {
    }

    public Student(String name, Integer age, String gender, String telephone, String email, Classes classes) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.classes = classes;
    }

    public Student(Integer id, String name, Integer age, String gender, String telephone, String email, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.classes = classes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", classes=" + classes +
                '}';
    }
}
