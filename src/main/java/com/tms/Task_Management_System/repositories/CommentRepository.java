package com.tms.Task_Management_System.repositories;

import com.tms.Task_Management_System.entity.commentEntity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
