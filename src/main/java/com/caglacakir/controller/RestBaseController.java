package com.caglacakir.controller;

import com.caglacakir.utils.PagerUtil;
import com.caglacakir.utils.RestPageableRequest;
import org.springframework.data.domain.Pageable;

public class RestBaseController {
    /**Base controller şu işe yarar; tüm pageable işlemleri aynı yerden kullanmamıza yaradı.Birden fazla
    cntrollerımız olabilir. Yazdığımız tüm controllerlar bu classı extend ederse toPageable metodunu miras alırlar.
     Tüm controller için toPageable() metodunu yazmaktansa bir kere yazdık hepsinde aynı metodu kullanmış oluruz.Yapılan
    değişiklik hepsini etkileyeceğinden kod tekrarına düşmemiş olduk.**/

    public Pageable toPageable(RestPageableRequest request) {
        return PagerUtil.toPageable(request);

    }
}
