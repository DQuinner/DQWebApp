<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="DQ Web Login">
    <meta name="author" content="DQ">
    <link rel="icon" href="">

    <title>DQ Web Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="css/dq-login.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
    <link href="css/dq-web.css" rel="stylesheet">
  </head>

<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

		<nav class="navbar navbar-inverse navbar-fixed-top">
         <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
             <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
           </button>
           <a class="navbar-brand">DQ Web Login</a>
          </div>
		  <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a data-toggle="modal" data-target="#about-modal">About</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Links <span class="caret"></span></a>
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
            <form:form method="POST" action="dq-web-ui/j_spring_security_check" class="navbar-form navbar-right" >
              <c:if test="${!empty param.login_error}">
				<div class="form-group" style="color: red;"> Invalid username or password    </div>
			  </c:if>
			  <c:if test="${!empty param.logout}">
				<div class="form-group" style="color: red;"> Logged out successfully    </div>
			  </c:if>
              <div class="form-group">
                <input type="text" placeholder="Username" class="form-control" id="j_username" name="j_username">
              </div>
              <div class="form-group">
                <input type="password" placeholder="Password" class="form-control" id="j_password" name="j_password">
              </div>
			  <input type="submit" name="submit" class="btn btn-success" value="Sign in">
			  <a class="btn btn-dq" data-toggle="modal" data-target="#add-user-modal">Register</a>
            </form:form>
           </div><!--/.navbar-collapse -->
          </div>
        </nav>
      </div>
    </div>

<!-- Carousel
================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mOIL/7/HwAF1wLRg4pnYQAAAABJRU5ErkJggg==" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>DQ Web</h1>
              <p>DQ Web is an application to learn and demo web technologies</p>
              <p><a class="btn btn-lg btn-dq" data-toggle="modal" data-target="#add-user-modal" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mPo9//8HwAGEwLRhOMLQQAAAABJRU5ErkJggg==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Bootstrap Framework</h1>
              <p>DQ Web UI developed using Bootstrap Framework HTML CSS and Javascript</p>
              <p><a class="btn btn-lg btn-dq" href="http://getbootstrap.com/" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNI2qj/HwAE/QJCUH1z+QAAAABJRU5ErkJggg==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Spring Framework</h1>
              <p>DQ Web Application developed using Java EE Spring Framework</p>
              <p><a class="btn btn-lg btn-dq" href="http://projects.spring.io/spring-framework/" role="button">Learn More</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
    
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->
    <div class="container marketing">
      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-thumbnail" src="image/bootstrap-logo.jpg" alt="Generic placeholder image" width="140" height="140"> 
		  <h2></h2>
          <p>DQ Web UI developed using Bootstrap Framework HTML CSS and Javascript</p>
          <!-- <p><a class="btn btn-lg btn-primary" href="http://getbootstrap.com/" role="button">Learn More &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-thumbnail" src="image/spring-logo.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2></h2>
          <p>DQ Web Application developed using JEE Spring Framework</p>
          <!-- <p><a class="btn btn-lg btn-primary" href="http://projects.spring.io/spring-framework/" role="button">Learn More &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-thumbnail" src="image/java-logo.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2></h2>
          <p>DQ Web runs on Tomcat supported by Java 7, OracleXE and Hibernate</p>
          <!-- <p><a class="btn btn-lg btn-primary" href="https://www.java.com/" role="button">Learn More &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
	  <hr>
<!-- FOOTER -->
      <footer class="centre-text-dq">
        <p>&copy; DQ.IE 2015</p>
      </footer>
    </div><!-- /.container -->
    
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
				  <p>Spring Framework MVC Core Security</p>
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
					  <input type="text" class="form-control" id="firstname">
					</div>
					<div class="form-group">
					  <label for="surname">Surname:</label>
					  <input type="text" class="form-control" id="surname">
					</div>
				</div>
				<div class="modal-footer dq-light-grey centre-text-dq">
				  <button type="button" class="btn btn-dq" data-dismiss="modal">Register</button>
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
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>