package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/clientes")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("clienteform.jsp").forward(request, response);
		} else {
			ClienteDAO dao = new ClienteDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("clientelist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome, cpf, telefone, endereco, descricao;

		nome = request.getParameter("nome");
		cpf = request.getParameter("cpf");
		telefone = request.getParameter("telefone");
		endereco = request.getParameter("endereco");
		descricao = request.getParameter("descricao");

		Cliente c = new Cliente(null, nome, cpf, telefone, endereco, descricao);
		ClienteDAO dao = new ClienteDAO();
		dao.inserir(c);

		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("clientelist.jsp").forward(request, response);
	}

}
