package br.com.sistemapiscina.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemapiscina.dao.AgendaDAO;
import br.com.sistemapiscina.dao.ClienteDAO;
import br.com.sistemapiscina.domain.Agenda;
import br.com.sistemapiscina.domain.AgendaXDias;
import br.com.sistemapiscina.domain.Cliente;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class AgendaBean implements Serializable{
	private Agenda agenda;
	private List<AgendaXDias> agendasXDias;
	private List<Cliente> clientes;
	private String data;
	
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<AgendaXDias> getAgendasXDias() {
		return agendasXDias;
	}
	
	public void setAgendasXDias(List<AgendaXDias> agendasXDias) {
		this.agendasXDias = agendasXDias;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void novo(){
		try {
			agenda = new Agenda();
			agenda.setValor(new BigDecimal("0.00"));
			
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			
			agendasXDias = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao inserir um novo registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}

	
	public void remover(ActionEvent evento){
		AgendaXDias agendaXDias = (AgendaXDias) evento.getComponent().getAttributes().get("itemAgendaXDiasSelecionado");
		
		int status = -1;
		for (int posicao = 0; posicao < agendasXDias.size(); posicao++) {
			if (agendasXDias.get(posicao).getAgenda().equals(agendaXDias)) {
				status =  posicao;
			}
		}
		
		if (status > -1) {
			agendasXDias.remove(status);
		}
	}
	
	public void salvar(){
		try {
			if (agenda.getValor().signum() == 0) {
				Messages.addGlobalInfo("Inform pelo ao menos um cliente para concluir o agendamento.");
				return;
			}
			
			AgendaDAO agendaDAO = new AgendaDAO();
			agendaDAO.salvar(agenda, agendasXDias);
			
			agenda = new Agenda();
			agenda.setValor(new BigDecimal("0.00"));
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			
			agendasXDias = new ArrayList<>();
			
			Messages.addGlobalInfo("Agendamento realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao salvar agendamento, erro: " + erro);
			erro.printStackTrace();
		}
	}
	
	public void submit(){
		String words[] = this.data.split(";");
		@SuppressWarnings("unused")
		String data02 = this.data;
	}
}
