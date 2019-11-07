<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO Registration</title>
<style type="text/css">
    body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
  padding-right: 350px;
  padding-left: 350px;
  padding-top: 50px;
  padding-bottom: 100px;
}

.error {
	color: red;
}
/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
  
  
}
/* Full-width input fields */
input{
  width: 100%;
  margin: 10px 0 5px 0;
  display: inline-block;
  padding:10px;
  border: none;
  background: #f1f1f1;
} 

/* a{
 width:80%;
  margin: 10px 0 15px 0;
  display: inline-block;
  padding:10px;
  border: none;
  background: #f1f1f1;
}
 */
/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
b{
   text-align:center;
  color:orange;
}
.registerbtn:hover {
  opacity: 1;
}
  
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js" /></script>
<script type="text/javascript">
	$(function() {
		$('form[id="registerForm"]').validate({
			rules : {
				houseno : 'required',
				street : 'required',
				city : 'required',
				zip : 'required'
			},
			messages : {
				houseno : 'please enter House no',
				street : 'please enter street no',
				city : 'please Enter a city name',
				zip : 'please enter a zip code'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
  <form:form action="address1.htm" method="POST" modelAttribute="addrdata" id="registerForm">
  <div class="container">
			<h2 style="text-align: center;color:red">Register</h2>
			<p id="demo">Please fill in this form to Register Vehicle Details</p>
			<hr>
			<table align="center">
				<tr>
					<th>House No:</th>
					<td><form:input path="houseno" placeholder="Enter HouseNo"/></td>
				</tr>
				<tr>
					<th>Street:</th>
					<td><form:input path="street" placeholder="Enter Street"/></td>
				</tr>
				<tr>
					<th>City:</th>
					<td><form:input path="city" placeholder="Enter CityName"/></td>
				</tr>
				<tr>
					<th>Zip Code:</th>
					<td><form:input path="zip" placeholder="Enter Zip Code"/></td>
				</tr>
				<tr>
				
					<td><a href="previousVehicle.htm?vehicleId=${vehicleId}">Previous</a>
			<input type="submit" value="Next" class="registerbtn">
			</td>
				</tr>
			</table>
			<hr>
		</div>
  </form:form>
</body>
</html>