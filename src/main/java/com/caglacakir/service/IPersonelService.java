package com.caglacakir.service;

import com.caglacakir.dto.DtoPersonel;
import com.caglacakir.model.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonelService {

    Page<Personel> findAllPageable(Pageable pageable);

    List<DtoPersonel> toDTOList(List<Personel> personelList);
}
