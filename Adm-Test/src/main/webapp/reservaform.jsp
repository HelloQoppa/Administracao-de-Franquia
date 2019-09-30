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
            <h3 class="page-header"><i class="fa fa-files-o"></i> Reservas</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
              <li><i class="icon_document_alt"></i>Reservas</li>
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
                  <form class="franquia" method="post" action="reservas">
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Pessoas (Quantidade) <span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control"name="pessoas" required type="number" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Descrição<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control"  type="text" name="descricao" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Data (dd/MM/yyyy)<span class="required">*</span></label>
                      <div class="col-lg-10">
                         <input class="form-control" required type="date" name="data" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Inicio (HH:mm)<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" required type="time" name="hora_inicio" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Fim (HH:mm)<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" required type="time" name="hora_fim" />
                      </div>
                    </div>
                     <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Mesa<span class="required">*</span></label>
                      <div class="col-lg-10">
                         <select class="form-control" required name="mesa" >
							<option value="" selected>Selecione</option>
							<c:forEach var="mesa" items="${lista}">
							<option value="${mesa.id}">${mesa.identificacao}</option>
							</c:forEach>
						</select>
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Cliente<span class="required">*</span></label>
                      <div class="col-lg-10">
                         <select class="form-control" name="cliente" >
							<option value="" selected>Selecione</option>
							<c:forEach var="cliente" items="${listacliente}">
							<option value="${cliente.id}">${cliente.nome}</option>
							</c:forEach>
						</select>
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
