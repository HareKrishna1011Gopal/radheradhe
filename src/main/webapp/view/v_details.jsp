<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO Registration</title>
<style>
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
 <!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
 -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"
	type="text/javascript"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			vtype : 'required',
			model : 'required',
			vname : 'required',
		},
		messages : {
			vtype : 'please enter Vehicle Type',
			model : 'please enter model ',
			vname : 'please Enter Vehicle name',
			
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
</script>
<!--  <input class="date-own form-control" style="width: 300px;" type="text"> -->

<!-- 
  <script type="text/javascript">
      $('#yearDatePicker').datepicker({
         minViewMode: 2,
         format: 'yyyy'
       });
  </script> -->
</head>
<body>
	<form:form action="vehicle1.htm" method="POST"
		modelAttribute="vehicledata" id="registerForm">
		<div class="container" id="vehicle_form">
			<h2 style="text-align: center; color: red">Register</h2>
			<p id="demo" align="center">
				<b>Please fill in this form to Register Vehicle Details</b>
			</p>
			<hr>
			<table align="center">
				<tr>
					<th>Vehicle Type:</th>
					<td><form:select path="vtype" items="${vehiclelist}" style="width: 200px;height:30px;"></form:select></td>
				</tr>
				<tr>
					<th>Model:</th>
					<td><form:input path="model" placeholder="Enter Model Number"/></td>
				</tr>
				<tr>
					<th>Company Name:</th>
					<td><form:input path="vname" placeholder="Enter Company Name"/></td>
				</tr>
				<tr>
				   <td><a href="previousOwner?ownerId=${ownerId}">Previous</a>
			<input type="submit" value="Next" class="registerbtn"></td>
				</tr>
			</table>
			<hr>
		</div>
	</form:form>
</body>
</html>