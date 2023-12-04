<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>




<!-- Detail section -->
<section class="detail-section">
    <div class="container">
        <div class="detail-container">
            <div class="detail-image-holder">
                <img src="${pageContext.servletContext.contextPath}/resources/upload/menu/1.jpg" alt="${pro.name}">
            </div>
            <div class="detail-content">
                <h1 class="detail-title">${pro.name}</h1>
                <p class="detail-description">${pro.description}</p>
                <p class="detail-price"><strong>Price:</strong> $${pro.price}</p>
                <!-- Add more details as needed -->

                <div class="detail-buttons">
                    <a href="#" class="order-button">Order Now</a>
                    <a href="#" class="back-button">Back to Menu</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End Detail section -->

