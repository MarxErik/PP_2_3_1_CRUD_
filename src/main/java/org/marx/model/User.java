package org.marx.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String name;
    @Column
    int age;
    @Column(name = "professional_position")
    String professionalPosition;

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
}
