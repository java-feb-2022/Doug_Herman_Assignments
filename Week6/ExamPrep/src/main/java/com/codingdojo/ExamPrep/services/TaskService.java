package com.codingdojo.ExamPrep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ExamPrep.models.Project;
import com.codingdojo.ExamPrep.models.Task;
import com.codingdojo.ExamPrep.repositories.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo taskRepo;
	
	public Task createTask(Task t) {
		return taskRepo.save(t);
	}
	
	public List<Task> allTasksByProject(Project p){
		return taskRepo.findByProject(p);
	}
}
