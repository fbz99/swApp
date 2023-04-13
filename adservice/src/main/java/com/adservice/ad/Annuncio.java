package com.adservice.ad;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

@Getter
@Setter
@Document
public class Annuncio {
    @Id
    private String id;
    @Indexed(unique=true)
    private String titolo;
    private String stato;
    private String image;
    private String descrizione;
    private List<String> categorie;
    private String owner;
    private String Exchange_id;
    private boolean isExclusive;
}
