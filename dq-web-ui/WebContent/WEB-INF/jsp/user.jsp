<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link rel="stylesheet" href="css/styles.css"/>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Register User Information</h2>
<form:form method="POST" action="/dq-web-ui/add-user">
	<fieldset class="login-info">
		<label>
			Username:
			<input type="text" name="username">
		</label>
		<label>
			Password:
			<input type="password" name="password">
		</label>
		<label>
			Email:
			<input type="email" name="email">
		</label>
		<label>
			Forename:
			<input type="text" name="forename">
		</label>
		<label>
			Surname:
			<input type="text" name="surname">
		</label>
	</fieldset>
	<fieldset class="login-action">
		<table>
			<tr>
				<td>
					<input class="btn" type="submit" value="Register">
				</td>
				<td>
					<input class="btn" onclick="location.href='home'" value="Home">
				</td>				
			</tr>
		</table>
	</fieldset>  
</form:form>
</section>
<section class="right-section">
</section>
<footer>
	Copyright DQ.IE 2015
</footer>
</body>
</html>