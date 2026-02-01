package com.tms.Task_Management_System.entity.taskEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tms.Task_Management_System.Enums.Status;
import com.tms.Task_Management_System.entity.userEntity.User;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column(name = "tittle",nullable = false,length = 100)
    private String tittle;
    @Column(name = "description",nullable = false,length = 255)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "createdAt",nullable = false)
    private String createdAt;
    @Column(name = "updatedAt",nullable = false)
    private String updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
