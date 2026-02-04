package com.tms.Task_Management_System.entity.commentEntity;

import com.tms.Task_Management_System.entity.taskEntity.Task;
import com.tms.Task_Management_System.entity.userEntity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commId;

    @Column(name =" comment",nullable = false,length = 225)
    private String commnent;

    @JoinColumn(name = "user")
    @ManyToOne
    @ToString.Exclude
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "task")
    private Task task;

    @Column(name =" createdAt")
    private String createdAt;
}
