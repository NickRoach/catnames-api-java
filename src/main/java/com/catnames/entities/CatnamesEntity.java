package com.catnames.entities;


import javax.persistence.*;

@Entity
@Table(name = "catnames")
public class CatnamesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true)
    private Integer id;

    private String name;

    public CatnamesEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
