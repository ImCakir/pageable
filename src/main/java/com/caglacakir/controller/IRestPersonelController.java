package com.caglacakir.controller;

import com.caglacakir.dto.DtoPersonel;
import com.caglacakir.model.Personel;
import com.caglacakir.utils.RestPageableEntity;
import com.caglacakir.utils.RestPageableRequest;
import com.caglacakir.utils.RestRootEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRestPersonelController {

    public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest restPageableRequest);


}
