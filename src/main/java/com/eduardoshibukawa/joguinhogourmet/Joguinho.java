package com.eduardoshibukawa.joguinhogourmet;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;

public class Joguinho {
	
	final private EngineJoguinho engineJoguinho;
	
	public Joguinho(EngineJoguinho engineJoguinho) {
		this.engineJoguinho = engineJoguinho;
	};

	public void executar() {
		engineJoguinho.cumprimentar();
		while (engineJoguinho.isExecutando()) {			
			engineJoguinho.realizarAcao();
		}
	}
}