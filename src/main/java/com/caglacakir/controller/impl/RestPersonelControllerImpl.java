package com.caglacakir.controller.impl;

import com.caglacakir.controller.IRestPersonelController;
import com.caglacakir.controller.RestBaseController;
import com.caglacakir.model.Personel;
import com.caglacakir.service.IPersonelService;
import com.caglacakir.utils.RestPageableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;


    @GetMapping("/list/pageable")
    @Override
public Page<Personel> findAllPageable(RestPageableRequest pageable){
         //Pageable pageableReq = toPageable(pageable);
        return personelService.findAllPageable(toPageable(pageable));
    }
}
