package model;

import java.util.Random;

import dao.UsuarioDAO;

public class Franqueado {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String datanascimento;
	private String cpf;
	private String email;
	private String celular;
	private String foneresidencia;
	private String fonecomecial;
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	public Franqueado() {

	}

	public Franqueado(Integer id, String nome, String sobrenome, String datanascimento, String cpf, String email,
			String celular, String foneresidencia, String fonecomecial, String endereco, String bairro, String cep,
			String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
		this.foneresidencia = foneresidencia;
		this.fonecomecial = fonecomecial;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;

		/*
		 * String senha = gerarSenha(); System.out.println(gerarId()); Usuario usuario =
		 * new Usuario(email,senha,2,gerarId()); UsuarioDAO usuarioDAO = new
		 * UsuarioDAO(); usuarioDAO.inserir(usuario);
		 * 
		 * try { SendEmail sendEmail = new SendEmail();
		 * sendEmail.sendLoginSenha(nome,email,senha); } catch (Exception e) { // TODO:
		 * handle exception }
		 */
	}

	private Integer gerarId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Integer id = usuarioDAO.totalUsuarios();
		for (int i = usuarioDAO.totalUsuarios(); i <= usuarioDAO.totalUsuarios(); i++) {
			id++;
		}
		return id;
	}

	private String gerarSenha() {
		Random random = new Random();

		String preFixo = "Restaurant";
		String senha = preFixo + random.nextInt(99999);
		return senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoneresidencia() {
		return foneresidencia;
	}

	public void setFoneresidencia(String foneresidencia) {
		this.foneresidencia = foneresidencia;
	}

	public String getFonecomecial() {
		return fonecomecial;
	}

	public void setFonecomecial(String fonecomecial) {
		this.fonecomecial = fonecomecial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
