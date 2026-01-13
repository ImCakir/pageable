package com.caglacakir.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UtilityClass
//sınıftan nesne üretilmez
// metotlar static tir. metodlarına sınıf ismiyle erişilir.
public class PagerUtil {

    public boolean isNullOrEmpty(String value) {
        return value == null || value.trim().length() == 0;

    }
    public Pageable toPageable(RestPageableRequest request) {
        if(!isNullOrEmpty(request.getColumnName())) {
            Sort sortBy = request.isAsc() ? Sort.by(Sort.Direction.ASC, request.getColumnName())
                    : Sort.by(Sort.Direction.DESC, request.getColumnName());

           return PageRequest.of(request.getPageNumber(), request.getPageSize(), sortBy);
        }

        return PageRequest.of(request.getPageNumber(), request.getPageSize());
        //columnName boş geçilirse herhangi bir sort islemi yapılmayacaksa direk şu sayfadan 10 kayıt getir dendiğinde
        // iki parametreli olanı kullanırız. Sort kullanılmayan versiyonunu
        //sort işlemi olcaksa column değeri dolduralacak, değilse sort 'suz pageable döner.
    }

}
