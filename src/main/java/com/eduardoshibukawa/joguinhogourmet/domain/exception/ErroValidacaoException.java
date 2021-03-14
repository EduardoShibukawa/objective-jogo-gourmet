package com.eduardoshibukawa.joguinhogourmet.domain.exception;

/**
* <h1> ErroValidacaoException </h1>
* Está é uma exceção abstrata que representa algum erro de validação 
* <p>
* @ author Eduardo Shibukawa
*/
public abstract class ErroValidacaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErroValidacaoException(String mensagem) {
		super(mensagem);
	}

}
