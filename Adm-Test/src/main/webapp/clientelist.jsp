<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Projeto</title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />
   <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<c:import url="topo.jsp"></c:import>

 <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-table"></i>Clientes</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
              <li><i class="fa fa-table"></i>Clientes</li>
              <li><i class="fa fa-th-list"></i>Listar</li>
            </ol>
          </div>
        </div>
        
         <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
               Listar Clientes
              </header>
              <div class="table-responsive">
                <table class="table">
                  <thead>
                    <tr>
                      <th>Nome</th>
                      <th>CPF</th>
                      <th>Telefone</th>
                      <th>Endere�o</th>
                      <th>Descrição</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="e" items="${lista}">
                    <tr>
                      <td>${e.nome}</td>
                      <td>${e.cpf}</td>
                      <td>${e.telefone}</td>
                      <td>${e.endereco}</td>
                      <td>${e.descricao}</td>
                      <td><a href="clientes?q=editar&id=${e.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                      <td><a href="clientes?q=excluir&id=${e.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>

            </section>
          </div>
        </div>
        
        </section>
    </section>
 
  </section>
  <!-- container section end -->
  <!-- javascripts -->
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <!-- nicescroll -->
  <script src="js/jquery.scrollTo.min.js"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
  <!--custome script for all page-->
  <script src="js/scripts.js"></script>

</body>
</html>