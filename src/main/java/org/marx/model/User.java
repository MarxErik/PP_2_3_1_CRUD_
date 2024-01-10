package org.marx.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "professional_position")
    private String professionalPosition;

    public User() {

    }

    public User(long id, String name, int age, String professionalPosition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.professionalPosition = professionalPosition;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProfessionalPosition() {
        return professionalPosition;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfessionalPosition(String professionalPosition) {
        this.professionalPosition = professionalPosition;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", professionalPosition='" + professionalPosition + '\'' +
                '}';
    }
}
