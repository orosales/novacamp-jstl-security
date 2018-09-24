package com.orosales.controller;

import com.orosales.dto.CampDTO;
import com.orosales.service.CampService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CommentController {

    @Autowired
    CampService campService;

    @PostMapping("/maps/{idCamp}/comments")
    public String saveComment(@PathVariable Integer idCamp, Model model) {

        CampDTO campDTO = campService.findById(idCamp);
        log.debug("In saveComment");
        model.addAttribute("camp", campDTO );
        return "comment";
    }
}
