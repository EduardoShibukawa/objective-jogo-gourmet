package com.eduardoshibukawa.joguinhogourmet.view.swing;

import javax.swing.JOptionPane;

import com.eduardoshibukawa.joguinhogourmet.view.ViewPerguntaNovaEntidade;

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
