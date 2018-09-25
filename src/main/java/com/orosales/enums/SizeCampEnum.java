package com.orosales.enums;


import com.orosales.dto.TypeDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public enum SizeCampEnum {

    SMALL(1, "Small"),
    MEDIUM(2, "Medium"),
    LARGE(3, "Large"),
    EXTRA_LARGE(4, "Extra Large");

    private Integer value;
    private String label;



    SizeCampEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static SizeCampEnum getEnum(Integer value) {
        if (value!= null) {
            for (SizeCampEnum en: SizeCampEnum.values()) {
                if ( en.getValue().equals(value)) {
                    return en;
                }
            }
        }

        return null;
    }

    public static ArrayList<TypeDTO> getListSizeCamp() {
        ArrayList<TypeDTO> list = new ArrayList<>();
        for (SizeCampEnum en: SizeCampEnum.values()) {
            TypeDTO dto = new TypeDTO();
            dto.setId(en.getValue());
            dto.setName(en.getLabel());
            list.add(dto);
        }
        return list;
    }

}