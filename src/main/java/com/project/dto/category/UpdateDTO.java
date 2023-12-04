package com.project.dto.category;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.project.validator.Unique;

public class UpdateDTO {
	
	private Integer id;
	@NotEmpty(message = "Tên không được để trống")
	@Unique(message = "Tên đã tồn tại")
	private String name;
	private MultipartFile image;
	private Boolean status;
	
	public UpdateDTO() {
		// TODO Auto-generated constructor stub
	}

	public UpdateDTO(Integer id, @NotEmpty(message = "Tên không được để trống") String name, MultipartFile image,
			Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
