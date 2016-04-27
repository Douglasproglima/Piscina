package br.com.sistemapiscina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain{
	@ManyToOne
	@JoinColumn(name = "codCGE", nullable = false, foreignKey = @ForeignKey(name = "FK_CGEXCliente"))
	private CGE cge;

	@Column(length = 14)
	private String cpf;

	@Column(length = 12)
	private String rg;
	
	
	@Column(nullable=false)
	private Boolean ativo;

	public CGE getCge() {
		return cge;
	}

	public void setCge(CGE cge) {
		this.cge = cge;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
