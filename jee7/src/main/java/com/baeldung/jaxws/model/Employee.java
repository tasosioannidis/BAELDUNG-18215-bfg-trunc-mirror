package com.baeldung.jaxws.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String firstName;

    public Employee() {

    }

    public Employee(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
