package br.com.sistemapiscina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Empresa extends GenericDomain {
	@ManyToOne
	@JoinColumn(name = "codCGE", nullable = false, foreignKey = @ForeignKey(name = "FK_CGEXEmpresa") )
	private CGE cge;

	@Column(nullable = false)
	private Boolean ativo;

	@Column(length = 100)
	private String nomeFantasia;

	@Column(length = 40)
	private String contato;

	@Column(length = 18)
	private String cnpj;

	@Column(length = 18)
	private String inscEstadual;

	// @Transient atributo temporário que não irá gerar tabela no banco de dados
	@Transient
	private String caminho;

	public CGE getCge() {
		return cge;
	}

	public void setCge(CGE cge) {
		this.cge = cge;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
