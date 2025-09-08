package com.nahuelgallardo.user_task_manager.repository;

import com.nahuelgallardo.user_task_manager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
