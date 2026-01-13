package com.caglacakir.controller.impl;

import com.caglacakir.controller.IRestPersonelController;
import com.caglacakir.model.Personel;
import com.caglacakir.service.IPersonelService;
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

    @GetMapping("/list/pageable")
    @Override
public Page<Personel> findAllPageable(@RequestParam(value = "pageNumber") int pageNumber,
                                      @RequestParam(value = "pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id")); // Pageable yeine PageRequest te yazılabilirdi.Sebepleri aşağıda
        return personelService.findAllPageable(pageable); //findAllPageable(); --> bizden pageable tipinde bir sey ister
        //bizim elimizde pageNumber, pageSize var
        // 1. public class PageRequest extends AbstractPageRequest
        // 2. public abstract class AbstractPageRequest implements Pageable, Serializable (incele) 2 değişkeni var. pageNumber, pageSize
        // bu sebepten PageRequest'in nesnesini 2. numaralı interface karşılar.
    // 26. satırda 3. parametre olarak Sort tipi alır. by(Direction.DESC,"id"); yani 1.parametre sıralama nasıl olsun, 2. parametre hangi column
    }
}
