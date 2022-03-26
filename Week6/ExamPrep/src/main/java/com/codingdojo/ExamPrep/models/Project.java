package com.codingdojo.ExamPrep.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Title must not be blank.")
	private String title;
	
	@NotEmpty(message = "Description must not be blank.")
	private String description;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "Due date must not be blank.")
	private Date dueDate;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lead_id")
	private User projectLead;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "project_members", 
			joinColumns = @JoinColumn(name = "project_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> projectMembers;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	public Project() {}
	
	public Project(String title, String description, Date dueDate, User projectLead) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.projectLead = projectLead;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getProjectLead() {
		return projectLead;
	}

	public void setProjectLead(User projectLead) {
		this.projectLead = projectLead;
	}

	public List<User> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(List<User> projectMembers) {
		this.projectMembers = projectMembers;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
