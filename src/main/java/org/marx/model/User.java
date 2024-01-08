package org.marx.model;

import jakarta.persistence.*;

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
