package com.byteobject.prototype.datastructures.academy;

import java.util.Date;
import java.util.Objects;

public class Person {

    private final int id;

    private final String name;

    private String email;

    private final Date dateOfBirth;

    private final Gender gender;

    public Person(int id, String name, String email, Date dateOfBirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public static enum Gender {
        MALE,FEMALE,OTHERS
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
