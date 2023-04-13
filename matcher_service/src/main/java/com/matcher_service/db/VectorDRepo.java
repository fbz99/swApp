package com.matcher_service.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VectorDRepo extends MongoRepository<VectorD,String> {

     List<VectorD> findByCategoriesInAndOwnerNot(List<String> category,String owner);
     @Query("{ad_id:?0}")
     VectorD findVectorDByAd_id(String id);
}
