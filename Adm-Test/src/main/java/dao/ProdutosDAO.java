package dao;

import util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Franqueado;
import model.Franquias;
import model.Produtos;
import model.Tipo;

public class ProdutosDAO {

	private Conexao conexao;

	public ProdutosDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Produtos> listar() {
		List<Produtos> produtos = new ArrayList<Produtos>();
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"select PRODUTOS_ID, PRODUTOS_IDENTIFICACAO, FRANQUIA_ID, FRANQUIAS_NOME, TIPO_ID, TIPOS_NOME from PRODUTOS INNER JOIN TIPOS ON TIPOS_ID = TIPO_ID INNER JOIN FRANQUIAS ON FRANQUIAS_ID = FRANQUIA_ID;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produtos me = new Produtos();
				me.setId(rs.getInt("PRODUTOS_ID"));
				me.setIdentificacao(rs.getString("PRODUTOS_IDENTIFICACAO"));

				Franquias franquia = new Franquias();
				franquia.setId(rs.getInt("FRANQUIA_ID"));
				franquia.setNome(rs.getString("FRANQUIAS_NOME"));
				me.setFranquia(franquia);

				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("TIPO_ID"));
				tipo.setNome(rs.getString("TIPOS_NOME"));
				me.setTipo(tipo);
				produtos.add(me);
				;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public void inserir(Produtos produtos) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into PRODUTOS (PRODUTOS_IDENTIFICACAO,TIPO_ID,FRANQUIA_ID) values (?,?,?);");
			ps.setString(1, produtos.getIdentificacao());
			ps.setInt(2, produtos.getTipo().getId());
			ps.setInt(3, produtos.getFranquia().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Integer totalProdutos() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(PRODUTOS_ID) from PRODUTOS");
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

	public Produtos getByID(int id) {
		Produtos me = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"select PRODUTOS_ID,PRODUTOS_IDENTIFICACAO,FRANQUIA_ID,TIPO_ID from PRODUTOS where PRODUTOS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				me = new Produtos();
				me.setId(rs.getInt("PRODUTOS_ID"));
				me.setIdentificacao(rs.getString("PRODUTOS_IDENTIFICACAO"));

				Franquias franquia = new Franquias();
				franquia.setId(rs.getInt("FRANQUIA_ID"));
				me.setFranquia(franquia);

				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("TIPO_ID"));
				me.setTipo(tipo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return me;
	}

	public void close() {
		conexao.closeConnection();
	}
}
