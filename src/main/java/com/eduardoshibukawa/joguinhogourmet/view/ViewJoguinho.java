package com.eduardoshibukawa.joguinhogourmet.view;


/**
* <h1> ViewJoguinho </h1>
* Classe de abstração com a DI das views para ser utilizada na engine do jogo.
* <p>
* @ author Eduardo Shibukawa
*/
public abstract class ViewJoguinho  {
	
	final private ViewCumprimentoInicial viewCumprimentoInicial;
	final private ViewPergunta viewPergunta;
	final private ViewPerguntaNovaEntidade viewPerguntaNovaEntidade;
	final private ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristica;
	final private ViewPerguntaJogarNovamente viewPerguntaJogarNovamente;
	final private ViewParabenizar viewParabenizar;
	final private ViewErroValidacao viewErroValidacao;
	
	public ViewJoguinho(ViewCumprimentoInicial viewCumprimentoInicial, ViewPergunta viewPergunta, 
			ViewPerguntaNovaEntidade viewPerguntaNovaEntidade,
			ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristica,
			ViewPerguntaJogarNovamente viewPerguntaJogarNovamente, ViewParabenizar viewParabenizar,
			ViewErroValidacao viewErroValidacao) {
		this.viewCumprimentoInicial = viewCumprimentoInicial;
		this.viewPergunta = viewPergunta;
		this.viewPerguntaNovaEntidade = viewPerguntaNovaEntidade;
		this.viewPerguntaNovaCaracteristica = viewPerguntaNovaCaracteristica;
		this.viewPerguntaJogarNovamente = viewPerguntaJogarNovamente;
		this.viewParabenizar = viewParabenizar;
		this.viewErroValidacao = viewErroValidacao;
	}
	 	
	/**
	* Esse método é utilizado para mostrar mensagem de parabenização
	* após o jogo acertar a resposta do usuário
	**/		
	public void cumprimentar() {
		viewCumprimentoInicial.executar();
	}
	
	/**
	* Esse método é utilizado para perguntar ao usuário e obter uma resposta a pergunta
	* <p>
	* @param pergunta Pergunta que será feita ao usuároo
	* @return Boolean resposta do usuário
	**/	
	public boolean perguntar(String pergunta) {
		return this.viewPergunta.executar(pergunta);
	}
	
	/**
	* Esse método é utilizado para perguntar ao usuário a nova entidade
	* <p>
	* @return String nova entidade informada pelo usuário
	**/	
	public String perguntarNovaEntidade() {
		return this.viewPerguntaNovaEntidade.executar();
	}
	
	/**
	* Esse método é utilizado para perguntar ao usuário a caracteristica da nova entidade
	* <p>
	* @param entidadeAntiga ultima entidade que foi mostrada ao usuário
	* @param entidadeNova nova entidade que foi informada pelo usuário
	* @return String nova caracteristica informada pelo usuário 
	**/
	public String perguntarNovaCaracteristica(String entidadeAntiga, String entidadeNova) {
		return this.viewPerguntaNovaCaracteristica.executar(entidadeAntiga, entidadeNova);
	}
	
	/**
	* Esse método é utilizado para mostrar mensagem de parabenização
	* após o jogo acertar a resposta do usuário
	**/		
	public void parabenizar() {
		this.viewParabenizar.executar();
	}
	
	/**
	* Esse método é utilizado buscar a resposta do usuário se ele deseja jogar o jogo novamente
	* <p>
	* @return boolean Resposta do usuário caso ele queira jogar novamente
	**/	
	public boolean jogarNovamente() {
		return this.viewPerguntaJogarNovamente.executar();
	}
	
	
	/**
	* Esse método é utilizado para mostrar mensagem de erro de validação
	**/	
	public void erroValidacao(String mensagem) {
		this.viewErroValidacao.executar(mensagem);
	}
}
