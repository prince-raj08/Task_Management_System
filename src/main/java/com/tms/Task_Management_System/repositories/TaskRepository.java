package com.tms.Task_Management_System.repositories;

import com.tms.Task_Management_System.entity.taskEntity.Task;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
