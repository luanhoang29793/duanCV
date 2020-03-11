package com.codegym.service.impl;

import com.codegym.model.ContactForm;
import com.codegym.repository.ContactRepository;
import com.codegym.service.ContactServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactServiceImpl implements ContactServer {
    @Autowired
    public ContactRepository contactRepository;

    @Override
    public List<ContactForm> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public ContactForm findbyId(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void save(ContactForm contactForm) {
    contactRepository.save(contactForm);
    }

    @Override
    public void remove(Long id) {
    contactRepository.remove(id);
    }
}
