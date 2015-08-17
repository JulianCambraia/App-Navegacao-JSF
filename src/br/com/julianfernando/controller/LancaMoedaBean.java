package br.com.julianfernando.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LancaMoedaBean {

	public String lancarMoeda() {
		if (Math.random()< 0.5) {
			return "cara";
		} else {
			return "coroa";
		}
	}
}
