package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED", nullable = false)
    private int id;
    @Column(columnDefinition = "tinyint(3) UNSIGNED", nullable = false, unique = true)
    private int age;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String name;
    @Column(columnDefinition = "char(2) default 'xx'")
    //automatically turns resideState into reside_state
    private String resideState;
}
