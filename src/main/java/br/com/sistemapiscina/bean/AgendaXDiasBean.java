package br.com.sistemapiscina.bean;

import java.io.Serializable;
import java.util.List;

import br.com.sistemapiscina.domain.Agenda;

@SuppressWarnings("serial")
public class AgendaXDiasBean implements Serializable{
	private AgendaXDiasBean agendaXDiasBean;
	private List<Agenda> agendas;
	
	public AgendaXDiasBean getAgendaXDiasBean() {
		return agendaXDiasBean;
	}
	public void setAgendaXDiasBean(AgendaXDiasBean agendaXDiasBean) {
		this.agendaXDiasBean = agendaXDiasBean;
	}
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}	
}
