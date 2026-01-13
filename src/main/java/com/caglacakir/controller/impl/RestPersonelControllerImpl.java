package com.caglacakir.controller.impl;

import com.caglacakir.controller.IRestPersonelController;
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
public class RestPersonelControllerImpl implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

     //8080?pageNumber=0&pageSize=5&columnName=createTime&asc=true --> böyle bir ulr olabilir.
    // @ModelAttribute : URL değişkenleri ile utils paketindeki class'la mapler.

    @GetMapping("/list/pageable")
    @Override
public Page<Personel> findAllPageable(RestPageableRequest pageable){ // @ModelAttribute kullanılmasa da Spring arkada
        //bu maplama işlemini otomatik olarak yapar.
        Pageable pageableReq = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.ASC, "id"));
        return personelService.findAllPageable(pageableReq);
    }
}
