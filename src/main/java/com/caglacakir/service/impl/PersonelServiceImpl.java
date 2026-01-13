package com.caglacakir.service.impl;

import com.caglacakir.model.Personel;
import com.caglacakir.repository.PersonelRepository;
import com.caglacakir.service.IPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public Page<Personel> findAllPageable(Pageable pageable) {
      Page<Personel> page =  personelRepository.findAllPageable(pageable);
      return page;
    }
}
