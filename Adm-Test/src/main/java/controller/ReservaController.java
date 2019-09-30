package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.ProdutosDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.Produtos;
import model.Reserva;

@WebServlet("/reservas")
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			ProdutosDAO dao = new ProdutosDAO();
			request.setAttribute("lista", dao.listar());
			ClienteDAO clientedao = new ClienteDAO();
			request.setAttribute("listacliente", clientedao.listar());
			request.getRequestDispatcher("reservaform.jsp").forward(request, response);
		} else {
			ReservaDAO dao = new ReservaDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("pessoas");
		String des = request.getParameter("descricao");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String data = request.getParameter("data");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		String ini = request.getParameter("hora_inicio");
		String fim = request.getParameter("hora_fim");
		String mesaID = request.getParameter("mesa");
		String clienteID = request.getParameter("cliente");

		ProdutosDAO mesaDAO = new ProdutosDAO();
		int id = Integer.parseInt(mesaID);
		Produtos mesa = mesaDAO.getByID(id);

		ClienteDAO clienteDAO = new ClienteDAO();
		int ida = Integer.parseInt(clienteID);
		Cliente cliente = clienteDAO.getByID(ida);

		Reserva reserva = new Reserva(mesa, cliente, titulo, des, LocalDate.parse(data, dateFormat),
				LocalTime.parse(ini, timeFormat), LocalTime.parse(fim, timeFormat));
		ReservaDAO dao = new ReservaDAO();
		dao.inserir(reserva);

		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("reservalist.jsp").forward(request, response);
	}

}
