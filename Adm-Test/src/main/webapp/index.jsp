<%@page import="dao.ProdutosDAO"%>
<%@page import="dao.FranqueadoDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.FranquiaDAO"%>
<%@page import="dao.ReservaDAO"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="dao.UsuarioDAO"%>
<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Projeto </title>
<!-- FontAwesome -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<!-- Bootstrap CSS -->
<link href="/Teste_Qualidade/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="/Teste_Qualidade/css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="/Teste_Qualidade/css/elegant-icons-style.css" rel="stylesheet" />
<link href="/Teste_Qualidade/css/font-awesome.min.css" rel="stylesheet" />
<!-- full calendar css-->
<link
	href="/Teste_Qualidade/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link href="/Teste_Qualidade/assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link
	href="/Teste_Qualidade/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="/Teste_Qualidade/css/owl.carousel.css"
	type="text/css">
<link href="/Teste_Qualidade/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="/Projeto/css/fullcalendar.css">
<link href="/Teste_Qualidade/css/widgets.css" rel="stylesheet">
<link href="/Teste_Qualidade/css/style.css" rel="stylesheet">
<link href="/Teste_Qualidade/css/style-responsive.css" rel="stylesheet" />
<link href="/Teste_Qualidade/css/xcharts.min.css" rel=" stylesheet">
<link href="/Teste_Qualidade/css/jquery-ui-1.10.4.min.css" rel="stylesheet">


</head>

<body>
	<c:import url="topo.jsp"></c:import>

	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<!--overview start-->
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						<i class="fa fa-laptop"></i> Home
					</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.jsp">Home</a></li>
					</ol>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<i class="fa fa-address-card"></i>
						<%
							FranquiaDAO fr = new FranquiaDAO();
						%>
						<div class="count"><%=fr.totalFranquias()%></div>
						<div class="title">Franquias</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<i class="fa fa-address-card"></i>
						<%
							FranqueadoDAO fq = new FranqueadoDAO();
						%>
						<div class="count"><%=fq.totalFranqueados()%></div>
						<div class="title">Franqueados</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->
			</div>
			<!--/.row-->


			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<i class="fa fa-users"></i>
						<%
							ClienteDAO daoC = new ClienteDAO();
						%>
						<div class="count"><%=daoC.totalClentes()%></div>
						<div class="title">Clientes</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<i class="fa fa-suitcase"></i>
						<%
							UsuarioDAO daoU = new UsuarioDAO();
						%>
						<div class="count"><%=daoU.totalUsuarios()%></div>
						<div class="title">Usuarios</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<i class="fa fa-suitcase"></i>
						<%
							ProdutosDAO mesasDAO = new ProdutosDAO();
						%>
						<div class="count"><%=mesasDAO.totalProdutos()%></div>
						<div class="title">Mesas</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<i class="fa fa-cutlery"></i>
						<%
							ReservaDAO daoR = new ReservaDAO();
						%>
						<div class="count"><%=daoR.totalReservas()%></div>
						<div class="title">Reservas</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

			</div>
			<!--/.row-->
				</div>
		</section>
	</section>
	<!--main content end-->
	</section>
	<!-- container section start -->

	
	<!-- javascripts -->
	<script src="/Teste_Qualidade/js/jquery.js"></script>
	<script src="/Teste_Qualidade/js/jquery-ui-1.10.4.min.js"></script>
	<script src="/Teste_Qualidade/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
		src="/Teste_Qualidade/js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- bootstrap -->
	<script src="/Teste_Qualidade/js/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script src="/Teste_Qualidade/js/jquery.scrollTo.min.js"></script>
	<script src="/Teste_Qualidade/js/jquery.nicescroll.js" type="text/javascript"></script>
	<!-- charts scripts -->
	<script src="/Teste_Qualidade/assets/jquery-knob/js/jquery.knob.js"></script>
	<script src="/Teste_Qualidade/js/jquery.sparkline.js" type="text/javascript"></script>
	<script
		src="/Teste_Qualidade/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="/Teste_Qualidade/js/owl.carousel.js"></script>
	<!-- jQuery full calendar -->
	<
	<script src="/Teste_Qualidade/js/fullcalendar.min.js"></script>
	<!-- Full Google Calendar - Calendar -->
	<script src="/Teste_Qualidade/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
	<!--script for this page only-->
	<script src="/Teste_Qualidade/js/calendar-custom.js"></script>
	<script src="/Teste_Qualidade/js/jquery.rateit.min.js"></script>
	<!-- custom select -->
	<script src="/Teste_Qualidade/js/jquery.customSelect.min.js"></script>
	<script src="/Teste_Qualidade/assets/chart-master/Chart.js"></script>

	<!--custome script for all page-->
	<script src="/Teste_Qualidade/js/scripts.js"></script>
	<!-- custom script for this page-->
	<script src="/Teste_Qualidade/js/sparkline-chart.js"></script>
	<script src="/Teste_Qualidade/js/easy-pie-chart.js"></script>
	<script src="/Teste_Qualidade/js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="/Teste_Qualidade/js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="/Teste_Qualidade/js/xcharts.min.js"></script>
	<script src="/Teste_Qualidade/js/jquery.autosize.min.js"></script>
	<script src="/Teste_Qualidade/js/jquery.placeholder.min.js"></script>
	<script src="/Teste_Qualidade/js/gdp-data.js"></script>
	<script src="/Teste_Qualidade/js/morris.min.js"></script>
	<script src="/Teste_Qualidade/js/sparklines.js"></script>
	<script src="/Teste_Qualidade/js/charts.js"></script>
	<script src="/Teste_Qualidade/js/jquery.slimscroll.min.js"></script>
	<script>
		//knob
		$(function() {
			$(".knob").knob({
				'draw' : function() {
					$(this.i).val(this.cv + '%')
				}
			})
		});

		//carousel
		$(document).ready(function() {
			$("#owl-slider").owlCarousel({
				navigation : true,
				slideSpeed : 300,
				paginationSpeed : 400,
				singleItem : true

			});
		});

		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});

		/* ---------- Map ---------- */
		$(function() {
			$('#map').vectorMap({
				map : 'world_mill_en',
				series : {
					regions : [ {
						values : gdpData,
						scale : [ '#000', '#000' ],
						normalizeFunction : 'polynomial'
					} ]
				},
				backgroundColor : '#eef3f7',
				onLabelShow : function(e, el, code) {
					el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
				}
			});
		});
	</script>

</body>

</html>
