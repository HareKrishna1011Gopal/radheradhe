<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO Registration</title>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
	
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

input[type=submit]{
  width:100%;
  align-content:center;
  margin: 10px 0 5px 0;
  display: inline-block;
  padding:10px;
  border:thin;
  background: #f1f1f1;
} 

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

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js" /></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js>
	
</script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 
<script type="text/javascript">
	$(function() {
		$('form[id="registerForm"]').validate({
			rules : {

				fname : 'required',
				lname : 'required',
				email : {
					required : true,
					email : true,
				},
				dob : 'required',
				phNo:'required',
				ssn : 'required',
			},
			messages : {
				fname : 'please enter first name',
				lname : 'please enter last name',
				dob : 'please enter dob',
				email : 'please Enter a valid email',
				phNo:'Please Enter valid Phone No',
				ssn : 'please enter ssn no',
			},

			submitHandler : function(form) {

				form.submit();
			}

		});
		$("#datepicker").datepicker();
	});
</script>
<script type="text/javascript">
	$(document).ready(function($) {
		$('#ssn').mask("999 999 9999", {
			placeholder : "xxx xxx xxxx"
		});
	})
	
	$( function() {
    $( "#datepicker" ).datepicker();
  } );

</script>

</head>
<body>

	<form:form action="owner1.htm" method="POST" modelAttribute="ownerdata"
		id="registerForm">
		<div class="container">
			<h2 style="color: red; text-align: center">Register</h2>
			<p style="color: blue; text-align: center">Please fill in this
				form to Register Vehicle Owner Details</p>
			<hr>
			<table align="center">
				<tr>
					<th>FirstName:</th>
					<td><form:input path="fname" placeholder="Enter FirstName"/></td>
				</tr>
				<tr>
					<th>LastName:</th>
					<td><form:input path="lname" placeholder="Enter LastName"/></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><form:input path="email" placeholder="Enter Your Email"/></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td style="text-align: center">M<form:radiobutton path="gender" value="M" name=""/></td>
					<td style="text-align: center">F<form:radiobutton path="gender" value="F"/></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><form:input path="dob" id="datepicker" /></td>
				</tr>
				<tr>
					<th>PhNo:</th>
					<td><form:input path="phNo" placeholder="Enter Phone No"/></td>
				</tr>
				<tr>
					<th>SSN:</th>
					<td><form:input path="ssn" id="ssn" /></td>
				</tr>			
			</table>
			   <input type="submit" value="Next" class="registerbtn" style="width: 100%;;">
			<hr>
		</div>
	</form:form>
</body>
</html>