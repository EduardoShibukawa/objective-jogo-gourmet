package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewParabenizar;

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
