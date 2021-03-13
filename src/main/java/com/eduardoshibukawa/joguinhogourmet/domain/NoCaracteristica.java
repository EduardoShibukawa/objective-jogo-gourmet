package com.eduardoshibukawa.joguinhogourmet.domain;

public class NoCaracteristica extends NoPergunta {
	
	public NoCaracteristica(String caracteristica, NoPergunta noVerdadeiro, NoPergunta noFalso) {
		super(String.format("Está pensando em algo que é um(a) %s?", caracteristica.toLowerCase()));
		this.setFilho(false, noFalso);
		this.setFilho(true, noVerdadeiro);
	}

}
