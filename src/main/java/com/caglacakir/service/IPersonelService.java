package com.caglacakir.service;

import com.caglacakir.model.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonelService {

    Page<Personel> findAllPageable(Pageable pageable);
}
