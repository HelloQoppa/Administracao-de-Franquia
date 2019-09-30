package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Franqueado;
import util.Conexao;

public class FranqueadoDAO {

	private static Conexao conexao;

	public FranqueadoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Franqueado franqueado) {

		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into franqueados (FRANQUEADOS_ID, FRANQUEADOS_NOME, FRANQUEADOS_SOBRENOME, FRANQUEADOS_DATANASCIMENTO,"
							+ " FRANQUEADOS_CPF, FRANQUEADOS_CELULAR, FRANQUEADOS_FONERESIDENCIA, FRANQUEADOS_FONECOMECIAL, FRANQUEADOS_ENDERECO,"
							+ " FRANQUEADOS_BAIRRO, FRANQUEADOS_CEP, FRANQUEADOS_CIDADE, FRANQUEADOS_ESTADO, FRANQUEADOS_EMAIL  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, franqueado.getId());
			ps.setString(2, franqueado.getNome());
			ps.setString(3, franqueado.getSobrenome());
			ps.setString(4, franqueado.getDatanascimento());
			ps.setString(5, franqueado.getCpf());
			ps.setString(6, franqueado.getCelular());
			ps.setString(7, franqueado.getFoneresidencia());
			ps.setString(8, franqueado.getFonecomecial());
			ps.setString(9, franqueado.getEndereco());
			ps.setString(10, franqueado.getBairro());
			ps.setString(11, franqueado.getCep());
			ps.setString(12, franqueado.getCidade());
			ps.setString(13, franqueado.getEstado());
			ps.setString(14, franqueado.getEmail());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		PreparedStatement ps;
		try {
			ps = conexao.getConnection().prepareStatement(
					"DELETE FRANQUEADOS FROM ETAPA_GRUPO_ENSINO ege INNER JOIN #Aux temp ON temp.ID_GRUPO_ENSINO = ege.ID_GRUPO_ENSINO");
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.execute();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Franqueado franqueado) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"update Franqueados set franqueados_nome = ?, franqueados_sobrenome = ?, franqueados_datanascimento = ?, franqueados_cpf = ?,"
							+ "franqueados_celular = ?, franqueados_foneresidencia = ?, franqueados_fonecomecial = ?, franqueados_endereco = ?, franqueados_bairro = ?, "
							+ "franqueados_cep = ?, franqueados_cidade = ?, franqueados_estado = ?, franqueados_email where franqueados_id =? ");
			ps.setString(1, franqueado.getNome());
			ps.setString(2, franqueado.getSobrenome());
			ps.setString(3, franqueado.getDatanascimento());
			ps.setString(4, franqueado.getCpf());
			ps.setString(5, franqueado.getCelular());
			ps.setString(6, franqueado.getFoneresidencia());
			ps.setString(7, franqueado.getFonecomecial());
			ps.setString(8, franqueado.getEndereco());
			ps.setString(9, franqueado.getBairro());
			ps.setString(10, franqueado.getCep());
			ps.setString(11, franqueado.getCidade());
			ps.setString(12, franqueado.getEstado());
			ps.setString(13, franqueado.getEmail());
			ps.setInt(14, franqueado.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Franqueado> listar() {
		Statement stmt;
		List<Franqueado> franqueado = new ArrayList<Franqueado>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select FRANQUEADOS_ID, FRANQUEADOS_NOME, FRANQUEADOS_SOBRENOME, FRANQUEADOS_DATANASCIMENTO, "
							+ "FRANQUEADOS_CPF, FRANQUEADOS_CELULAR, FRANQUEADOS_FONERESIDENCIA, FRANQUEADOS_FONECOMECIAL, FRANQUEADOS_ENDERECO,FRANQUEADOS_BAIRRO,"
							+ " FRANQUEADOS_CEP, FRANQUEADOS_CIDADE, FRANQUEADOS_ESTADO, FRANQUEADOS_EMAIL from FRANQUEADOS ORDER BY franqueados_id;;");
			while (rs.next()) {
				Franqueado f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setSobrenome(rs.getString("FRANQUEADOS_SOBRENOME"));
				f.setDatanascimento(rs.getString("FRANQUEADOS_DATANASCIMENTO"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setCelular(rs.getString("FRANQUEADOS_CELULAR"));
				f.setFoneresidencia(rs.getString("FRANQUEADOS_FONERESIDENCIA"));
				f.setFonecomecial(rs.getString("FRANQUEADOS_FONECOMECIAL"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setBairro(rs.getString("FRANQUEADOS_BAIRRO"));
				f.setCep(rs.getString("FRANQUEADOS_CEP"));
				f.setCidade(rs.getString("FRANQUEADOS_CIDADE"));
				f.setEstado(rs.getString("FRANQUEADOS_ESTADO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
				franqueado.add(f);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return franqueado;

	}

	public Integer totalFranqueados() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(FRANQUEADOS_ID) from FRANQUEADOS");
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

	public static Franqueado getByID(int id) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select FRANQUEADOS_ID, FRANQUEADOS_NOME, FRANQUEADOS_SOBRENOME, "
							+ "FRANQUEADOS_DATANASCIMENTO, FRANQUEADOS_CPF, FRANQUEADOS_CELULAR, FRANQUEADOS_FONERESIDENCIA, FRANQUEADOS_FONECOMECIAL, "
							+ "FRANQUEADOS_ENDERECO,FRANQUEADOS_BAIRRO,FRANQUEADOS_CEP, FRANQUEADOS_CIDADE, FRANQUEADOS_ESTADO, FRANQUEADOS_EMAIL from "
							+ "FRANQUEADOS where FRANQUEADOS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setSobrenome(rs.getString("FRANQUEADOS_SOBRENOME"));
				f.setDatanascimento(rs.getString("FRANQUEADOS_DATANASCIMENTO"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setCelular(rs.getString("FRANQUEADOS_CELULAR"));
				f.setFoneresidencia(rs.getString("FRANQUEADOS_FONERESIDENCIA"));
				f.setFonecomecial(rs.getString("FRANQUEADOS_FONECOMECIAL"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setBairro(rs.getString("FRANQUEADOS_BAIRRO"));
				f.setCep(rs.getString("FRANQUEADOS_CEP"));
				f.setCidade(rs.getString("FRANQUEADOS_CIDADE"));
				f.setEstado(rs.getString("FRANQUEADOS_ESTADO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public Franqueado getByEmail(String email) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select FRANQUEADOS_ID, FRANQUEADOS_NOME, FRANQUEADOS_SOBRENOME,"
							+ " FRANQUEADOS_DATANASCIMENTO, FRANQUEADOS_CPF, FRANQUEADOS_CELULAR, FRANQUEADOS_FONERESIDENCIA, FRANQUEADOS_FONECOMECIAL,"
							+ "FRANQUEADOS_ENDERECO,FRANQUEADOS_BAIRRO,FRANQUEADOS_CEP, FRANQUEADOS_CIDADE, FRANQUEADOS_ESTADO, FRANQUEADOS_EMAIL from "
							+ "FRANQUEADOS where FRANQUEADOS_EMAIL=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setSobrenome(rs.getString("FRANQUEADOS_SOBRENOME"));
				f.setDatanascimento(rs.getString("FRANQUEADOS_DATANASCIMENTO"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setCelular(rs.getString("FRANQUEADOS_CELULAR"));
				f.setFoneresidencia(rs.getString("FRANQUEADOS_FONERESIDENCIA"));
				f.setFonecomecial(rs.getString("FRANQUEADOS_FONECOMECIAL"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setBairro(rs.getString("FRANQUEADOS_BAIRRO"));
				f.setCep(rs.getString("FRANQUEADOS_CEP"));
				f.setCidade(rs.getString("FRANQUEADOS_CIDADE"));
				f.setEstado(rs.getString("FRANQUEADOS_ESTADO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public Franqueado getByCpf(String cpf) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select FRANQUEADOS_ID, FRANQUEADOS_NOME, FRANQUEADOS_SOBRENOME, "
							+ "FRANQUEADOS_DATANASCIMENTO, FRANQUEADOS_CPF, FRANQUEADOS_CELULAR, FRANQUEADOS_FONERESIDENCIA, FRANQUEADOS_FONECOMECIAL,"
							+ "FRANQUEADOS_ENDERECO,FRANQUEADOS_BAIRRO,FRANQUEADOS_CEP, FRANQUEADOS_CIDADE, FRANQUEADOS_ESTADO, FRANQUEADOS_EMAIL from "
							+ "FRANQUEADOS where FRANQUEADOS_CPF=?");
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setSobrenome(rs.getString("FRANQUEADOS_SOBRENOME"));
				f.setDatanascimento(rs.getString("FRANQUEADOS_DATANASCIMENTO"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setCelular(rs.getString("FRANQUEADOS_CELULAR"));
				f.setFoneresidencia(rs.getString("FRANQUEADOS_FONERESIDENCIA"));
				f.setFonecomecial(rs.getString("FRANQUEADOS_FONECOMECIAL"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setBairro(rs.getString("FRANQUEADOS_BAIRRO"));
				f.setCep(rs.getString("FRANQUEADOS_CEP"));
				f.setCidade(rs.getString("FRANQUEADOS_CIDADE"));
				f.setEstado(rs.getString("FRANQUEADOS_ESTADO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}
