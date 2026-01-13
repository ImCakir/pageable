package com.caglacakir.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableRequest {

    //8080?pageNumber=0&pageSize=5&columnName=createTime&asc=true --> böyle bir ulr olabilir.
    //RequestParam ile gönderilen değerleri otomatik olarak bu class ' daki değişkenlerle maplenir.
    // Burada @ModelAttribute :URL adresinde tanımlanan değerleri clas'ın içindeki değerlerle mapleyip, değerleri içine aktarır.@RequestBody kullanılmamıştır.
    //Bu class' ı da Controller'daki "public Page<Personel> findAllPageable(RestPageableRequest pageable)" metoduna parametre olarak verdik.

    private int pageNumber;

    private int pageSize;

    private String columnName;

    private boolean asc;


}
