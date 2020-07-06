<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list</title>
<!--reference style sheet, pageContext.request.contextPath returns proper app name-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add customer"
				onClick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<%-- customers is the model obtained from CustomerController --%>
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct/define an "update" link with customer id parameter -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct/define an "delete" link with customer id parameter -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display the update link --> 
							<a href="${updateLink}">Update</a>
							| 
							<a href="${deleteLink}"
							   onClick="if(!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>