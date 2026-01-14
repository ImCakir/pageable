package com.caglacakir.controller;

import com.caglacakir.utils.PagerUtil;
import com.caglacakir.utils.RestPageableEntity;
import com.caglacakir.utils.RestPageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {
    /*Base controller şu işe yarar; tüm pageable işlemleri aynı yerden kullanmamıza yaradı.Birden fazla
    cntrollerımız olabilir. Yazdığımız tüm controllerlar bu classı extend ederse toPageable metodunu miras alırlar.
     Tüm controller için toPageable() metodunu yazmaktansa bir kere yazdık hepsinde aynı metodu kullanmış oluruz.Yapılan
    değişiklik hepsini etkileyeceğinden kod tekrarına düşmemiş olduk.*/

    public Pageable toPageable(RestPageableRequest request) {
        return PagerUtil.toPageable(request);

    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page , List<T> content) {
        return PagerUtil.toPageableResponse(page , content);



    }
}
