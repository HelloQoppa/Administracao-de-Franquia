package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Tipo;
import util.Conexao;

public class TipoDAO {

	private Conexao conexao;

	public TipoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Tipo> listar() {
		Statement stmt;
		List<Tipo> tipos = new ArrayList<Tipo>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select TIPOS_ID,TIPOS_NOME,TIPOS_DESCRICAO from TIPOS;");
			while (rs.next()) {
				Tipo t = new Tipo();
				t.setId(rs.getInt("TIPOS_ID"));
				t.setNome(rs.getString("TIPOS_NOME"));
				t.setDescricao(rs.getString("TIPOS_DESCRICAO"));
				tipos.add(t);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tipos;
	}

	public void inserir(Tipo tipo) {
		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into tipos (TIPOS_NOME,TIPOS_DESCRICAO) values (?,?);");
			ps.setString(1, tipo.getNome());
			ps.setString(2, tipo.getDescricao());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Tipo getByID(int id) {
		Tipo t = null;
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select TIPOS_ID,TIPOS_NOME,TIPOS_DESCRICAO from TIPOS where TIPOS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Tipo();
				t.setId(rs.getInt("TIPOS_ID"));
				t.setNome(rs.getString("TIPOS_NOME"));
				t.setDescricao(rs.getString("TIPOS_DESCRICAO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public void close() {
		conexao.closeConnection();
	}

}
