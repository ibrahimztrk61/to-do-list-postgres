package com.ibrahim.todolistpostgres.dtos.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequest {

    private String category;
    private String description;
    private String duration;
}
