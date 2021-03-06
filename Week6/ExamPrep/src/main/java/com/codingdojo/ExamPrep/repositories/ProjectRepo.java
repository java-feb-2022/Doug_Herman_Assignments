package com.codingdojo.ExamPrep.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ExamPrep.models.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

	List<Project> findAll();
}
