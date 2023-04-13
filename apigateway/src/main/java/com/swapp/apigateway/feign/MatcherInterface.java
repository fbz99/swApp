package com.swapp.apigateway.feign;

import com.swapp.apigateway.composition.VectorM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient (name = "MatcherClient",url = "http://swapp-swapp-matcher:8084/")
public interface MatcherInterface {
    @RequestMapping(method = RequestMethod.GET, value = "vector/{id}", produces = "application/json")
    VectorM getVectors(@PathVariable String id);
}
