package com.project.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private Boolean enabled;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "gender")
	private Boolean gender;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "telephone")
	private String telephone;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<UserRole> userRoles;
	
	@OneToMany(mappedBy = "user")
	private Set<Cart> carts;
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orders;

	public User() {
		
	}

	public User(Integer id, String userName, String password, Boolean enabled, String fullName, Boolean gender,
			Date birthday, String address, String email, String telephone, Set<UserRole> userRoles, Set<Cart> carts,
			Set<Order> orders) {
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
