package br.com.sistemapiscina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class AgendaXDias extends GenericDomain{
	@ManyToOne
	@JoinColumn(name = "codAgenda", nullable = false, foreignKey = @ForeignKey(name = "FK_DiasXAgenda"))
	private Agenda agenda;
	
	@Column(length = 30)
	private String diaSemana;
	
	@Column(length = 2)
	private String dia;
	
	@Column(length = 2)
	private String mes;
	
	@Column(length = 6)
	private String ano;

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}
