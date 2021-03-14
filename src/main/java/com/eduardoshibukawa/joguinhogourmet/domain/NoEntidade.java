package com.eduardoshibukawa.joguinhogourmet.domain;

/**
* <h1> NoCaracteristica </h1>
* Classe que representa um nó entidade
* <p>
* @ author Eduardo Shibukawa
*/
public class NoEntidade extends NoPergunta {
	private String entidade;
	
	/**
	* Construtor do nó caracteristica
	* <p>
	* @param entidade Entidade do nó exemplo: Bolo
	*/
	public NoEntidade(String entidade) {					
		super(String.format("O que você está pensando é um(a) %s?", entidade.toLowerCase()));
		this.entidade = entidade;
	}
	
	/**
	* Esse método retorna a entidade do nó
	* @return String entidade do nó 
	*/
	public String getEntidade() {
		return entidade;		
	}	
}
