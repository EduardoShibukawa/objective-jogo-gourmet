package com.eduardoshibukawa.joguinhogourmet;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.NoCaracteristica;
import com.eduardoshibukawa.joguinhogourmet.domain.NoEntidade;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewPerguntaJogarNovamenteSwing;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewCumprimentoInicialSwing;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewParabenizarSwing;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewPerguntaNovaCaracteristicaSwing;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewPerguntaNovaEntidadeSwing;
import com.eduardoshibukawa.joguinhogourmet.view.swing.ViewPerguntaSwing;

public class Main {

	public static void main(String[] args) {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		
		ViewJoguinho joguinhoView = new ViewJoguinho(
				new ViewCumprimentoInicialSwing(),
				new ViewPerguntaSwing(),
				new ViewPerguntaNovaEntidadeSwing(),
				new ViewPerguntaNovaCaracteristicaSwing(),
				new ViewPerguntaJogarNovamenteSwing(),
				new ViewParabenizarSwing());
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, joguinhoView);
		Joguinho joguinho = new Joguinho(engine);
		joguinho.executar();				
	}
}
