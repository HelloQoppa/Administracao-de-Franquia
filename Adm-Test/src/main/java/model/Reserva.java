package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

	private Integer id;
	private String pessoas;
	private String descricao;
	private LocalDate data;
	private LocalTime hora_inicio;
	private LocalTime hora_fim;
	private Produtos mesa;
	private Cliente clientes;

	public Reserva(Produtos mesa, Cliente clientes, String pessoas, String descricao, LocalDate data,
			LocalTime hora_inicio, LocalTime hora_fim) {
		super();
		this.mesa = mesa;
		this.clientes = clientes;
		this.pessoas = pessoas;
		this.descricao = descricao;
		this.data = data;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}

	public Reserva() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produtos getMesa() {
		return mesa;
	}

	public void setMesa(Produtos mesa) {
		this.mesa = mesa;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public String getPessoas() {
		return pessoas;
	}

	public void setPessoas(String pessoas) {
		this.pessoas = pessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(LocalTime hora_fim) {
		this.hora_fim = hora_fim;
	}

}
