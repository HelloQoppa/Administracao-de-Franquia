package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("usuarioform.jsp").forward(request, response);
		} else {
			UsuarioDAO dao = new UsuarioDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("usuariolist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileUpload = request.getParameter("usuarios");
		String user = (String) request.getSession().getAttribute("user");

		System.out.println(fileUpload);
		Usuario usuario = new Usuario();
		usuario.setFoto(fileUpload.getBytes());
		usuario.setLogin(user);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alteraraFotoPerfil(usuario);

		request.setAttribute("foto", "E-mail Já cadastrado!");

	}

}
