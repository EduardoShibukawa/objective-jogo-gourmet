package com.eduardoshibukawa.joguinhogourmet;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho.Acao;

final public class Joguinho {
	
	final private EngineJoguinho engineJoguinho;
	
	private boolean executando;
	
	public Joguinho(EngineJoguinho engineJoguinho) {
		this.engineJoguinho = engineJoguinho;
		this.executando = true;
	};

	public void executar() {
		engineJoguinho.cumprimentar();
		while (executando) {			
			realizarAcao();
		}
	}
	
	private void realizarAcao() {
		engineJoguinho.perguntar();
		
		Acao proximaAcao = engineJoguinho.getProximaAcao();
		
		switch (proximaAcao) {
		case AVANCAR:
			engineJoguinho.avancar();				
			break;
			
		case PARABENIZAR:
			this.engineJoguinho.parabenizar();					
			this.executando = this.engineJoguinho.desejaJogarNovamente();
			if (executando)
				this.engineJoguinho.iniciar();
			break;
			
		case CRIAR_FILHO:
			engineJoguinho.criarFilho();
			this.engineJoguinho.iniciar();		
			break;
		}
	}
}