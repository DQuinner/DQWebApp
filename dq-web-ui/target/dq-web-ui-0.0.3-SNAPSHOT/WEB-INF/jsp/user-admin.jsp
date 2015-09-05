<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="DQ Web User Admin">
    <link rel="icon" href="">

    <title>DQ Web Home User Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
    <link href="css/dq-web.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top dq-dark-grey">
      <div class="container">
        <div class="navbar-header pull-left">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">DQ Web User Admin</a>
        </div>
		<div class="navbar-header pull-right" >
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
		    <span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		  <p class="navbar-text">
			<a class="navbar-link" href="/dq-web-ui/login">Logout</a>
		  </p>  
		</div>
		<div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
			    <li><a class="active" href="/dq-web-ui/home">Home</a></li>
				<li><a href="/dq-web-ui/media">Media</a></li>
				<li><a>Admin</a></li>
                <li><a data-toggle="modal" data-target="#about-modal" role="button">About</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Links<span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">Frameworks</li>
					<li><a href="http://projects.spring.io/spring-framework/">Spring</a></li>
                    <li><a href="http://getbootstrap.com/">Bootstrap</a></li>
					<li><a href="https://jquery.com/">JQuery</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Web</li>
                    <li><a href="http://www.w3.org/html/">HTML</a></li>
                    <li><a href="http://www.w3.org/Style/CSS/Overview.en.html">CSS</a></li>
					<li><a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/About_JavaScript">Javascript</a></li>
                  </ul>
                </li>
              </ul>
           </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron dq-blue-image">
      <div class="container">
        <h1>DQ Web User Administration</h1>
        <p>Use this section to search and edit users with spring hibernate and oracle</p>
		<button type="button" class="btn btn-lg btn-dq" data-toggle="modal" data-target="#add-user-modal" role="button">Add User</button>
		<button type="button" class="btn btn-lg btn-dq" data-toggle="modal" data-target="#edit-user-modal" role="button">Edit User</button>
      </div>
    </div>

    <div class="container">
     <div class="row">
		<table class="table table-bordered">
		<thead>
		<tr>
			<th>#</th>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${allUsers}" var="user">
		  <tr>
			<td>1</td>
			<td>${user.username}</td>
			<td>${user.email}</td>
			<td>${user.password}</td>
			<td>${user.forename}</td>
			<td>${user.surname}</td>
		  </tr>	
		</c:forEach>
		</tbody>
	    </table>
		</div>
	</div>

      <hr>

       <!-- FOOTER -->
      <footer class="centre-text-dq">
        <p>&copy; DQ.IE 2015</p>
      </footer>
    </div> <!-- /container -->

	<!-- Add User Modal -->
	<div class="modal fade" id="add-user-modal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header dq-dark-grey">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Enter User Information</h4>
				</div>
				<div class="modal-body dq-light-blue">
					<div class="form-group">
					  <label for="email">Email:</label>
					  <input type="email" class="form-control" id="email">
					</div>
					<div class="form-group">
					  <label for="password">Password:</label>
					  <input type="password" class="form-control" id="password">
					</div>
					<div class="form-group">
					  <label for="username">Username:</label>
					  <input type="text" class="form-control" id="username">
					</div>
					<div class="form-group">
					  <label for="firstname">Firstname:</label>
					  <input type="text" class="form-control" id="forename">
					</div>
					<div class="form-group">
					  <label for="surname">Surname:</label>
					  <input type="text" class="form-control" id="surname">
					</div>
					<div class="modal-footer dq-light-grey centre-text-dq">
				  		<button id="btnAddUserModal" type="button" class="btn btn-dq" >Register</button>
				  		<button id="btnCloseAddUserModal" type="button" class="btn btn-dq" data-dismiss="modal">Close</button>
				  		<!-- <input type="button" class="btn btn-dq" id="btnAddUserModal" value="Register" onclick="doAjaxPost()"/> -->
				  		<!-- <input type="button" class="btn btn-dq" data-dismiss="modal" value="Close"/> -->
				  		<hr>
				  		<p>&copy; DQ.IE 2015</p>
					</div>
				</div>
			 </div>
		</div>
	</div>
	
	<!-- Edit User Modal -->
	<div class="modal fade" id="edit-user-modal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header dq-dark-grey">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Edit User Information</h4>
				</div>
				<div class="modal-body dq-light-blue">
					<div class="form-group">
					  <label for="email">Email:</label>
					  <input type="email" class="form-control" id="email" value="donalq@gmail.com">
					</div>
					<div class="form-group">
					  <label for="password">Password:</label>
					  <input type="password" class="form-control" id="password" value="1234578">
					</div>
					<div class="form-group">
					  <label for="username">Username:</label>
					  <input type="text" class="form-control" id="username" value="dquinner">
					</div>
					<div class="form-group">
					  <label for="firstname">Firstname:</label>
					  <input type="text" class="form-control" id="firstname" value="Donal">
					</div>
					<div class="form-group">
					  <label for="surname">Surname:</label>
					  <input type="text" class="form-control" id="surname" value="Quinn">
					</div>
				</div>
				<div class="modal-footer dq-light-grey centre-text-dq">
				  <button type="button" class="btn btn-dq" data-dismiss="modal">Update</button>
				  <button type="button" class="btn btn-dq" data-dismiss="modal">Close</button>
				  <hr>
				  <p>&copy; DQ.IE 2015</p>
				</div>
			 </div>
		</div>
	</div>
	
	<!-- About Modal -->
	<div class="modal fade" id="about-modal" role="dialog">
		<div class="modal-dialog centre-text-dq">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header dq-dark-grey">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">About DQ Web</h4>
				</div>
				<div class="modal-body dq-light-blue">
				  <p>DQ Web App demos technologies such as</p>
				  <p>Bootstrap HTML Javascript CSS</p>
				  <p>Spring Framework MVC Core</p>
				  <p>Java EE Hibernate</p>
				  <p>Tomcat Oracle</p>
				</div>
				<div class="modal-footer dq-light-grey centre-text-dq">
				  <button type="button" class="btn btn-dq" data-dismiss="modal">Close</button>
				  <hr>
				  <p>&copy; DQ.IE 2015</p>
				</div>
			 </div>
		</div>
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function() {
            $("#btnAddUserModal").click(function(event){
			   alert("Calling doAjaxAddUser()");
			   doAjaxAddUser();
			   alert("doAjaxAddUser() done");
			   $(".add-user-modal").hide(1000);
            });
         });
     </script>
     
     <script type="text/javascript">
		function doAjaxAddUser() {
			// get the form values
			var username = $('#username').val();
			var password = $('#password').val();
			var email = $('#email').val();
			var forename = $('#forename').val();
			var surname = $('#surname').val();
	
			$.ajax({
		        type: "POST",
		        url: "/dq-web-ui/add-user",
		        data: "username=" + username + "&password=" + password + "&email=" + email + "&forename=" + forename + "&surname=" + surname,
		        success: function(response){
		        	
		        	if(response=="USER_ADDED"){
		        		alert(username + "USER_ADDED");
		        	}else{
		        		alert("ERROR:" +response);
		        	}
					// we have the response
					//$('#info').html(response);
					//alert(response);
					//$(".add-user-modal").hide(1000);
					//$('#username').val('');
			        //$('#password').val('');
			        //$('#email').val('');
			        //$('#forename').val('');
			        //$('#surname').val('');
				},
				error: function(e){
					alert('Error: ' + e);
				}});
			}
	    </script>
  </body>
</html>