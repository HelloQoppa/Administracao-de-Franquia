package controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranqueadoDAO;
import dao.FranquiaDAO;
import model.Franqueado;
import model.Franquias;

@WebServlet("/franquias")
public class FranquiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			FranqueadoDAO franqueadoDAO = new FranqueadoDAO();
			request.setAttribute("franqueadolista", franqueadoDAO.listar());
			request.getRequestDispatcher("franquiaform.jsp").forward(request, response);
			return;
		}

		FranquiaDAO dao = new FranquiaDAO();

		if (q != null && q.equals("editar")) {
			String id = request.getParameter("id");
			Franquias franquias = dao.getByID(Integer.parseInt(id));
			request.setAttribute("franqueadolista", dao.listar());
			request.setAttribute("franquias", franquias);
			request.getRequestDispatcher("franquiaform.jsp").forward(request, response);
			return;
		}

		if (q != null && q.equals("excluir")) {
			String id = request.getParameter("id");
			dao.delete(Integer.parseInt(id));
		}
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("franquialist.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome, franqueadoID, local, hora_fun;

		String franquia_id = request.getParameter("id");
		nome = request.getParameter("nome");
		franqueadoID = request.getParameter("franqueado");
		local = request.getParameter("local");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		hora_fun = request.getParameter("hora_fun");

		FranqueadoDAO franqueadoDAO = new FranqueadoDAO();
		int id = Integer.parseInt(franqueadoID);
		Franqueado franqueado = franqueadoDAO.getByID(id);

		Franquias f = new Franquias(nome, franqueado, local, LocalTime.parse(hora_fun, timeFormat));
		FranquiaDAO franquiaDAO = new FranquiaDAO();

		if (franquia_id != null && !franquia_id.isEmpty()) {
			f.setId(Integer.parseInt(franquia_id));
			franquiaDAO.update(f);
		} else {
			franquiaDAO.inserir(f);
		}

		request.setAttribute("franquialista", franquiaDAO.listar());

		request.setAttribute("lista", franquiaDAO.listar());
		request.getRequestDispatcher("franquialist.jsp").forward(request, response);

	}

}
