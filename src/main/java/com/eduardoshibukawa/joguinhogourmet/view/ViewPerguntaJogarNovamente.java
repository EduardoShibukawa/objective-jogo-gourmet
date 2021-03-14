package com.eduardoshibukawa.joguinhogourmet.view;

/**
* <h1> ViewPerguntaJogarNovamente </h1>
* Interface para mostrar mensagem de perguntando caso o usuário deseja jogar novamente usuário 
* <p>
* @ author Eduardo Shibukawa
*/
public interface ViewPerguntaJogarNovamente {
	
	/**
	* Esse método é utilizado buscar a resposta do usuário se ele deseja jogar o jogo novamente
	* <p>
	* @return boolean Resposta do usuário caso ele queira jogar novamente
	**/
	public boolean executar();
}
