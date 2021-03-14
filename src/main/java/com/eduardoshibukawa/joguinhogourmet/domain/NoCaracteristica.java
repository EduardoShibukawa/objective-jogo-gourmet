package com.eduardoshibukawa.joguinhogourmet.domain;

/**
* <h1> NoCaracteristica </h1>
* Classe que representa um nó caracteristica
* <p>
* @ author Eduardo Shibukawa
*/
public class NoCaracteristica extends NoPergunta {
	
	/**
	* Construtor do nó caracteristica
	* <p>
	* @param caracteristica caracteristica do nó exemplo: Massa
	* @param noVerdadeiro Nó do filho para reposta verdadeira da caracteristica
	* @param noFalso Nó do filho para reposta falsa da caracteristica 
	*/
	public NoCaracteristica(String caracteristica, NoPergunta noVerdadeiro, NoPergunta noFalso) {
		super(String.format("Está pensando em algo que é um(a) %s?", caracteristica.toLowerCase()));
		this.setFilho(false, noFalso);
		this.setFilho(true, noVerdadeiro);
	}

}
