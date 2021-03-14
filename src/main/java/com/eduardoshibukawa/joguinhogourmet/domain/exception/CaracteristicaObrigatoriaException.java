package com.eduardoshibukawa.joguinhogourmet.domain.exception;

/**
* <h1> CaracteristicaObrigatoriaException </h1>
* Está é uma exceção que ocorre quando existe a falta de uma caracteristica 
* <p>
* @ author Eduardo Shibukawa
*/
public class CaracteristicaObrigatoriaException extends ErroValidacaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131980392165688433L;
	
	public CaracteristicaObrigatoriaException() {
		super("Característica deve ser informada!");
	}

}
