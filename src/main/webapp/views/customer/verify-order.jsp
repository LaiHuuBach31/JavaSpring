<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="padding: 15px; width: 600px; margin: auto; background: lightgreen">
		<h2>Hi: @</h2>
		<p>Below is your order information, please check and confirm your
			order by clicking the button below.</p>
		<p>
			<b>Note:</b> If after a period of time you do not confirm, the system
			will reject your order, where do you have to re-register from?
		</p>

		<h4>Your Information</h4>

		<table border="1" cellspacing="0" cellpadding="10" align="center">
			<tr>
				<td><strong>Name</strong></td>
				<td>@name</td>
			</tr>
			<tr>
				<td><strong>Address</strong></td>
				<td>@address</td>
			</tr>
		</table>

		<h4>Order Detail</h4>

		<table border="1" cellspacing="0" cellpadding="10" align="center">
			<tr>
				<th>STT</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Price</th>
			</tr>
			<c:forEach items="${list }">
				<tr>
					<td>{{$loop->index + 1}}</td>
					<td>{{$item->product_order->name}}</td>
					<td>${{$item->price}}</td>
					<td>{{$item->quantity}}</td>
					<td>${{$item->quantity * $item->price}}</td>
				</tr>
			</c:forEach>

			<tr>
				<th colspan="5">Total Price</th>
				<th>$ {{$order->totalPrice()}}</th>
			</tr>
		</table>

		<hr>
		<a href=""
			style="display: inline-block; padding: 15px 25px; background: green; color: #fff; font-weight: bold; text-decoration: none;">Vefiry
			your account</a>

		<hr>

	</div>
</body>
</html>