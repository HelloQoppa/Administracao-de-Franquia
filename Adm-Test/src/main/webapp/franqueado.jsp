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
            <h3 class="page-header"><i class="fa fa-files-o"></i>franqueado</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
              <li><i class="icon_document_alt"></i>franqueado</li>
              <li><i class="icon_document_alt"></i>Novo</li>
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
                  <form class="franquia" method="post" action="franqueado">
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Primeiro Nome<span class="required">*</span></label>
                      <div class="col-lg-10">
                      <input class="form-control" name="id"  type="hidden" value="${franqueado.id}" />
                        <input class="form-control" name="nome" id="nome" value="${franqueado.nome}" type="text" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Sobrenome<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="sobrenome" value="${franqueado.sobrenome}" type="text" name="cpf" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Data de Nascimento<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="datanascimento" value="${franqueado.datanascimento}" type="text" name="cpf" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">CPF<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="cpf" value="${franqueado.cpf}" type="text" name="cpf" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">E-mail<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="email" type="text" value="${franqueado.email}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Celular (com DDD)<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="celular" type="text" value="${franqueado.celular}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Fone Residencial<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="residencial" type="text" value="${franqueado.foneresidencial}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Fone Comercial<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="comercial" type="text" value="${franqueado.fonecomecial}" name="email" />
                      </div>
                    </div>                                     
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Endere�o Completo<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="endereco" type="text" value="${franqueado.endereco}" name="endereco" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Bairro<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="bairro" type="text" value="${franqueado.bairro}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">CEP<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="cep" type="text" value="${franqueado.cep}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Cidade<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="cidade" type="text" value="${franqueado.cidade}" name="email" />
                      </div>
                    </div>
                    <div class="form-group ">
                      <label for="cname" class="control-label col-lg-2">Estado<span class="required">*</span></label>
                      <div class="col-lg-10">
                        <input class="form-control" id="estado" type="text" value="${franqueado.estado}" name="email" />
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" id="enviarBtn" type="submit">Inserir</button>
                        <button class="btn btn-default" type="button">Cancel</button>
                         <h3>${franqueadoExistente}</h3>
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
