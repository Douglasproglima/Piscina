package br.com.sistemapiscina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

//CGE - Cadastro Geral de Entidades
@SuppressWarnings("serial")
@Entity
public class CGE extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String cidade;

	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 100, nullable = false)
	private String rua;

	@Column(length = 6, nullable = false)
	private Short numero;

	@Column(length = 50)
	private String complemento;

	@Column(length = 10)
	private String cep;

	@Column(length = 13)
	private String telefone;

	@Column(length = 14)
	private String celular;

	@Column(length = 50)
	private String email;	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
