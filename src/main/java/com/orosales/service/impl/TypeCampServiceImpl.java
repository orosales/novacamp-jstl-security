package com.orosales.service.impl;

import com.orosales.domain.TypeCamp;
import com.orosales.dto.TypeDTO;
import com.orosales.repository.TypeCampRepository;
import com.orosales.service.TypeCampService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Repository
@Service("typeCampServiceImpl")
public class TypeCampServiceImpl implements TypeCampService {

    @Autowired
    private TypeCampRepository typeCampRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<TypeDTO> getListTypeCamp() {
        List<TypeCamp> listTypeCamp = typeCampRepository.findAll();
        log.debug("Name from the first {}", listTypeCamp.get(0).getName() );
        List<TypeDTO> listTypeCampDTO = new ArrayList<TypeDTO>();

        for (TypeCamp typeCamp: listTypeCamp) {
            TypeDTO typeCampDTO = modelMapper.map(typeCamp, TypeDTO.class);
            listTypeCampDTO.add(typeCampDTO);
        }
        return listTypeCampDTO;
    }
}
