package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<BlogPost, Long> {
}
