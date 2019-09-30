package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Franquias;
import model.Produtos;
import model.Reserva;
import model.Tipo;
import util.Conexao;

public class ReservaDAO {

	private Conexao conexao;

	public ReservaDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Reserva> listar() {
		Statement stmt;
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select RESERVAS_ID,RESERVAS_QTD_PESSOAS,RESERVAS_DESCRICAO,"
					+ " RESERVAS_DATA, RESERVAS_HORA_INICIO, RESERVAS_HORA_FIM, PRODUTOS_ID, PRODUTOS_IDENTIFICACAO,"
					+ "PRODUTOS_ANDAR,TIPO_ID,FRANQUIA_ID,CLIENTES_ID,CLIENTES_NOME,CLIENTES_CPF,CLIENTES_TELEFONE,"
					+ "CLIENTES_ENDERECO,CLIENTES_DESCRICAO " + "from reservas r "
					+ "inner join PRODUTOS m on r.PRODUTOS_id = m.PRODUTOS_id "
					+ "inner join clientes c on r.cliente_id = c.clientes_id;");
			while (rs.next()) {
				Reserva r = new Reserva();

				Produtos produto = new Produtos();
				produto.setId(rs.getInt("PRODUTOS_ID"));
				produto.setIdentificacao(rs.getString("PRODUTOS_IDENTIFICACAO"));
				//modificar
				Franquias franquia = new Franquias();
				franquia.setId(rs.getInt("FRANQUIA_ID"));
				produto.setFranquia(franquia);
				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("TIPO_ID"));
				produto.setTipo(tipo);

				r.setMesa(produto);

				Cliente c = new Cliente();
				c.setId(rs.getInt("CLIENTES_ID"));
				c.setNome(rs.getString("CLIENTES_NOME"));
				c.setCpf(rs.getString("CLIENTES_CPF"));
				c.setTelefone(rs.getString("CLIENTES_TELEFONE"));
				c.setEndereco(rs.getString("CLIENTES_ENDERECO"));
				c.setDescricao(rs.getString("CLIENTES_DESCRICAO"));

				r.setClientes(c);

				r.setId(rs.getInt("RESERVAS_ID"));
				r.setPessoas(rs.getString("RESERVAS_QTD_PESSOAS"));
				r.setDescricao(rs.getString("RESERVAS_DESCRICAO"));
				r.setData(rs.getDate("RESERVAS_DATA").toLocalDate());
				r.setHora_inicio(rs.getTime("RESERVAS_HORA_INICIO").toLocalTime());
				r.setHora_fim(rs.getTime("RESERVAS_HORA_FIM").toLocalTime());
				reservas.add(r);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}

	public Integer totalReservas() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(RESERVAS_ID) from RESERVAS");
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

	public void inserir(Reserva reserva) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement(
					"insert into reservas (RESERVAS_QTD_PESSOAS, RESERVAS_DESCRICAO, RESERVAS_DATA, RESERVAS_HORA_INICIO, RESERVAS_HORA_FIM, PRODUTOS_ID,CLIENTE_ID) values (?,?,?,?,?,?,?);");
			ps.setString(1, reserva.getPessoas());
			ps.setString(2, reserva.getDescricao());
			ps.setDate(3, java.sql.Date.valueOf(reserva.getData()));
			ps.setTime(4, java.sql.Time.valueOf(reserva.getHora_inicio()));
			ps.setTime(5, java.sql.Time.valueOf(reserva.getHora_fim()));
			ps.setInt(6, reserva.getMesa().getId());
			ps.setInt(7, reserva.getClientes().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
