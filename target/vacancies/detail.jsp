<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Detalle de la vacance - Ingeniero en procesos de inyeccion de plasticos</title>
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
            <li><a href="homepage">Home</a></li>
            <li><a href="admin?action=login">Administration</a></li>
            <li><a href="about.jsp">About</a></li>
          </ul>
        </nav>
      </div>
      <form method ="post" action="#" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Search offer..." class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Search</button>
      </form>
      <br><br><br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Vacancy Number</h3>
        </div>
        <div class="panel-body">
          <h5><b>Vacancy: </b>${vacancy.vacancyName}</h5>
          <h5><b>Publication</b>${vacancy.publishDate}</h5>
          <b>Description: </b><br>
          <p class="text-justify">${vacancy.description}</p>
          <b>Vacancy details</b>:<br>
          ${vacancy.details}
        </div>
      </div>
      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2018 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
