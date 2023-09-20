package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "blog_Post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int UNSIGNED", nullable = false)
    private long id;

    @Column(columnDefinition = "varchar(255) ", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(255) ", nullable = false)
    private String body;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;



    public BlogPost(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public BlogPost(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public BlogPost() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}