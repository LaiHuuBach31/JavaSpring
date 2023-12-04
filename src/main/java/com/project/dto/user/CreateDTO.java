package com.project.dto.user;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.project.entities.Cart;
import com.project.entities.Order;
import com.project.entities.UserRole;

public class CreateDTO {
	private Integer id;
	@NotEmpty(message = "Tên không được để trống")
	private String userName;
	@NotEmpty(message = "Mật khẩu không được để trống")
	private String password;
	private Boolean enabled;
	@NotEmpty(message = "Họ tên không được để trống")
	private String fullName;
	@NotNull(message = "Tên không được để trống")
	private Boolean gender;
	@NotNull(message = "Ngày tháng năm sinh được để trống")
	private Date birthday;
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String address;
	@NotEmpty(message = "Email không được để trống")
	private String email;
	@NotEmpty(message = "Điện thoại không được để trống")
	private String telephone;
	private Set<UserRole> userRoles;
	private Set<Cart> carts;
	private Set<Order> orders;
	
	public CreateDTO() {
		
	}

	public CreateDTO(Integer id, @NotEmpty(message = "Tên không được để trống") String userName,
			@NotEmpty(message = "Mật khẩu không được để trống") String password, Boolean enabled,
			@NotEmpty(message = "Họ tên không được để trống") String fullName,
			@NotNull(message = "Tên không được để trống") Boolean gender,
			@NotNull(message = "Ngày tháng năm sinh được để trống") Date birthday,
			@NotEmpty(message = "Địa chỉ không được để trống") String address,
			@NotEmpty(message = "Email không được để trống") String email,
			@NotEmpty(message = "Điện thoại không được để trống") String telephone, Set<UserRole> userRoles,
			Set<Cart> carts, Set<Order> orders) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.userRoles = userRoles;
		this.carts = carts;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
