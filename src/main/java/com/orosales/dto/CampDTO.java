package com.orosales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class CampDTO {
    private Integer id;

    @NotNull(message = "You need to complete this field")
    @Size(min=4, max=50, message = "You need a name longer than 4 characters")
    private String name;

    @Size(min=4, max=200, message = "You need a image longer than 4 characters")
    private String image;

    @NotNull(message = "You need to complete this field")
    @Size(min=4, max=100, message = "You need a description longer than 4 characters")
    private String description;

    @NotNull
    private Integer size;

    @NotNull
    private Integer idTypeCamp;

    private ArrayList listComments;

    public CampDTO() {

    }

    public CampDTO(Integer id, String name, String image, String description, Integer size) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.size = size;
    }

    public CampDTO(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }


}
