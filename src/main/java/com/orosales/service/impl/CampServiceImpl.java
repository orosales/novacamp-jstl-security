package com.orosales.service.impl;

import com.orosales.domain.Camp;
import com.orosales.domain.Comment;
import com.orosales.domain.TypeCamp;
import com.orosales.dto.CampDTO;
import com.orosales.dto.CommentDTO;
import com.orosales.repository.CampRepository;
import com.orosales.repository.TypeCampRepository;
import com.orosales.service.CampService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
@Repository
@Service("campServiceImpl")
public class CampServiceImpl implements CampService {

    @Autowired
    private CampRepository campRepository;

    @Autowired
    private TypeCampRepository typeCampRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CampDTO> listAllCamps() {
        List<Camp> listCamps =   campRepository.findAll();
        List<CampDTO> listCampModel = new ArrayList<>();

        for(Camp camp:listCamps) {
            CampDTO campDTO = modelMapper.map(camp, CampDTO.class);
            listCampModel.add(campDTO);
        }
        return listCampModel;
    }

    @Override
    public CampDTO saveCamp(CampDTO campModel) {
        Camp  camp = modelMapper.map(campModel, Camp.class);
        TypeCamp typeCamp = typeCampRepository.findById(campModel.getIdTypeCamp());
        camp.setTypeCamp(typeCamp);

        Camp campSaved = campRepository.save(camp);
        return modelMapper.map(campSaved, CampDTO.class);
    }

    @Override
    public CampDTO findById(Integer id) {
        Camp camp = campRepository.findById(id);
        CampDTO campDTO = modelMapper.map(camp, CampDTO.class);

        ArrayList listComments = new ArrayList();

        Iterator itr = camp.getComments().iterator();
        while (itr.hasNext()) {
            CommentDTO commentDTO = new CommentDTO();
            Comment comment = (Comment) itr.next();
            commentDTO.setId( comment.getId() );
            commentDTO.setComment( comment.getComment() );
            listComments.add(commentDTO);
        }
        campDTO.setListComments(listComments);
        return campDTO;
    }
}
