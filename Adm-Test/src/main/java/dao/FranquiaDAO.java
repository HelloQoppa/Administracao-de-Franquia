package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Franqueado;
import model.Franquias;
import util.Conexao;

public class FranquiaDAO {

	private static Conexao conexao;

	public FranquiaDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Franquias> listar() {
		Statement stmt;
		List<Franquias> franquia = new ArrayList<Franquias>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT FRANQUIAS_ID,FRANQUIAS_NOME,FRANQUEADO_ID,FRANQUEADOS_NOME,LOCAL,FRANQUIAS_HORA_FUN FROM FRANQUIAS INNER JOIN FRANQUEADOS ON FRANQUEADOS_ID = FRANQUEADO_ID;");
			while (rs.next()) {
				Franquias f = new Franquias();
				f.setId(rs.getInt("FRANQUIAS_ID"));
				f.setNome(rs.getString("FRANQUIAS_NOME"));
				Franqueado franqueado = new Franqueado();
				franqueado.setId(rs.getInt("FRANQUEADO_ID"));
				franqueado.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setFranqueado(franqueado);
				f.setLocal(rs.getString("LOCAL"));
				f.setHora_fun(rs.getTime("FRANQUIAS_HORA_FUN").toLocalTime());
				franquia.add(f);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return franquia;
	}

	public static void inserir(Franquias franquia) {

		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into franquias (FRANQUIAS_NOME,FRANQUEADO_ID,LOCAL,FRANQUIAS_HORA_FUN) values (?,?,?,?);");
			ps.setString(1, franquia.getNome());
			ps.setInt(2, franquia.getFranqueado().getId());
			ps.setString(3, franquia.getLocal());
			ps.setTime(4, java.sql.Time.valueOf(franquia.getHora_fun()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		PreparedStatement ps;
		try {
			ps = conexao.getConnection().prepareStatement("delete from franquias where franquias_id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Franquias franquias) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"update franquias set franquias_nome=?,franqueado_id = ?, local = ?,franquias_hora_fun = ? where franquias_id =?;");
			ps.setString(1, franquias.getNome());
			ps.setInt(2, franquias.getFranqueado().getId());
			ps.setString(3, franquias.getLocal());
			ps.setTime(4, java.sql.Time.valueOf(franquias.getHora_fun()));
			ps.setInt(5, franquias.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Integer totalFranquias() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(FRANQUIAS_ID) from FRANQUIAS");
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

	public Franquias getByID(int id) {
		Franquias f = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"select FRANQUIAS_ID,FRANQUIAS_NOME,FRANQUEADO_ID,FRANQUEADOS_NOME,LOCAL,FRANQUIAS_HORA_FUN from FRANQUIAS ,FRANQUEADOS where FRANQUIAS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = new Franquias();
				f.setId(rs.getInt("FRANQUIAS_ID"));
				f.setNome(rs.getString("FRANQUIAS_NOME"));
				Franqueado franqueado = new Franqueado();
				franqueado.setId(rs.getInt("FRANQUEADO_ID"));
				franqueado.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setFranqueado(franqueado);
				f.setLocal(rs.getString("LOCAL"));
				f.setHora_fun(rs.getTime("FRANQUIAS_HORA_FUN").toLocalTime());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public void close() {
		conexao.closeConnection();
	}

}
