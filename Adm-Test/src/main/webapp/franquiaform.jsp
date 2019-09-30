<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="PT-BR">

<head>
  <meta charset="utf-8">
  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Projeto </title>

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
</head>

<body>
   <c:import url="topo.jsp"></c:import>

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-files-o"></i> Franquias</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
              <li><i class="icon_document_alt"></i>Franquias</li>
              <li><i class="icon_document_alt"></i>Inserir</li>
            </ol>
          </div>
        </div>
        <!-- Form validations -->
        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Inserir
              </header>
              <div class="panel-body">
                <div class="form">
                  <form class="franquia" method="post" action="franquias">
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Nome <span class="required">*</span></label>
                      <div class="col-lg-10">
                      <input class="form-control"name="id" type="hidden" value="${franquias.id}" />
                        <input class="form-control"name="nome" type="text" value="${franquias.nome }" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Franqueado <span class="required">*</span></label>
                      <div class="col-lg-10">
                        <select class="form-control" name="franqueado" >
							<option value="${franquias.franqueado.id }" selected>Selecione</option>
							<c:forEach var="franqueado" items="${franqueadolista}">
							<option value="${franqueado.id}">${franqueado.nome}</option>
							</c:forEach>
						</select>
                      </div>
                    </div>
                    
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Local<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control " type="text" value="${franquias.local}" name="local" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Funcionamento (Hora HH:mm)<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" type="time" value="${franquias.hora_fun }" name="hora_fun" />
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" type="submit">Inserir</button>
                        <button class="btn btn-default" type="button">Cancel</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
          </div>
        </div>
      </section>
    </section>
  </section>
  <!-- javascripts -->
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="js/jquery.scrollTo.min.js"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- jquery validate js -->
  <script type="text/javascript" src="js/jquery.validate.min.js"></script>

  <!-- custom form validation script for this page-->
  <script src="js/form-validation-script.js"></script>
  <!--custome script for all page-->
  <script src="js/scripts.js"></script>


</body>

</html>
