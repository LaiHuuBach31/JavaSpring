package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRole {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "userId",referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "roleId",referencedColumnName = "id")
	private Role role;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(Integer id, User user, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
