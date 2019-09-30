package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranquiaDAO;
import dao.ProdutosDAO;
import dao.TipoDAO;
import model.Franquias;
import model.Produtos;
import model.Tipo;

@WebServlet("/produtos")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			FranquiaDAO dao = new FranquiaDAO();
			request.setAttribute("lista", dao.listar());
			TipoDAO tipoDao = new TipoDAO();
			request.setAttribute("listaTipo", tipoDao.listar());
			request.getRequestDispatcher("produtoform.jsp").forward(request, response);
		} else {
			ProdutosDAO dao = new ProdutosDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("produtolist.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identificacao = request.getParameter("identificacao");
		String franquiaID = request.getParameter("franquia");
		String tipoID = request.getParameter("tipo");

		Produtos produto = new Produtos();
		produto.setIdentificacao(identificacao);
		FranquiaDAO franquiaDAO = new FranquiaDAO();
		int ida = Integer.parseInt(franquiaID);
		Franquias f = franquiaDAO.getByID(ida);
		produto.setFranquia(f);

		int id_tipo = Integer.parseInt(tipoID);
		TipoDAO tipoDAO = new TipoDAO();
		Tipo tipo = tipoDAO.getByID(id_tipo);
		produto.setTipo(tipo);
		ProdutosDAO dao = new ProdutosDAO();
		dao.inserir(produto);
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("produtolist.jsp").forward(request, response);
		;
	}

}
