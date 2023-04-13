package com.registration_service.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface userRepo extends MongoRepository<user, String> {

    @Query("{email: ?0}")
     user findByEmail(String email);
    @Query("{username: ?0}")
     user findByUsername(String email);

}
