<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Applications List</title>
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
            <li><a href="admin?action=create">Add vacancy</a></li>
            <li><a href="vacancy?action=list">Vacancies</a></li>
            <li><a href="application?action=applications">Applications</a></li>
            <li><a href="admin?action=logout">Exit</a></li>
          </ul>
        </nav>
      </div>
      <br>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Applications Received list</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">Date</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Apply for</th>
                <th>Options</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${applications}" var="application" varStatus="status">
                <tr>
                  <td class="left">${application.date}</td>
                  <td>${application.name}</td>
                  <td>${application.email}</td>
                  <td>${application.phone}</td>
                  <td>${application.address}</td>
                  <td>${application.vacancy.name}</td>
                  <td>
                    <center>
                      <!-- Mostramos un link para el archivo del CV que subio el usuario. El nombre del archivo lo tenemos
                      guadado en el campo archivo de la tabla solicitud y estan almacenados en la carpeta uploads en nuestro
                      directorio raiz de nuestra aplicacion.
                      -->
                      <a href="uploads/${application.file}" target="_blank">
                        <img src="images/download.png" title="Download Curriculum Vitae">
                      </a>
                      &nbsp;&nbsp;&nbsp;
                       <!-- Mostramos un link para que el administrador le pueda enviar un correo electronico al usuario que
                       envio su CV. Mandamos el parametro email del usuario, al formulario donde se redactara el email.
                      -->
                      <a href="application?action=respond&email=${application.email}">
                        <img src="images/mail.png" title="Send e-mail.">
                      </a>
                    </center>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2018 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
