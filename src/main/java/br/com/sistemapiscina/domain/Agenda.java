package br.com.sistemapiscina.domain;

import java.math.BigDecimal;
//import java.util.Date;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Agenda extends GenericDomain{
	@ManyToOne
	@JoinColumn(name = "codCliente", nullable = false, foreignKey = @ForeignKey(name = "FK_ClienteXAgenda"))
	private Cliente cliente;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date[] data;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valor;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date[] getData() {
		return data;
	}
	
	public void setData(Date[] data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
