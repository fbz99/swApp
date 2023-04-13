package com.matcher_service.controller;

import com.matcher_service.db.VectorD;
import com.matcher_service.db.VectorDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatcherController {
    @Autowired
    VectorDRepo vectorDRepo;

    @GetMapping("/vector/{id}")
    public VectorD getVector(@PathVariable String id){
        return vectorDRepo.findVectorDByAd_id(id);
    }
}
