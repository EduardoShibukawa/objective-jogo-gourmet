package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewPerguntaNovaCaracteristica;

public class ViewPerguntaNovaCaracteristicaSwing implements ViewPerguntaNovaCaracteristica {
	
	@Override
	public String executar(String entidadeAntiga, String entidadeNova) {
		return JOptionPane.showInputDialog(
				null,
				String.format(
						"Complete a sentença: %s é um(a) ____  e %s não.", 
						entidadeNova.toLowerCase(),
						entidadeAntiga.toLowerCase()
						),
				"Complete a sentença",
				JOptionPane.QUESTION_MESSAGE
				);
	}
}
