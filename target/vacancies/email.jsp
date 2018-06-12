<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <h3 class="text-muted">My Company - Administration</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="admin?action=crear">Add vacancy</a></li>
            <li><a href="vacancy?action=list">Vacancies</a></li>
            <li><a href="application?action=applications">Applications</a></li>
            <li><a href="admin?action=logout">Exit</a></li>
          </ul>
        </nav>
      </div>

      <br>
      <div class="panel panel-info">
        <div class="panel-heading">
          <h3 class="panel-title">Reply by Email</h3>
        </div>
        <div class="panel-body">

          <p class="text-danger">${message}</p>

          <form action="email" method="post">
            <div class="form-group">
              <label for="destiny">Destination</label>
              <input type="text" class="form-control" name="destiny" readonly id="destiny" value="${email}" >
            </div>
            <div class="form-group">
              <label for="subject">Asunto</label>
              <input type="text" class="form-control" name="subject" required id="subject" placeholder="Email subject">
            </div>
            <div class="form-group">
              <label for="message">Mensaje</label>
              <textarea class="form-control" name="message" id="message" required rows="3" placeholder="Enter the E-Mail body"></textarea>
            </div>
            <button type="submit" class="btn btn-default" >Enviar correo</button>
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
