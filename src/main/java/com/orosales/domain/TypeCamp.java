package com.orosales.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "type_camp")
public class TypeCamp {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    public TypeCamp() {

    }

    /*
    @OneToMany(mappedBy = "typeCamp", targetEntity = Camp.class, fetch = FetchType.EAGER)
    private Collection camps;
    */
}
