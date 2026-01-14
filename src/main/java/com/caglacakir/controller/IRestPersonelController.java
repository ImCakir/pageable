package com.caglacakir.controller;

import com.caglacakir.dto.DtoPersonel;
import com.caglacakir.model.Personel;
import com.caglacakir.utils.RestPageableEntity;
import com.caglacakir.utils.RestPageableRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRestPersonelController {

    public RestPageableEntity<DtoPersonel> findAllPageable(RestPageableRequest restPageableRequest);


}
