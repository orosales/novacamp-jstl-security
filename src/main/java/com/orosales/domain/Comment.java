package com.orosales.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String comment;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_camp", referencedColumnName = "id")
    private Camp camp;


}
