package br.com.sistemapiscina.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sistemapiscina.domain.CGE;
import br.com.sistemapiscina.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

/*Anotações da Class
 * @RequestScoped -> A cada clique o usuário será destruído;
 * @ViewScoped	  -> O usuário fica ativo somente durante a execução da tela atual, quando alterar p/ outra janela a sessão morre;
 * @SessionScoped -> O usuário é criado no momento em que loga e é destruído somente após a finalização ou logoff do sistema;
 * */
	
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//@PostConstruct -> Pode ser usado para instânciar o que for necessário, é como se fosse um construtor puro do JSF
	@PostConstruct
	public void iniciar(){
		usuario = new Usuario();
		
		//Necessário instânciar o pessoa para chamar a senha na página;
		usuario.setCge(new CGE());
	}
	
	public void autenticar(){
		try {
			
			//Utilizando o omniFaces para o redicionamento da página;
			// "./" -> Informa para o omniFaces que o diretório inicial será webapp
			Faces.redirect("./pages/principal.xhtml");	
			
		} catch (IOException erro) {
			Messages.addGlobalError("Não foi possível localizar a página." + erro);
		}
	}
}
