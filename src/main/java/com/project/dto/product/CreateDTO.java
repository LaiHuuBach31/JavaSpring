package com.project.dto.product;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.project.entities.Cart;
import com.project.entities.Category;
import com.project.entities.OrderDetail;
import com.project.validator.FileNotNull;
import com.project.validator.ValidImage;


public class CreateDTO {
	private Integer id;
	@NotEmpty(message = "Tên không được để trống")
	private String name;
	@NotNull(message = "Gía không được để trống")
	private Float price;
	@FileNotNull(message = "Ảnh không được để trống")
	@ValidImage(type = {"image/jpeg","image/png","image/jpg"}, message = "Ảnh không đúng định dạng")
	private MultipartFile image;
	private Boolean status;
	private String description;
	private Category category;
	private Set<Cart> carts;
	private Set<OrderDetail> productOrder;
	
	public CreateDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public CreateDTO(Integer id, @NotEmpty(message = "Tên không được để trống") String name,
			@NotNull(message = "Gía không được để trống") Float price, MultipartFile image, Boolean status,
			String description, Category category, Set<Cart> carts, Set<OrderDetail> productOrder) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.status = status;
		this.description = description;
		this.category = category;
		this.carts = carts;
		this.productOrder = productOrder;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<OrderDetail> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Set<OrderDetail> productOrder) {
		this.productOrder = productOrder;
	}

	
}
