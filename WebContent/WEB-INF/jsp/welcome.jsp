<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
  function formSubmit() {
    document.getElementById("logoutForm").submit();
  }
</script>
</head>
<body>
	Welcome after login
	<hr/>

	<form id="logoutForm" action="/ceit1302springsecurity/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	welcome:${username}|<a href="javascript:formSubmit()"> Logout</a>
</body>
</html>