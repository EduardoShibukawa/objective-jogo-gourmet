package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewParabenizar;

/**
* <h1> ViewParabenizarSwing </h1>
* Implementação para visão em swing da interface
* <p>
* @ author Eduardo Shibukawa
*/
public class ViewParabenizarSwing implements ViewParabenizar {
	public void executar() {
		JOptionPane.showMessageDialog(
				null, 
				"Acertei! :)", 
				"\\o/ \\o/ \\o/", 
				JOptionPane.INFORMATION_MESSAGE
			);		
	}
}
