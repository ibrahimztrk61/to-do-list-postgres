package com.ibrahim.todolistpostgres.dtos.request;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserRequest {

    private String id;
    @NotNull
    private String name;
    private String surname;

}
