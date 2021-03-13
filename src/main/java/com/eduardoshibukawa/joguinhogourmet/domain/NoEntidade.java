package com.eduardoshibukawa.joguinhogourmet.domain;

public class NoEntidade extends NoPergunta {
	private String entidade;
	
	public NoEntidade(String entidade) {					
		super(String.format("É um(a) %s?", entidade.toLowerCase()));
		this.entidade = entidade;
	}
	
	public String getEntidade() {
		return entidade;		
	}	
}
