package com.orosales.service;

import com.orosales.dto.CampDTO;

import java.util.List;

public interface CampService {
    public abstract List<CampDTO> listAllCamps();
    public abstract CampDTO saveCamp(CampDTO campModel);
    public abstract CampDTO findById(Integer id);
}
