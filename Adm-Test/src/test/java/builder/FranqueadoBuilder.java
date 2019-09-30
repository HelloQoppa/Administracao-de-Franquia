package builder;

import model.Franqueado;

public class FranqueadoBuilder {

	private static final Integer FRANQUEADO_DEFAULT = 3;
	private static final String NOME_DEFAULT = "Luiz";
	private static final String SOBRENOME_DEFAULT = "Borges";
	private static final String NASCIMENTO_DEFAULT = "22/04/1997";
	private static final String CPF_DEFAULT = "45615774186";
	private static final String EMAIL_DEFAULT = "luiz.junior@ucsal.edu.br";
	private static final String CELULAR_DEFAULT = "995688442";
	private static final String RESIDENCIA_DEFAULT = "335488556";
	private static final String COMERCIAL_DEFAULT = "32548648";
	private static final String ENDERECO_DEFAULT = "Pituaçu";
	private static final String BAIRRO_DEFAULT = "Paralela";
	private static final String CEP_DEFAULT = "45236575";
	private static final String CIDADE_DEFAULT = "Salvador";
	private static final String ESTADO_DEFAULT = "Bahia";

	private Integer id = FRANQUEADO_DEFAULT;
	private String nome = NOME_DEFAULT;
	private String sobrenome = SOBRENOME_DEFAULT;
	private String datanascimento = NASCIMENTO_DEFAULT;
	private String cpf = CPF_DEFAULT;
	private String email = EMAIL_DEFAULT;
	private String celular = CELULAR_DEFAULT;
	private String residencia = RESIDENCIA_DEFAULT;
	private String comercial = COMERCIAL_DEFAULT;
	private String endereco = ENDERECO_DEFAULT;
	private String bairro = BAIRRO_DEFAULT;
	private String cep = CEP_DEFAULT;
	private String cidade = CIDADE_DEFAULT;
	private String estado = ESTADO_DEFAULT;

	private FranqueadoBuilder() {

	}

	public static FranqueadoBuilder franqueado() {
		return new FranqueadoBuilder();
	}

	public FranqueadoBuilder Id(Integer id) {
		this.id = id;
		return this;
	}

	public FranqueadoBuilder Nome(String nome) {
		this.nome = nome;
		return this;
	}

	public FranqueadoBuilder Sobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
		return this;
	}

	public FranqueadoBuilder DataNascimento(String datanascimento) {
		this.datanascimento = datanascimento;
		return this;
	}

	public FranqueadoBuilder Cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public FranqueadoBuilder Email(String email) {
		this.email = email;
		return this;
	}

	public FranqueadoBuilder Celular(String celular) {
		this.celular = celular;
		return this;
	}

	public FranqueadoBuilder Residencia(String residencia) {
		this.residencia = residencia;
		return this;
	}

	public FranqueadoBuilder Comercial(String comercial) {
		this.comercial = comercial;
		return this;
	}

	public FranqueadoBuilder Endereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public FranqueadoBuilder Bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public FranqueadoBuilder Cep(String cep) {
		this.cep = cep;
		return this;
	}

	public FranqueadoBuilder Cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public FranqueadoBuilder Estado(String estado) {
		this.estado = estado;
		return this;
	}

	public FranqueadoBuilder but() {
		return FranqueadoBuilder.franqueado().Nome(nome).Sobrenome(sobrenome).DataNascimento(datanascimento).Cpf(cpf)
				.Email(email).Celular(celular).Residencia(residencia).Comercial(comercial).Endereco(endereco)
				.Bairro(bairro).Cep(cep).Cidade(cidade).Estado(estado);
	}

	public Franqueado build() {
		Franqueado franqueado = new Franqueado();
		franqueado.setId(id);
		franqueado.setNome(nome);
		franqueado.setSobrenome(sobrenome);
		franqueado.setDatanascimento(datanascimento);
		franqueado.setCpf(cpf);
		franqueado.setEmail(email);
		franqueado.setCelular(celular);
		franqueado.setFoneresidencia(residencia);
		franqueado.setFonecomecial(comercial);
		franqueado.setEndereco(endereco);
		franqueado.setBairro(bairro);
		franqueado.setCep(cep);
		franqueado.setCidade(cidade);
		franqueado.setEstado(estado);
		return franqueado;

	}

}
