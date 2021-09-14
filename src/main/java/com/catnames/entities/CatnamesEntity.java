package com.catnames.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "catnames")
public class CatnamesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true)
    @Getter @Setter
    private Integer id;

    @Column(name="name")
    @Getter @Setter
    private String name;

    @Column(name="occupation")
    @Getter @Setter
    private String occupation;

    public CatnamesEntity() {
    }
}
