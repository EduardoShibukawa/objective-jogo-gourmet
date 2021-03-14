package com.eduardoshibukawa.joguinhogourmet.domain;

import com.eduardoshibukawa.joguinhogourmet.domain.exception.CaracteristicaObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.domain.exception.EntidadeObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

/**
* <h1> Engine Joginho </h1>
* Classe que cuida da implementação da regra de negócio do jogo gourmet.
* <p>
* @ author Eduardo Shibukawa
*/
public class EngineJoguinho {
	/**
	* <h1> EngineJoguinho.Acao </h1>
	* <p>
	* Classe que simboliza a próxima ação da engine
	* <p>
	* Valores: AVANCAR, CRIAR_FILHO, PARABENIZAR
	**/	
	public enum Acao {
		AVANCAR, CRIAR_FILHO, PARABENIZAR
	}

	final private ViewJoguinho view;
	final private NoPergunta noRaiz;
	private NoPergunta noAtual;
	private NoPergunta noAnterior;
	private boolean opcaoEscolhida;
	private boolean opcaoEscolhidaAnterior;

	/**
	* Construtor da engine do jogo
	* <p>
	* @param noRaiz Raiz Nó raiz sendo um NoCaracteristica
	* @param viewJoguinho View do jogo que será utilizada como interface com o usuário 
	*/
	public EngineJoguinho(NoCaracteristica noRaiz, ViewJoguinho viewJoguinho) {
		this.view = viewJoguinho;
		this.noRaiz = noRaiz;
		this.iniciar();
	}

	
	/**
	* Construtor da engine do jogo
	* <p>
	* Esse método é utilizado atualizar a reposta escolhida pelo usuário ao realizar uma pergunta
	**/	
	public void perguntar() {
		this.opcaoEscolhidaAnterior = this.opcaoEscolhida;
		this.opcaoEscolhida = view.perguntar(noAtual.getPergunta());
	}

	/**
	* Esse método é utilizado buscar a próxima ação a ser realizada pela engine
	* 
	* @return Acao Próxima ação do a ser realiza pelo usuário
	**/	
	public Acao getProximaAcao() {
		if (this.noAtual.isFilhoExistente(this.opcaoEscolhida)) {
			return Acao.AVANCAR;
		}

		if (this.opcaoEscolhida) {
			return Acao.PARABENIZAR;
		}

		return Acao.CRIAR_FILHO;
	}

	/**
	* Esse método é utilizado para avançar o ponteiro para o próximo nó válido
	**/	
	public void avancar() {
		this.noAnterior = this.noAtual;
		this.noAtual = this.noAtual.getFilho(opcaoEscolhida);
	}

	/**
	* Esse método é utilizado criar o nó filho 
	* quando não acertamos a resposta do usuário
	* <p>
	* @exception EntidadeObrigatoriaException quando entidade informada é vazia
	* @exception CaracteristicaObrigatoriaException quando a caracteristica informada é vazia 
	**/	
	public void criarFilho() throws EntidadeObrigatoriaException, CaracteristicaObrigatoriaException {
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

	/**
	* Esse método é utilizado para atualizar a engine para recomeçar um jogo 
	**/	
	public void iniciar() {
		this.noAtual = this.noRaiz;
		this.noAnterior = null;
		this.opcaoEscolhida = false;
		this.opcaoEscolhidaAnterior = false;
	}

	/**
	* Esse método é utilizado mostrar a visão de cumprimento quando começamos um novo jogo
	**/	
	public void cumprimentar() {
		view.cumprimentar();
	}

	/**
	* Esse método é utilizado mostrar a visão de parabenização quando acertamos a resposta do usuário 
	**/
	public void parabenizar() {
		view.parabenizar();
	}

	/**
	* Esse método é utilizado buscar a resposta do usuário se ele deseja jogar o jogo novamente
	**/
	public boolean desejaJogarNovamente() {
		return view.jogarNovamente();
	}

	/**
	* Esse método é utilizado para mostrar um erro de validação para o usuário
	**/
	public void erroValidacao(String mensagem) {
		view.erroValidacao(mensagem);
	}
}
