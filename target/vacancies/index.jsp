<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Human Resources Department - My Company</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">My Company</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="#">Home</a></li>
            <li><a href="#">Administration</a></li>
            <li><a href="#">About</a></li>
          </ul>
        </nav>
      </div>

      <!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->
      <form method ="post" action="#" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Search offer..." class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Search</button>
      </form>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>FIND YOU IDEAL JOB!</h2>
        <!--
        <h4>WE ARE HIRING</h4>
        -->
        <p class="lead text-justify">Welcome to My Company, here you can find job offers that
         match with your profile, experiences and location.

          it is very easy to use, just click one vacancy, log in to see the details and send us your CVin PDF or DOCX format.
          We will review your Cv and We will contact you back.
            <br><br>

        <p><a class="btn btn-lg btn-success" href="#" role="button">See more offers</a></p>
      </div>

      <h1>Recent Job offers</h1>

     <!-- Example row of columns -->
      <div class="row">


        <c:forEach items = "${recent}" var = "vacancy" varStatus = "status">

            <div class="col-lg-4">
              <h2>${vacancy.id}</h2>
              <p class="text-danger text-justify">${vacancy.vacancyName}</p>
              <p class="text-justify">${vacancy.description}</p>
              <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
            </div>

        </c:forEach>

      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2018 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
