package com.andersen.training.crud.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DICTIONARY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "DISCRIMINATOR"),
        @UniqueConstraint(columnNames = "NAME")
})
@Inheritance
@DiscriminatorColumn(name = "DISCRIMINATOR")
public class Dictionary {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(name = "NAME")
    private String name;
//    @Column(name = "DISCRIMINATOR")
//    private String discriminator;
}
