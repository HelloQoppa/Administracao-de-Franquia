package model;

import java.time.LocalTime;

public class Franquias {

	private Integer id;
	private String nome;
	private Franqueado franqueado;
	private String local;
	private LocalTime hora_fun;

	public Franquias() {

	}

	public Franquias(String nome, Franqueado franqueado, String local, LocalTime hora_fun) {
		super();

		this.nome = nome;
		this.franqueado = franqueado;
		this.local = local;
		this.hora_fun = hora_fun;
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

	public Franqueado getFranqueado() {
		return franqueado;
	}

	public void setFranqueado(Franqueado franqueado) {
		this.franqueado = franqueado;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalTime getHora_fun() {
		return hora_fun;
	}

	public void setHora_fun(LocalTime hora_fun) {
		this.hora_fun = hora_fun;
	}

}
