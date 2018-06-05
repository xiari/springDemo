package com.demo.mvc.model;

import org.apache.commons.mail.Email;

import java.util.Objects;

public class Person implements Cloneable{
    /** 姓名 **/
    private String name;

    /** 电子邮件 **/
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Person(String name,Email email){
        this.name  = name;
        this.email = email;
    }

    public Person(String name){
        this.name = name;
    }

    public Person(){
    }

    protected Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}