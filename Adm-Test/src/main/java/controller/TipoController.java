package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoDAO;
import model.Tipo;

@WebServlet("/tipos")
public class TipoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("tipoform.jsp").forward(request, response);
		} else {
			TipoDAO dao = new TipoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("tipolist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Tipo tipo = new Tipo(nome, descricao);
		TipoDAO dao = new TipoDAO();
		dao.inserir(tipo);

		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("tipolist.jsp").forward(request, response);

	}
}
