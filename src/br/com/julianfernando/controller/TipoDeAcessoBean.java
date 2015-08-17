package br.com.julianfernando.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TipoDeAcessoBean {

	private List<String> tiposDeAcessos = new ArrayList<String>();
	
	private String tipoAcessoSelecionado;
	
	private String tpAcesso;
	
	
	public TipoDeAcessoBean() {
		super();
		this.tiposDeAcessos.add("Simples");
		this.tiposDeAcessos.add("Avançado");
	}



	public String acesso() {
		
		String tipoAcesso = null; 
		if (this.getTipoAcessoSelecionado() != null) {
			tipoAcesso = this.getTipoAcessoSelecionado(); 
		}
		
		if (tipoAcesso == null) {
			FacesMessage message = new FacesMessage("Tipo de preferência de preenchimento obrigatório");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} else {
			
			if (tipoAcesso.equalsIgnoreCase("Avançado") ) {
				return "app-avancado";
			} else {
				return "app-simples";
			}
		}
		return null;
	}

	public String preferenciaAcesso() {
		this.setTpAcesso(this.getTipoAcessoSelecionado());
		return "preferencia";
	}

	public List<String> getTiposDeAcessos() {
		return tiposDeAcessos;
	}

	public void setTiposDeAcessos(List<String> tiposDeAcessos) {
		this.tiposDeAcessos = tiposDeAcessos;
	}



	public String getTipoAcessoSelecionado() {
		return tipoAcessoSelecionado;
	}



	public void setTipoAcessoSelecionado(String tipoAcessoSelecionado) {
		this.tipoAcessoSelecionado = tipoAcessoSelecionado;
	}



	public String getTpAcesso() {
		return tpAcesso;
	}



	public void setTpAcesso(String tpAcesso) {
		this.tpAcesso = tpAcesso;
	}
}
