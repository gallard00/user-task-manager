package com.nahuelgallardo.user_task_manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    @Builder.Default
    private Role role = Role.ROLE_USER; // valor por defecto

    //referencia de tareas
    private List<String> taskIds;


}
