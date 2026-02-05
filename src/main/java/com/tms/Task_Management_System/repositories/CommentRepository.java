package com.tms.Task_Management_System.repositories;

import com.tms.Task_Management_System.entity.commentEntity.Comment;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<List<Comment>> findByTask(Task task);
}
