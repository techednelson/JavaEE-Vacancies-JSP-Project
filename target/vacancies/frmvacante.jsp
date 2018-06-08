<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="favicon.ico">
    <title>Departamento de Recursos Humanos - My Company</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">
    <!--
    <script src='tinymce/tinymce.min.js'></script>
    <script>

      tinymce.init({
        selector: '#detalle',
        plugins: "textcolor, table",
        /* https://www.tinymce.com/docs/advanced/editor-control-identifiers/#toolbarcontrols */
        toolbar: "styleselect | undo redo | removeformat | bold italic underline | table \n\
                  aligncenter alignjustify  | bullist numlist outdent indent | link | print | \n\
                  fontselect fontsizeselect forecolor backcolor",
      });

    </script>
    -->
  </head>

  <body>

    <div class="container">
      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">My Company - Administration</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="#">Create vacancy</a></li>
            <li><a href="#">Vacancies</a></li>
            <li><a href="#">Exit</a></li>
          </ul>
        </nav>
      </div>

      <br>
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Create Vacancy</h3>
        </div>
        <div class="panel-body">
         <form action="vacancy" method="post">
            <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" name="name" required id="name" value="" placeholder="Enter the name of the vacancy">
            </div>
            <div class="form-group">
              <label for="description">Description</label>
              <textarea class="form-control" name="description" id="description" required rows="3" placeholder="Enter a description for the vacancy"></textarea>
            </div>
            <div class="form-group">
              <label for="details">Enter the details</label>
              <textarea class="form-control" name="details" id="details" rows="4" placeholder="Enter the details of the vacancy"></textarea>
            </div>
            <button type="submit" class="btn btn-default" >Save</button>
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