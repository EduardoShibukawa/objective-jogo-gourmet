package com.eduardoshibukawa.joguinhogourmet.view;


/**
* <h1> ViewPergunta </h1>
* Interface para mostrar mensagem de pergunta de uma caracteristica ou entidade para o usuário 
* <p>
* @ author Eduardo Shibukawa
*/
public interface ViewPergunta {
	
	/**
	* Esse método é utilizado para perguntar ao usuário e obter uma resposta a pergunta
	* <p>
	* @param pergunta Pergunta que será feita ao usuároo
	* @return Boolean resposta do usuário
	**/
	public boolean executar(String pergunta);

}
