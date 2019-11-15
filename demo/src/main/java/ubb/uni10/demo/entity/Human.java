package ubb.uni10.demo.entity;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "Humans", schema = "demo")
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Validated
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;



}
