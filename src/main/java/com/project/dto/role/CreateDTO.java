package com.project.dto.role;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.project.entities.UserRole;

public class CreateDTO {
	
		private Integer id;
		@NotEmpty(message = "Tên không được để trống")
		private String name;
		private Set<UserRole> roleUsers;

		public CreateDTO() {
			
		}

		public CreateDTO(Integer id, @NotEmpty(message = "Tên không được để trống") String name,
				Set<UserRole> roleUsers) {
			super();
			this.id = id;
			this.name = name;
			this.roleUsers = roleUsers;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<UserRole> getRoleUsers() {
			return roleUsers;
		}

		public void setRoleUsers(Set<UserRole> roleUsers) {
			this.roleUsers = roleUsers;
		}

		
}
