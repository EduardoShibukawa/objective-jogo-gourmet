package com.eduardoshibukawa.joguinhogourmet.domain;

import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

/**
* <h1> Engine Joginho </h1>
* Classe que cuida da implementação da regra de negócio do jogo gourmet.
* <p>
* @ author Eduardo Shibukawa
*/
public class EngineJoguinho {
	private enum Acao {
		AVANCAR, CRIAR_FILHO, PARABENIZAR
	}
	
	private abstract class ErroValidacaoException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public ErroValidacaoException(String mensagem) {
			super(mensagem);
		}
	}

	private class CaracteristicaObrigatoriaException extends ErroValidacaoException {
		private static final long serialVersionUID = -8131980392165688433L;
		
		public CaracteristicaObrigatoriaException() {
			super("Característica deve ser informada!");
		}
	}
	
	private class EntidadeObrigatoriaException extends ErroValidacaoException {
		private static final long serialVersionUID = -3155745051161876287L;

		public EntidadeObrigatoriaException() {
			super("Entidade deve ser informada!");
		}
	}
	
	final private ViewJoguinho view;
	final private NoPergunta noRaiz;
	private NoPergunta noAtual;
	private NoPergunta noAnterior;
	private boolean opcaoEscolhida;
	private boolean opcaoEscolhidaAnterior;
	private boolean isExecutando;

	/**
	* Construtor da engine do jogo
	* <p>
	* @param noRaiz Raiz Nó raiz sendo um NoCaracteristica
	* @param viewJoguinho View do jogo que será utilizada como interface com o usuário 
	*/
	public EngineJoguinho(NoCaracteristica noRaiz, ViewJoguinho viewJoguinho) {
		this.view = viewJoguinho;
		this.noRaiz = noRaiz;
		this.isExecutando = true;
		this.iniciar();
	}

	/**
	* Esse método é utilizado mostrar a visão de cumprimento quando começamos um novo jogo
	**/	
	public void cumprimentar() {
		view.cumprimentar();
	}
	
	/**
	* Esse método é utilizado para realizar a pergunta ao usuário
	* e a partir da resposta realizar a próxima ação do jogo
	**/		
	public void realizarAcao() {
		this.perguntar();
		
		Acao proximaAcao = this.getProximaAcao();
		
		switch (proximaAcao) {
		case AVANCAR:
			this.avancar();				
			break;
			
		case PARABENIZAR:
			this.parabenizar();					
			this.isExecutando = this.desejaJogarNovamente();
			if (this.isExecutando)
				this.iniciar();
			break;
			
		case CRIAR_FILHO:
			try {
				this.criarFilho();
			} catch (ErroValidacaoException e) {
				final String mensagemErroValidacao 
					= String.format("Não foi possivel criar filho: %s", e.getMessage());
				
				this.erroValidacao(mensagemErroValidacao);
			}
			
			this.iniciar();		
			break;
		}
	}
	
	private void perguntar() {
		this.opcaoEscolhidaAnterior = this.opcaoEscolhida;
		this.opcaoEscolhida = view.perguntar(noAtual.getPergunta());
	}


	private Acao getProximaAcao() {
		if (this.noAtual.isFilhoExistente(this.opcaoEscolhida)) {
			return Acao.AVANCAR;
		}

		if (this.opcaoEscolhida) {
			return Acao.PARABENIZAR;
		}

		return Acao.CRIAR_FILHO;
	}

	private void avancar() {
		this.noAnterior = this.noAtual;
		this.noAtual = this.noAtual.getFilho(opcaoEscolhida);
	}


	private void criarFilho() throws EntidadeObrigatoriaException, CaracteristicaObrigatoriaException {
		String novaEntidade = view.perguntarNovaEntidade();

		if (novaEntidade == null || novaEntidade.isBlank())
			throw new EntidadeObrigatoriaException();

		String novaCaracteristica = view.perguntarNovaCaracteristica(
				((NoEntidade) this.noAtual).getEntidade(),
				novaEntidade
			);

		if (novaCaracteristica == null || novaCaracteristica.isBlank())
			throw new CaracteristicaObrigatoriaException();

		NoPergunta novoNo = new NoCaracteristica(
				novaCaracteristica, 
				new NoEntidade(novaEntidade), 
				this.noAtual 
		);

		this.noAnterior.setFilho(this.opcaoEscolhidaAnterior, novoNo);
	}

	private void iniciar() {
		this.noAtual = this.noRaiz;
		this.noAnterior = null;
		this.opcaoEscolhida = false;
		this.opcaoEscolhidaAnterior = false;
	}


	private void parabenizar() {
		view.parabenizar();
	}

	private boolean desejaJogarNovamente() {
		return view.jogarNovamente();
	}

	private void erroValidacao(String mensagem) {
		view.erroValidacao(mensagem);
	}

	public boolean isExecutando() {
		return this.isExecutando;
	}
}
