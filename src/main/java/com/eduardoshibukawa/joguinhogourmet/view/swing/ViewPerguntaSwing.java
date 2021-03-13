package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewPergunta;

public class ViewPerguntaSwing implements ViewPergunta {

	@Override
	public boolean executar(String pergunta) {
		 int choose = JOptionPane.showConfirmDialog(
				 null, 
				 pergunta, 
				 "Pergunta", 
				 JOptionPane.YES_NO_OPTION
			);
		 return choose == JOptionPane.YES_OPTION;
	}
	

}
