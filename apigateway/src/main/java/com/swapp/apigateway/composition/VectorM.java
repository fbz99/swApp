package com.swapp.apigateway.composition;

import lombok.Getter;

import java.util.List;

@Getter
public class VectorM {
    private String ad_id;
    private String owner;
    private List<String> vector_d;
    private List<String> vector_l;
    private List<String> vector_f;
    private List<String> categories;
}
