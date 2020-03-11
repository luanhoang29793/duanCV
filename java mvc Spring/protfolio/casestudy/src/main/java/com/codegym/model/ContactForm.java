package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contactform")
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    private String lastName;

    private String email;

    private String subject;

    private String message;

    public ContactForm() { }
    public ContactForm(Long id,String firstName, String lastName, String email, String Subject, String message){
       this.id= id;
        this.firstName =firstName;
        this.lastName=lastName;
        this.email = email;
        this.message=message;
        this.subject= Subject;
    }
    @Override
    public String toString() {
        return String.format("ContactForm[id=%d, firstname='%s, lastname='%s,email='%s,subject='%s,message='%s']", id, firstName,lastName,email,subject,message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
