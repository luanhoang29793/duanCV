package com.codegym.repository.impl;

import com.codegym.model.ContactForm;
import com.codegym.repository.ContactRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class ContactFormRepositoryImpl implements ContactRepository {
    @PersistenceContext
    private EntityManager  em;
    @Override
    public List<ContactForm> findAll() {
        TypedQuery<ContactForm> query = em.createQuery("select c from ContactForm c", ContactForm.class);
        return query.getResultList();
    }

    @Override
    public ContactForm findById(Long id) {
        TypedQuery<ContactForm> query = em.createQuery("select c from ContactForm c where  c.id=:id", ContactForm.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(ContactForm model) {
        if(model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }

    }

    @Override
    public void remove(Long id) {
        ContactForm contactForm = findById(id);
        if(contactForm != null){
            em.remove(contactForm);
        }
    }

    }

