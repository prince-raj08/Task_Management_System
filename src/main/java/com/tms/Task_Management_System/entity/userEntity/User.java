package com.tms.Task_Management_System.entity.userEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tms.Task_Management_System.Enums.IsActive;
import com.tms.Task_Management_System.entity.commentEntity.Comment;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.core.SpringVersion;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name",nullable = false,length = 50)
    private String userName;
    @Column(name = "email",nullable = false,length = 50,unique = true)
    private String email;
    @Column(name = "mobile",nullable = false,length = 10,unique = true)
    private String mobile;
    @Column(name = "password",nullable = false,length = 15)
    private String password;
    @Enumerated(EnumType.STRING)
    private IsActive isActive;
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Task> task;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}
