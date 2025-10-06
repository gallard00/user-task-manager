package com.nahuelgallardo.user_task_manager.repository;

import com.nahuelgallardo.user_task_manager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByUserId(String userId);
}
