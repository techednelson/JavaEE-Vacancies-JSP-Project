<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>CV submit</title>
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
            <li><a href="About.jsp">About</a></li>
          </ul>
        </nav>
      </div>
      <br>

      <h4><font color="red">${message}</font></h4>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Submit CV for a vacancy: ${vacancy.name}</b></h3>
        </div>
        <div class="panel-body">

          <form action="application" method="post" enctype="multipart/form-data">
             <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" name="name" value="${application.name}" required id="nombre">
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" name="email" value="${application.email}" required id="email">
            </div>
            <div class="form-group">
              <label for="phone">Phone</label>
              <input type="text" class="form-control" name="phone" value="${application.phone}" required id="telefono">
            </div>
            <div class="form-group">
              <label for="address">Address</label>
              <input type="text" class="form-control" name="address" value="${application.address}" required id="direccion">
            </div>
            <div class="form-group">
              <label for="file">Upload CV</label>
              <input type="file" required id="file" name="file">
              <p class="help-block">Just [ pdf,doc,docx ] files allowed</p>
            </div>
            <input type="hidden" value="${vacancy.id}" name="idVacancy">
            <button type="submit" class="btn btn-success" >Send</button>
          </form>

        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2018 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
