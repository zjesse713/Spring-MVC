<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

 <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>

<p><a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=green">Green </a> |
<a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=red">Red </a></p>


<a href ="/FirstSpringMVCProject/admissionForm.html?siteLanguage=en">English</a> | 
<a href ="/FirstSpringMVCProject/admissionForm.html?siteLanguage=fr">French</a>

	<h1><spring:message code ="label.headerMsg"/></h1>
	<h3><spring:message code ="label.admissionForm"/></h3>



	<form:errors path ="student1.*"/>

	<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
	<table>
	<tr>
		<td><spring:message code ="label.studentName"/></td><td>	 <input type ="text" name="studentName"/></td>
	</tr>
	<tr>
		<td><spring:message code ="label.studentHobby"/></td><td>	 <input type ="text" name="studentHobby"/></td>
	</tr>
	<tr>
		<td><spring:message code ="label.studentMobile"/></td><td>	 <input type ="text" name="studentMobile"/></td>
	</tr>
	<tr>
		<td><spring:message code ="label.studentDoB"/></td><td>	 <input type ="text" name="studentDoB"/></td>
	</tr>
	<tr>
		<td><spring:message code ="label.studentSkills"/></td><td> 	 <select name="studentSkills" multiple>
													<option value = "Java core">Java Core</option>
													<option value = "Spring core">Spring Core</option>
													<option value = "Spring MVC">Spring MVC</option>
												  </select></td>
	</tr>	
	</table>

	<table>
		<tr><td><spring:message code ="label.studentAddress"/></td></tr>
	<tr>
		<td><spring:message code ="label.country"/><input type = "text" name="studentAddress.country"/></td>
		<td><spring:message code ="label.city"/><input type = "text" name="studentAddress.city"/></td>
		<td><spring:message code ="label.street"/><input type = "text" name="studentAddress.street"/></td>
		<td><spring:message code ="label.pincode"/><input type = "text" name="studentAddress.pincode"/></td>
	</tr>
	
	</table>
		<spring:message code ="label.submit.admissionForm" var="sumbitText"/>
		<input type="submit" value="${sumbitText}" />
	
	</form>


</body>
</html>