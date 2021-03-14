package com.eduardoshibukawa.joguinhogourmet.view;

/**
* <h1> ViewPerguntaNovaCaracteristica </h1>
* Interface para mostrar mensagem de pergunta da nova caracteristica para o usuário 
* <p>
* @ author Eduardo Shibukawa
*/
public interface ViewPerguntaNovaCaracteristica {
	
	/**
	* Esse método é utilizado para perguntar ao usuário a caracteristica da nova entidade
	* <p>
	* @param entidadeAntiga ultima entidade que foi mostrada ao usuário
	* @param entidadeNova nova entidade que foi informada pelo usuário
	* @return String nova caracteristica informada pelo usuário 
	**/
	public String executar(String entidadeAntiga, String entidadeNova);
}
