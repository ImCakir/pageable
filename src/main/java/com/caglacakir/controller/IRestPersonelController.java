package com.caglacakir.controller;

import com.caglacakir.model.Personel;
import com.caglacakir.utils.RestPageableRequest;
import org.springframework.data.domain.Page;

public interface IRestPersonelController {

    public Page<Personel> findAllPageable(RestPageableRequest restPageableRequest);
}
