<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO Registration</title>
<style type="text/css">
  .container {
  padding: 16px;
  padding-right: 400px;
  padding-left: 400px;
  border-radius:10px;
  border-color: black;
}

b{
   text-align:center;
  color:orange;
}
</style>
<script>
 function display_alert()
 {
 alert("Are U Really Want To Register?");
 }
 </script>
</head>
<body>
    <h1 style="color: Red;text-align:center;">Final Registration Form</h1>
    <br>
    <marquee style="font-style: italic;color:green;">Note:-Check  All Details Before Submitting Registration Form</marquee>
	<hr>
	<div class="container">
	<h3 style="color:blue;text-align: center;">Owner Details</h3>
	<table align="center">
	
		<tr>
			<td>First Name:</td>
			<td>${ownerData.fname}</td>
		<tr>
		<tr>
			<td>Last Name:</td>
			<td>${ownerData.lname}</td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td>${ownerData.email}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${ownerData.gender}</td>
		</tr>
		<tr>
			<td>Date Of Birth:</td>
			<td>{ownerData.dob}</td>
		</tr>
		<tr>
			<td>Phone No</td>
			<td>${ownerData.phNo}</td>
		</tr>
		<tr>
			<td>SSN No:</td>
			<td>${ownerData.ssn}</td>
		</tr>
		</table>
		<hr>
		<h3 style="color: blue;text-align: center;">Owner Address Details</h3>
		<table align="center">
		  <tr>
			<td>House No:</td>
			<td>${addressData.houseno}</td>
		</tr>
		<tr>
			<td>Street No:</td>
			<td>${addressData.street}</td>
		</tr>
		<tr>
			<td>City Name:</td>
			<td>${addressData.city}</td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td>${addressData.zip}</td>
		</tr>
		</table>
		<hr>
		<h3 style="color: blue;text-align: center">Owner Vehicle Details</h3>
		<table align="center">
		<tr>
			<td>Vehicle Type</td>
			<td>${vehicleData.vtype}</td>
		</tr>
		<tr>
			<td>Vehicle Model Year</td>
			<td>${vehicleData.model}</td>
		</tr>
		<tr>
			<td>Vehicle Company</td>
			<td>${vehicleData.vname}</td>
		</tr>
	</table>
	</div>
<hr>
	<form:form action="registration1.htm" method="POST" modelAttribute="register">
		<h2 style="text-align: center; color: red">Register</h2>
		<p id="demo" align="center">
			<b style="color:gray;">Please fill in this form to Register</b>
		</p>
		<table align="center">
			<tr>
				<th>Reg Date:</th>
				<td><form:input path="regdate" /></td>
			</tr>
			<tr>
				<th>Reg Center:</th>
				<td><form:input path="regcenter" /></td>
			</tr>
			<tr>
				<td><a href="previousAddress.htm?addrId=${addrId}">previous</a></td>
				<td><input type="submit" value="Register" onclick="display_alert()"></td>
			</tr>
		</table>
		<hr>
	</form:form>
</body>
</html>