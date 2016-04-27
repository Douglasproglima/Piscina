package br.com.sistemapiscina.bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.sistemapiscina.dao.CGEDAO;
import br.com.sistemapiscina.dao.EmpresaDAO;
import br.com.sistemapiscina.domain.CGE;
import br.com.sistemapiscina.domain.Empresa;

@SuppressWarnings("serial")
@ManagedBean(name = "empresaBean")
@ViewScoped
public class EmpresaBean implements Serializable{
	private Empresa empresa;
	private List<Empresa> empresas;
	
	private CGE cge;
	private List<CGE> cges;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
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
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresas = empresaDAO.listar();
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar os registros, erro: "+ erro);
			erro.printStackTrace();
		}	
	}
	
	public void novo(){
		try {
			empresa = new Empresa();
			
			CGEDAO cgedao = new CGEDAO();
			cges = cgedao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao inserir um novo registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			if (empresa.getCaminho() == null) {
				Messages.addGlobalError("O campo Logotipo é obrigatório.");
				return;
			}
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			Empresa empresaRetorno = empresaDAO.mergeUpload(empresa);

			Path origem = Paths.get(empresa.getCaminho()); //Origem do caminho
			//O nome do arquivo após copiar para o diretório de destino será o código do produto com a extensão png
			Path destino = Paths.get("D:/AmbienteDesenvolvimento/Java/Workspace/Piscina/src/main/webapp/resources/uploadImagens/"+empresaRetorno.getCodigo()+".png"); //Destino
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			
			empresa = new Empresa();
			empresas = empresaDAO.listar();
			
			CGEDAO cgedao = new CGEDAO();
			cges =  cgedao.listar();
			
			Messages.addGlobalInfo("Registro salvo com sucesso.");
		} catch (RuntimeException | IOException erro) {
			Messages.addGlobalError("Erro ao salvar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			empresa =  (Empresa) evento.getComponent().getAttributes().get("empresaSelecionada");
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresaDAO.excluir(empresa);
			
//			Path arquivo = Paths.get("D:/AmbienteDesenvolvimento/Java/Workspace/Piscina/src/main/webapp/resources/uploadImagens/"+empresa.getCodigo()+".png");
//			Files.deleteIfExists(arquivo);
//			
			empresas = empresaDAO.listar();
			
			Messages.addGlobalInfo("Registro removido com sucesso.");
//		} catch (RuntimeException | IOException erro) {
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao excluir o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try {
			empresa =  (Empresa) evento.getComponent().getAttributes().get("empresaSelecionada");
//			empresa.setCaminho("D:/AmbienteDesenvolvimento/Java/Workspace/Piscina/src/main/webapp/resources/uploadImagens/" + empresa.getCodigo()+".png");
			
			CGEDAO cgedao = new CGEDAO();
			cges = cgedao.listar();
			
			Messages.addGlobalInfo("Registro alterado com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao editar o registro, erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
	public void upload(FileUploadEvent evento){
		try {
			UploadedFile arquivoUpload =  evento.getFile();
			Path arquivoTemp =  Files.createTempFile(null, null);

			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			empresa.setCaminho(arquivoTemp.toString());
			
			Messages.addGlobalInfo("Upload realizado com sucesso");
		} catch (IOException erro) {
			Messages.addGlobalError("Erro ao realizar upload do arquivo, erro: "+ erro);
			erro.printStackTrace();
		}		
	}
}
