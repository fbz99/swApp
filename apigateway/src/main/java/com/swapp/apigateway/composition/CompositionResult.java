package com.swapp.apigateway.composition;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CompositionResult {
    private Annuncio mainAnnuncio;
    private List<Annuncio> vectorD;
    private List<Annuncio> vectorL;

}
