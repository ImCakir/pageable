package com.caglacakir.controller;

import com.caglacakir.model.Personel;
import org.springframework.data.domain.Page;

public interface IRestPersonelController {

    public Page<Personel> findAllPageable(int pageNumber, int pageSize);
}
