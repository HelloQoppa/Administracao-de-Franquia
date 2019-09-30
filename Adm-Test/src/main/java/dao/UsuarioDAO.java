package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.Conexao;

public class UsuarioDAO {

	private Conexao conexao;

	public UsuarioDAO() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Usuario usuario) {

		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into usuarios (USUARIOS_LOGIN,USUARIOS_SENHA,FRANQUEADO_ID,USUARIOS_FUNCAO) values (?,?,?,?);");
			// ps.setString(1, usuario.getNome());
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getFranqueado_id());
			ps.setInt(4, usuario.getFuncao());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> listar() {
		Statement stmt;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt
					.executeQuery("select USUARIOS_ID,USUARIOS_LOGIN,USUARIOS_FUNCAO,USUARIOS_FOTO from USUARIOS;");
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("USUARIOS_ID"));
				// u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("USUARIOS_LOGIN"));
				// u.setSenha(rs.getString("USUARIOS_SENHA"));
				u.setFuncao(rs.getInt("USUARIOS_FUNCAO"));
				u.setFoto(rs.getBytes("USUARIOS_FOTO"));
				usuarios.add(u);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;

	}

	public Integer totalUsuarios() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(USUARIOS_ID) from USUARIOS");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;

	}

	public Usuario validarLogin(String login, String senha) {
		PreparedStatement ps;
		Usuario usuario = null;
		try {
			ps = conexao.getConnection().prepareStatement(
					"select USUARIOS_ID,USUARIOS_LOGIN,USUARIOS_FUNCAO from usuarios where USUARIOS_LOGIN= ? and USUARIOS_SENHA =?");
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("USUARIOS_ID"));
				// usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("USUARIOS_LOGIN"));
				usuario.setFuncao(rs.getInt("USUARIOS_FUNCAO"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void alteraraFotoPerfil(Usuario usuario) {
		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("update USUARIOS set USUARIOS_FOTO=? where USUARIOS_LOGIN =?;");
			ps.setBytes(1, usuario.getFoto());
			ps.setString(2, usuario.getLogin());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario controleAcesso(String user) {

		PreparedStatement ps;
		Usuario usuario = null;
		try {
			ps = conexao.getConnection().prepareStatement(
					"select USUARIOS_ID,USUARIOS_LOGIN,FRANQUEADO_ID,USUARIOS_FUNCAO from usuarios where USUARIOS_LOGIN=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("USUARIOS_ID"));
				usuario.setLogin(rs.getString("USUARIOS_LOGIN"));
				usuario.setFranqueado(rs.getInt("FRANQUEADO_ID"));
				usuario.setFuncao(rs.getInt("USUARIOS_FUNCAO"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
