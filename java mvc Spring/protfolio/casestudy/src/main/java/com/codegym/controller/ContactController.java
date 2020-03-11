package com.codegym.controller;

import com.codegym.model.ContactForm;
import com.codegym.service.ContactServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactServer contactServer;
    // hien tat ca contact
    @RequestMapping(value = "/contacts/", method = RequestMethod.GET)
    public ResponseEntity<List<ContactForm>> listAllCustomers() {
        List<ContactForm> contactForms = contactServer.findAll();
        if (contactForms.isEmpty()) {
            return new ResponseEntity<List<ContactForm>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ContactForm>>(contactForms, HttpStatus.OK);
    }
    //hien theo id
    @RequestMapping(value="/contacts/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactForm> getContactForm(@PathVariable("id") long id){
        System.out.println("hien thi contact co " + id);
        ContactForm contactForm =contactServer.findbyId(id);
        if(contactForm == null) {
            System.out.println("Khong tim thay id:" +id);
            return new ResponseEntity<ContactForm>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<ContactForm>(contactForm, HttpStatus.OK);
    }
    //tao contact

    @RequestMapping(value = "/contacts/",method = RequestMethod.POST)
    public ResponseEntity<Void> createContact(@RequestBody ContactForm contactForm, UriComponentsBuilder ucBuilder){
        System.out.println("tao contact" + contactForm.getLastName());
        contactServer.save(contactForm);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contacts/{id}").buildAndExpand(contactForm.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    // Xoa contact
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ContactForm> deleteContact(@PathVariable ("id") long id){
        System.out.println("Xoa contact co id: " +id);
        ContactForm contactForm = contactServer.findbyId(id);
        if(contactForm==null){
            System.out.println("khong co " +id+" de xoa");
            return  new ResponseEntity<ContactForm>(HttpStatus.NOT_FOUND);
        }
        contactServer.remove(id);
        return new ResponseEntity<ContactForm>(HttpStatus.NO_CONTENT);
    }
}
