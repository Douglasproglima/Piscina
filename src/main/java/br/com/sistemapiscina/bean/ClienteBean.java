package br.com.sistemapiscina.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemapiscina.dao.CGEDAO;
import br.com.sistemapiscina.dao.ClienteDAO;
import br.com.sistemapiscina.domain.CGE;
import br.com.sistemapiscina.domain.Cliente;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class ClienteBean implements Serializable{
	private Cliente cliente;
	private List<Cliente> clientes;
	
	private CGE cge;
	private List<CGE> cges;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public CGE getCge() {
		return cge;
	}
	
	public void setCge(CGE cge) {
		this.cge = cge;
	}
	
	public List<CGE> getCges() {
		return cges;
	}
	
	public void setCges(List<CGE> cges) {
		this.cges = cges;
	}
	
	@PostConstruct
	public void listar(){
		try {
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar os registros, erro: "+ erro);
			erro.printStackTrace();
		}	
	}
	
	public void novo(){
		try {
			cliente = new Cliente();
			
			CGEDAO cgedao = new CGEDAO();
			cges = cgedao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao inserir um novo registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);
			
			cliente = new Cliente();
			clientes = clienteDAO.listar();
			
			CGEDAO cgedao = new CGEDAO();
			cges =  cgedao.listar();
			
			Messages.addGlobalInfo("Registro salvo com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao salvar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			clientes = clienteDAO.listar();
			
			Messages.addGlobalInfo("Registro removido com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao excluir o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
			CGEDAO cgedao = new CGEDAO();
			cges = cgedao.listar();
			
			Messages.addGlobalInfo("Registro alterado com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao editar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}	
}
