package com.adservice.ad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface AdRepository extends MongoRepository<Annuncio, String> {

    @Query("{owner: ?0}")
    ArrayList<Annuncio> findAnnunciByOwner(String username);
    @Query("{owner: ?0,titolo: ?1}")
    Annuncio findAnnuncioByOwnerAndTitle(String owner,String title);
    @Query("{_id: ?0}")
    Annuncio findAnnuncioById(String id);
    @Query("{\"owner\":{$nin:[?0]}}")
    ArrayList<Annuncio> findNotOwnedAds(String username);
}
