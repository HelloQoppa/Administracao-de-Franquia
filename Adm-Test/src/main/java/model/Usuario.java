package model;

import java.util.Random;
import dao.FranqueadoDAO;

public class Usuario {

	private Integer id;
	private String login;
	private String senha;
	private byte[] foto;
	private Integer funcao;
	private Integer franqueado_id;

	public Usuario(String nome, String sobrenome, String datanascimento, String cpf, String email, String celular,
			String foneresidencia, String fonecomecial, String endereco, String bairro, String cep, String cidade,
			String estado) {

		Franqueado franqueado = new Franqueado(null, nome, sobrenome, datanascimento, cpf, email, celular,
				foneresidencia, fonecomecial, endereco, bairro, cep, cidade, estado);
		FranqueadoDAO franqueadoDAO = new FranqueadoDAO();
		franqueadoDAO.inserir(franqueado);

		this.login = email;
		this.senha = gerarSenha();
		this.funcao = 1;
		this.franqueado_id = franqueado.getId();

		try {
			// SendEmail sendEmail = new SendEmail();
			// sendEmail.sendLoginSenha(nome,email,senha);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	 * public Usuario(String login, String senha, Integer funcao,Integer
	 * franqueado_id) { super(); this.login = login; this.senha = senha; this.funcao
	 * = funcao; this.franqueado_id = franqueado_id; }
	 */

	private String gerarSenha() {
		Random random = new Random();

		String preFixo = "Restaurant";
		String senha = preFixo + random.nextInt(99999);
		return senha;
	}

	public Integer getFranqueado_id() {
		return franqueado_id;
	}

	public void setFranqueado(Integer franqueado_id) {
		this.franqueado_id = franqueado_id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] bs) {
		this.foto = bs;
	}

	public Usuario() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getFuncao() {
		return funcao;
	}

	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

}
