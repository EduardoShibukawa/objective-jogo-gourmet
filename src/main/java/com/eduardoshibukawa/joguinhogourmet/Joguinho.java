package com.eduardoshibukawa.joguinhogourmet;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho.Acao;
import com.eduardoshibukawa.joguinhogourmet.domain.exception.ErroValidacaoException;

public class Joguinho {
	
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
			try {
				engineJoguinho.criarFilho();
			} catch (ErroValidacaoException e) {
				final String mensagemErroValidacao 
					= String.format("Não foi possivel criar filho: %s", e.getMessage());
				
				this.engineJoguinho.erroValidacao(mensagemErroValidacao);
			}
			
			this.engineJoguinho.iniciar();		
			break;
		}
	}
}