<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link rel="stylesheet" href="css/styles.css"/>
	<link rel="stylesheet" href="css/layout.css"/>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<header>
	<h1>User Registration Complete</h1>
</header>

<section class="left-section">
</section>
<section class="centre-section">
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