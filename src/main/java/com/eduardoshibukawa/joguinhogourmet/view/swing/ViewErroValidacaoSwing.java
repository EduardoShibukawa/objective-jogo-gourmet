package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewErroValidacao;

/**
* <h1> ViewErroValidacaoSwing </h1>
* Implementação para visão em swing da interface
* <p>
* @ author Eduardo Shibukawa
*/
public class ViewErroValidacaoSwing implements ViewErroValidacao {
	public void executar(String mensagem) {
		JOptionPane.showMessageDialog(
				null, 
				mensagem, 
				"Dados inválidos", 
				JOptionPane.ERROR_MESSAGE
			);		
	}
}
