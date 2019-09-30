package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.Conexao;

public class ClienteDAO {

	private static Conexao conexao;

	public ClienteDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Cliente> listar() {
		Statement stmt;
		List<Cliente> cliente = new ArrayList<Cliente>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select CLIENTES_ID,CLIENTES_NOME,CLIENTES_CPF,CLIENTES_TELEFONE,CLIENTES_ENDERECO,CLIENTES_DESCRICAO from clientes;");
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("CLIENTES_ID"));
				c.setNome(rs.getString("CLIENTES_NOME"));
				c.setCpf(rs.getString("CLIENTES_CPF"));
				c.setTelefone(rs.getString("CLIENTES_TELEFONE"));
				c.setEndereco(rs.getString("CLIENTES_ENDERECO"));
				c.setDescricao(rs.getString("CLIENTES_DESCRICAO"));
				cliente.add(c);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public Integer totalClentes() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(CLIENTES_ID) from clientes");
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

	public void inserir(Cliente clientes) {

		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into clientes (CLIENTES_NOME,CLIENTES_CPF,CLIENTES_TELEFONE,CLIENTES_ENDERECO,CLIENTES_DESCRICAO) values (?,?,?,?,?);");
			ps.setString(1, clientes.getNome());
			ps.setString(2, clientes.getCpf());
			ps.setString(3, clientes.getTelefone());
			ps.setString(4, clientes.getEndereco());
			ps.setString(5, clientes.getDescricao());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Cliente getByID(int id) {
		Cliente c = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"select CLIENTES_ID,CLIENTES_NOME,CLIENTES_CPF,CLIENTES_TELEFONE,CLIENTES_ENDERECO,CLIENTES_DESCRICAO from clientes where CLIENTES_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Cliente();
				c.setId(rs.getInt("CLIENTES_ID"));
				c.setNome(rs.getString("CLIENTES_NOME"));
				c.setCpf(rs.getString("CLIENTES_CPF"));
				c.setTelefone(rs.getString("CLIENTES_TELEFONE"));
				c.setEndereco(rs.getString("CLIENTES_ENDERECO"));
				c.setDescricao(rs.getString("CLIENTES_DESCRICAO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void close() {
		conexao.closeConnection();
	}
}
