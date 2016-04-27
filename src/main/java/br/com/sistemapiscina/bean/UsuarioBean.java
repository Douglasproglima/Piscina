package br.com.sistemapiscina.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemapiscina.dao.CGEDAO;
import br.com.sistemapiscina.dao.UsuarioDAO;
import br.com.sistemapiscina.domain.CGE;
import br.com.sistemapiscina.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<CGE> cges;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar os registros, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		try {
			usuario = new Usuario();
			
			CGEDAO cgeDAO = new CGEDAO();
			cges = cgeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao inserir um novo Usuário, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
			
			usuario = new Usuario();
			usuarios = usuarioDAO.listar();
			
			CGEDAO cgeDAO = new CGEDAO();
			cges = cgeDAO.listar();
			
			Messages.addGlobalInfo("Registro salvo com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao salvar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);
			
			usuarios = usuarioDAO.listar();
			
			Messages.addGlobalInfo("Registro removido com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao excluir o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			CGEDAO cgeDAO = new CGEDAO();
			cges = cgeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao editar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}	
}
