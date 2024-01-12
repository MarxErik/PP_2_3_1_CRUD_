package org.marx.model;

import javax.persistence.*;
import java.util.Objects;

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

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfessionalPosition() {
        return professionalPosition;
    }


    public void setProfessionalPosition(String professionalPosition) {
        this.professionalPosition = professionalPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(professionalPosition, user.professionalPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, professionalPosition);
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
