package com.eduardoshibukawa.joguinhogourmet.view.swing;

import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

/**
* <h1> ViewJoguinhoSwing </h1>
* Implementação para visão em swing da interface
* <p>
* @ author Eduardo Shibukawa
*/
public class ViewJoguinhoSwing extends ViewJoguinho{
	
	public ViewJoguinhoSwing() {
		super(
			new ViewCumprimentoInicialSwing(),
			new ViewPerguntaSwing(),
			new ViewPerguntaNovaEntidadeSwing(),
			new ViewPerguntaNovaCaracteristicaSwing(),
			new ViewPerguntaJogarNovamenteSwing(),
			new ViewParabenizarSwing(),
			new ViewErroValidacaoSwing()
		);
	}
	

}
