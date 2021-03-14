package com.eduardoshibukawa.joguinhogourmet;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.NoCaracteristica;
import com.eduardoshibukawa.joguinhogourmet.domain.NoEntidade;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewJoguinhoSwing;

public class Main {

	public static void main(String[] args) {
		final NoCaracteristica noRaiz =
				new NoCaracteristica(
						"Massa", 
						new NoEntidade("Lasanha"),
						new NoEntidade("Bolo")
				);

		final ViewJoguinho joguinhoView = new ViewJoguinhoSwing();
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, joguinhoView);
		
		new Joguinho(engine).executar();
	}
}
