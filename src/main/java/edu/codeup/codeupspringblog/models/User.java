package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int UNSIGNED", nullable = false)
    private long id;

    @Column(columnDefinition = "varchar(255) ", nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "varchar(255) ", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255) ", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<BlogPost> blogPost;

    public User(String username, String email, String password, List<BlogPost> blogPost) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.blogPost = blogPost;
    }

    public User(long id, String username, String email, String password,  List<BlogPost> blogPost) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.blogPost = blogPost;
    }
}
