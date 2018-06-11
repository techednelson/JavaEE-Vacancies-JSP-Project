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
    <title>List with all the vacancies</title>
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

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Vacancies List</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">ID</th>
                <th>Vacancy</th>
                <th>Publication</th>
                <th></th>
              </tr>
            </thead>
            <tbody>

                <c:forEach items="${vacancies}" var="vacancy">
                <tr>
                  <td class="left">${vacancy.id}</td>
                  <td>${vacancy.vacancyName}</td>
                  <td>${vacancy.publishDate}</td>
                  <td>
                    <a class="btn btn-default" href="vacancy?action=see&id=${vacancy.id}" role="button">View details</a>
                    <c:if test="${person.id >= 0}">
                        <a class="btn btn-default" href="admin?action=delete&idVacancy=${vacancy.id}" role="button">Delete</a>
                    </c:if>
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
