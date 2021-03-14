package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewCumprimentoInicial;

/**
* <h1> ViewCumprimentoInicialSwing </h1>
* Implementação para visão em swing da interface
* <p>
* @ author Eduardo Shibukawa
*/
public class ViewCumprimentoInicialSwing implements ViewCumprimentoInicial {
	
	@Override
	public void executar() {
		JOptionPane.showMessageDialog(
				null, 
				"Bem vindo, Iniciando jogo!! \\o/ ", 
				"Bem vindo", 
				JOptionPane.INFORMATION_MESSAGE
			);
		JOptionPane.showMessageDialog(
				null, 
				"Pense em uma comida.", 
				"Instruções", 
				JOptionPane.INFORMATION_MESSAGE
			);
	}

}
