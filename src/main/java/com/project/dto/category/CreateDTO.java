package com.project.dto.category;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.project.validator.FileNotNull;
import com.project.validator.Unique;
import com.project.validator.ValidImage;

public class CreateDTO {

	@NotEmpty(message = "Tên không được để trống")
	@Unique(message = "Tên đã tồn tại")
	private String name;
	@FileNotNull(message = "Ảnh không được để trống")
	@ValidImage(type = {"image/jpeg","image/png","image/jpg"},message = "Ảnh không đúng định dạng")
	private MultipartFile image;
	private Boolean status;
	
	public CreateDTO() {
		
	}

	public CreateDTO(@NotEmpty(message = "Tên không được để trống") String name, MultipartFile image, Boolean status) {
		super();
		this.name = name;
		this.image = image;
		this.status = status;
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
