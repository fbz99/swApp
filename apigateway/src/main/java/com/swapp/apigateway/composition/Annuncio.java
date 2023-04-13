package com.swapp.apigateway.composition;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
 public class Annuncio {
   public Annuncio(){
      this.isLiked = false;
   }
    private String id;
    private String titolo;
    private String stato;
    private String image;
    private String descrizione;
    private List<String> categorie;
    private String owner;
    private boolean isLiked;
    private boolean isExclusive;
}
