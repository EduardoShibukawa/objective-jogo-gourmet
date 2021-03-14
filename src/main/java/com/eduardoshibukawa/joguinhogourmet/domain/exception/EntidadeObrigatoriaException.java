package com.eduardoshibukawa.joguinhogourmet.domain.exception;

/**
* <h1> EntidadeObrigatoriaException </h1>
* Está é uma exceção que ocorre quando existe a falta de uma entidade 
* <p>
* @ author Eduardo Shibukawa
*/
public class EntidadeObrigatoriaException extends ErroValidacaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3155745051161876287L;

	public EntidadeObrigatoriaException() {
		super("Entidade deve ser informada!");
	}
}
