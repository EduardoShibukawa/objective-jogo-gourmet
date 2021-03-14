package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewPerguntaNovaEntidade;

/**
* <h1> ViewPerguntaNovaCaracteristicaSwing </h1>
* Implementação para visão em swing da interface
* <p>
* @ author Eduardo Shibukawa
*/
public class ViewPerguntaNovaEntidadeSwing implements ViewPerguntaNovaEntidade {
	public String executar() {
		return JOptionPane.showInputDialog(
				null,
				"Em qual comida você pensou?",
				"Pergunta",
				JOptionPane.QUESTION_MESSAGE
			);
	}
}
