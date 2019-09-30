<!DOCTYPE html>
<html lang="PT-BR">

<head>
  <meta charset="utf-8">

  <title>Projeto </title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />


<body class="login-img3-body">

  <div class="container">

    <form class="login-form" method="POST" action="login">
      <div class="login-wrap">
        <p class="login-img"><i class="icon_lock_alt"></i></p>
        <p class="login">Bem-Vindo!</p>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="text" name="nome" id="nome" class="form-control" placeholder="LOGIN" required autofocus>
        </div>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" name="senha" id="senha" class="form-control" placeholder="SENHA" required>
        </div>
        	<p>${msglogin}</p>
     <!--    <label class="checkbox">
               <input type="checkbox" value="remember-me"> Lembre de mim 
               <span class="pull-right"> <a href="#"> Esqueceu a senha?</a></span> 
            </label>-->
        <button class="btn btn-primary btn-lg btn-block" id="enviarBTN" type="submit">Entrar</button>
       <!-- <button class="btn btn-info btn-lg btn-block" type="submit">Inscrever-se</button>-->
      </div>
    </form>
  </div>


</body>

</html>
