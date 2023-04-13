package com.swapp.apigateway.feign;

import com.swapp.apigateway.composition.Annuncio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "AnnunciClient",url = "http://swapp-swapp-ads:8083/")
public interface AnnuncInterface {
    @RequestMapping(method = RequestMethod.GET,value = "/ad/{id}", produces = "application/json")
    Annuncio getAnnuncio(@PathVariable String id);

}
