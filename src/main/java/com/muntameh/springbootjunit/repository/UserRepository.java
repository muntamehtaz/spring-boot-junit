package com.muntameh.springbootjunit.repository;

import com.muntameh.springbootjunit.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
