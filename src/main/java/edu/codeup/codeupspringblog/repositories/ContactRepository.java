package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    //custom jpa method derived queries
    List<Contact> findAllByName(String name);
    //other way is @Query("SQL STATMENT")
}
