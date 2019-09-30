package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("q");

		if (login != null && login.equals("logout")) {
			request.getSession().invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user, senha;

		user = request.getParameter("nome");
		senha = request.getParameter("senha");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.validarLogin(user, senha) == null) {
			request.setAttribute("msglogin", "Usuário ou senha inválidos!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
