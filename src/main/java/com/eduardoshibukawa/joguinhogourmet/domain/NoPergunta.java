package com.eduardoshibukawa.joguinhogourmet.domain;

/**
* <h1> NoPergunta </h1>
* Classe que representa a abstração de um nó do jogo
* <p>
* @ author Eduardo Shibukawa
*/
public abstract class NoPergunta {
	final private String pergunta;
	private NoPergunta noVerdadeiro;
	private NoPergunta noFalso;

	/**
	* Construtor do nó pergunta
	* <p>
	* @param pergunta Pergunta do nó exemplo: Está pensando em algo que é um(a) massa?
	*/
	public NoPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/**
	* Esse método seta um filho no nó
	* @param opcao Opcao para saber em qual filho deve ser setado o filho
	* @param no Nó que será setado
	*/
	public void setFilho(boolean opcao, NoPergunta no) {
		if (opcao) {
			this.noVerdadeiro = no;
		} else {
			this.noFalso = no;
		}
	}

	/**
	* Esse método retorna a pergunta nó
	* @return String pergunta do nó 
	*/
	public String getPergunta() {
		return pergunta;
	}

	/**
	* Esse método retorna a entidade do nó
	* @param opcao Opcao para saber qual nó irá retornar
	* @return NoPergunta nó 
	*/
	public NoPergunta getFilho(boolean opcao) {
		if (opcao) 
			return this.noVerdadeiro;		

		return this.noFalso;
	}
	
	/**
	* Esse método verifica se o filho é existente
	* @param Opcao para saber qual nó irá verificar
	* @return Boolean retorna se o filho é existente 
	*/
	public boolean isFilhoExistente(boolean opcao) {
		return this.getFilho(opcao) != null;	
	}

}