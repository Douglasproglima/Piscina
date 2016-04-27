package br.com.sistemapiscina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain{
	@ManyToOne
	@JoinColumn(name = "codCGE", nullable = false, foreignKey = @ForeignKey(name = "FK_CGEXEmpresa") )
	private CGE cge;
	
	@Column(nullable=false, length=15)
	private String nome;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Transient
	private String senhaSemCriptografia;
	
	@Column(nullable = false, length = 1)
	private Character tipo;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CGE getCge() {
		return cge;
	}

	public void setCge(CGE cge) {
		this.cge = cge;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	@Transient
	public String getativoFormatado() {
		String ativoFormatado = null;
		if (ativo) {
			ativoFormatado = "Sim";
		}else{
			ativoFormatado = "Não";
		}
		
		return ativoFormatado;
	}	
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public Character getTipo() {
		return tipo;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		if (tipo == 'A') {
			tipoFormatado = "Administrador";
		} else if(tipo == 'B'){
			tipoFormatado = "Balconista";
		} else if(tipo == 'G'){
			tipoFormatado = "Gerente";
		}
		
		return tipoFormatado;
	}	
	
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	
}
