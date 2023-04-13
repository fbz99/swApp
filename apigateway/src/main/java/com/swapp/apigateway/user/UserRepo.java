package com.swapp.apigateway.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserRepo extends MongoRepository<user, String> {

	@Query("{username: ?0}")
	 user findByUsername(String username);
	@Query("{email: ?0}")
	 user findByEmail(String email);

}
