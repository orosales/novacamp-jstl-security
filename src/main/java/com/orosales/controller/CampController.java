package com.orosales.controller;

import com.orosales.dto.CampDTO;
import com.orosales.dto.TypeDTO;
import com.orosales.enums.SizeCampEnum;
import com.orosales.service.CampService;
import com.orosales.service.TypeCampService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class CampController {

    @Autowired
    @Qualifier("campServiceImpl")
    private CampService campService;

    @Autowired
    @Qualifier("typeCampServiceImpl")
    private TypeCampService typeCampService;

    /*
    private final List<CampDTO> listCamps = new ArrayList<CampDTO>() {{
        add(new CampDTO(new Integer(1), "Cape Breton", "https://www.atlanticbusinessmagazine.net/wp-content/uploads/2017/02/V28N2-FI-Cape-Breton-620x250.jpg", "Cape Breton"));
        add(new CampDTO(new Integer(2), "Long Park", "https://i.ytimg.com/vi/iGFr3edTmaM/maxresdefault.jpg", "Cape Breton"));
        add(new CampDTO(new Integer(3), "Frog Park", "https://www.atlanticbusinessmagazine.net/wp-content/uploads/2017/02/V28N2-FI-Cape-Breton-620x250.jpg", "Cape Breton"));
        add(new CampDTO(new Integer(4), "Frog Park", "https://www.atlanticbusinessmagazine.net/wp-content/uploads/2017/02/V28N2-FI-Cape-Breton-620x250.jpg", "Cape Breton"));
        add(new CampDTO(new Integer(5), "Frog Park", "https://www.atlanticbusinessmagazine.net/wp-content/uploads/2017/02/V28N2-FI-Cape-Breton-620x250.jpg", "Cape Breton"));
        add(new CampDTO(new Integer(6), "Frog Park", "https://www.atlanticbusinessmagazine.net/wp-content/uploads/2017/02/V28N2-FI-Cape-Breton-620x250.jpg", "Cape Breton"));
    }};
    */


    @GetMapping("/")
    public String start(Model model) {
        log.debug(" Redirect to Camp because it was called /");
       return "redirect:/camps";
    }

    @GetMapping("camps")
    public String showcamps(Model model) {
        List<CampDTO> listCampsDTO = campService.listAllCamps();
        //model.addAttribute("listCamps", listCamps);
        model.addAttribute("listCamps", listCampsDTO);
        return "camps";
    }

    @GetMapping("camps/{id}")
    public String showcamp(@PathVariable Integer id, Model model) {
        log.debug("Id del showcamp is {}", id);
        CampDTO campSelected = campService.findById(id);
        log.debug("camp: {}", campSelected);
        //log.debug(" list comments size{}", campSelected.getListComments().size() );
        model.addAttribute("camp", campSelected);
        return "show";
    }

    @GetMapping("camps/new")
    public String newCamp(Model model) {
        List<TypeDTO> listTypeCamps = typeCampService.getListTypeCamp();
        CampDTO campDTO = new CampDTO();
        log.debug("Before obtaining getListSizeCamp ");
        List<TypeDTO> sizeList = SizeCampEnum.getListSizeCamp();

        log.debug("sizeList size is {}", sizeList.size() );

        model.addAttribute("typeCamps", listTypeCamps);
        model.addAttribute("camp", campDTO);
        model.addAttribute("sizeList", sizeList);

        return "new";
    }

    @PostMapping("camps")
    public String saveCamp(@Valid @ModelAttribute("camp") CampDTO camp, BindingResult bindingResult, Model model) {
        log.debug("Information of camp is {}", camp);
        log.debug("Type of Camp is {}", camp.getIdTypeCamp() );
        log.debug("Size is {}", camp.getSize());

        if (bindingResult.hasErrors()) {
            log.debug("There is error");
            List<TypeDTO> listTypeCamps = typeCampService.getListTypeCamp();
            List<TypeDTO> sizeList = SizeCampEnum.getListSizeCamp();
            model.addAttribute("typeCamps", listTypeCamps);
            model.addAttribute("sizeList", sizeList);

            return "new";
        }

        //camp.setId(  new Integer( (listCamps.size()+1 ) ) );
        //listCamps.add(camp);
        CampDTO campDTO = campService.saveCamp(camp);
        //model.addAttribute("listCamps", listCamps);
        return "redirect:/camps";
    }

}
