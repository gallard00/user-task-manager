package com.nahuelgallardo.user_task_manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private String userId; // dueño de la tarea

    @Builder.Default
    private TaskStatus status = TaskStatus.PENDING;
}
