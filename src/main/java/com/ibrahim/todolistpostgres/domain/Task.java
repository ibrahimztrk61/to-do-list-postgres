package com.ibrahim.todolistpostgres.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Task implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_tasks", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_tasks", strategy = GenerationType.SEQUENCE)
    private String id;

    @OneToOne
    @JoinColumn(name = "user_task_id")
    private User user;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "description",length = 150)
    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "duration")
    private String duration;
}
