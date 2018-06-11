<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>System Administration</title>
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
        <h3 class="text-muted">My Company - Administration</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="admin?action=crear">Add vacancy</a></li>
            <li><a href="vacante?action=lista">Vacancies</a></li>
            <li><a href="admin?action=logout">Exit</a></li>
          </ul>
        </nav>
      </div>
      <br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Welcome ${person.personName}</h3>
        </div>
        <div class="panel-body">
          <h2 class="panel-title"><b>Username</b><br> ${person.userName}<br><br></h2>
          <h2 class="panel-title"><b>Email</b><br> ${person.email}<br><br></h2>
          <h2 class="panel-title"><b>Profile</b><br> ${person.profile}<br><br></h2>
          <h2 class="panel-title"><b>Status</b><br>${person.status}<br><br></h2>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2018 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
