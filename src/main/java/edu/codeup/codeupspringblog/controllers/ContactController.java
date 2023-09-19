package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Statement;
import java.util.List;

@Controller
public class ContactController {

    //constructor dependency injection
    private ContactRepository contactsDao;

    public ContactController(ContactRepository contactsDao) {
        this.contactsDao = contactsDao;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> returnContacts(){
        return contactsDao.findAll();
    }
    @GetMapping("/contacts/view")
    @ResponseBody
    public String returnContactsView(Model model){
        model.addAttribute("contacts", contactsDao.findAll());
        return "contacts/index";
    }
    @GetMapping("/contactsName")
    @ResponseBody
    public List<Contact> returnContactsByName(){
        return contactsDao.findAllByName("Jose");
    }
}
