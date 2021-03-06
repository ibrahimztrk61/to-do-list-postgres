package com.ibrahim.todolistpostgres.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
public class Task implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_tasks", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_tasks", strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "description",length = 150)
    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "duration")
    private String duration;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
