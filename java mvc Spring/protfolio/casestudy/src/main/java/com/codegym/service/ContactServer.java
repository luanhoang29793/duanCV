package com.codegym.service;

import com.codegym.model.ContactForm;

import java.util.List;

public interface ContactServer {
    List<ContactForm> findAll();

    ContactForm findbyId(Long id);

    void save(ContactForm contactForm);

    void remove(Long id);
}
