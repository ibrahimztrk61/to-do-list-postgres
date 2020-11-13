package com.ibrahim.todolistpostgres.dtos.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class TaskRequest {

    private String id;
    private Long userId;
    private String category;
    private String description;
    private String duration;

}
