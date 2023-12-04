package com.project.dto.order;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class CreateDTO {
	
	private Integer id;
	private Boolean status;
	@NotEmpty(message = "Vui lòng chọn phương thức giao hàng")
	private String shippingMethod;
	@NotEmpty(message = "Vui lòng chọn phương thức thanh toán")
	private String paymentMethod;
	private String orderNote;
	private Date orderDate;
	private String orderCode;
	private String token;
	
	public CreateDTO() {
		
	}

	public CreateDTO(Integer id, Boolean status,
			@NotEmpty(message = "Vui lòng chọn phương thức giao hàng") String shippingMethod,
			@NotEmpty(message = "Vui lòng chọn phương thức thanh toán") String paymentMethod, String orderNote,
			Date orderDate, String orderCode, String token) {
		super();
		this.id = id;
		this.status = status;
		this.shippingMethod = shippingMethod;
		this.paymentMethod = paymentMethod;
		this.orderNote = orderNote;
		this.orderDate = orderDate;
		this.orderCode = orderCode;
		this.token = token;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
