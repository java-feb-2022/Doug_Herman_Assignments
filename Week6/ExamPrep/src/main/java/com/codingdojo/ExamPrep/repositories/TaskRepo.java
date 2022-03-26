package com.codingdojo.ExamPrep.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ExamPrep.models.Project;
import com.codingdojo.ExamPrep.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

	List<Task> findByProject(Project project);
}
