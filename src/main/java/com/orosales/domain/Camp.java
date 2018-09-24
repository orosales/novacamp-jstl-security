package com.orosales.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@Entity
@Table(name = "camp")
public class Camp {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private String description;

    @Column
    private Integer size;

    @JoinColumn(name = "id_type_camp", nullable = false)
    @ManyToOne(optional = false)
    private TypeCamp typeCamp;


    @OneToMany(mappedBy = "camp", targetEntity = Comment.class, fetch = FetchType.LAZY)
    private Collection comments;


    public Camp() {

    }

    public Camp(Integer id, String name, String image, String description, Integer size) {
        id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.size = size;
    }


}
