package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewPerguntaJogarNovamente;

public class ViewPerguntaJogarNovamenteSwing implements ViewPerguntaJogarNovamente {
	public boolean executar() {
		int resultado = JOptionPane.showConfirmDialog(
				null, 
				"Deseja finalizar?", 
				"Finalizar?", 
				JOptionPane.YES_NO_OPTION
			);		
					
		if (resultado == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(
					null, 
					"Bom jogo, muito obrigado! :D", 
					"Bom jogo!", 
					JOptionPane.INFORMATION_MESSAGE
				);
			
			return false;
		}
		
		return true;				
	}
}
