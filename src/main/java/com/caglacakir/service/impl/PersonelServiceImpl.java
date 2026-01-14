package com.caglacakir.service.impl;

import com.caglacakir.dto.DtoDepartment;
import com.caglacakir.dto.DtoPersonel;
import com.caglacakir.model.Personel;
import com.caglacakir.repository.PersonelRepository;
import com.caglacakir.service.IPersonelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonelServiceImpl implements IPersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public Page<Personel> findAllPageable(Pageable pageable) {
      Page<Personel> page =  personelRepository.findAllPageable(pageable);
      return page;
    }

    @Override
    public List<DtoPersonel> toDTOList(List<Personel> personelList) { //Personel entity listesini alır, DtoPersonel listesine dönüştürür.
        List<DtoPersonel> dtoList = new ArrayList<>();
        //Döneceğim DTO’ları tutmak için boş bir liste oluşturuyorum.

        for(Personel personel : personelList) { //Personel listesindeki her bir personeli tek tek dolaşıyorum.
            DtoPersonel dtoPersonel = new DtoPersonel();
            DtoDepartment dtoDepartment = new DtoDepartment();

            BeanUtils.copyProperties(personel, dtoPersonel);
            BeanUtils.copyProperties(personel.getDepartment() ,  dtoDepartment);

            dtoPersonel.setDepartment(dtoDepartment);

            dtoList.add(dtoPersonel);
        }
        return dtoList;

    }


}
