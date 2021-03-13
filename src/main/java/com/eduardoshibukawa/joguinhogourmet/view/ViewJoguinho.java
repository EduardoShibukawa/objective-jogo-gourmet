package com.eduardoshibukawa.joguinhogourmet.view;

public class ViewJoguinho  {
	
	final private ViewCumprimentoInicial viewCumprimentoInicial;
	final private ViewPergunta viewPergunta;
	final private ViewPerguntaNovaEntidade viewPerguntaNovaEntidade;
	final private ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristica;
	final private ViewPerguntaJogarNovamente viewPerguntaJogarNovamente;
	final private ViewParabenizar viewParabenizar;
	
	public ViewJoguinho(ViewCumprimentoInicial viewCumprimentoInicial, ViewPergunta viewPergunta, 
			ViewPerguntaNovaEntidade viewPerguntaNovaEntidade,
			ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristica,
			ViewPerguntaJogarNovamente viewPerguntaJogarNovamente, ViewParabenizar viewParabenizar) {
		this.viewCumprimentoInicial = viewCumprimentoInicial;
		this.viewPergunta = viewPergunta;
		this.viewPerguntaNovaEntidade = viewPerguntaNovaEntidade;
		this.viewPerguntaNovaCaracteristica = viewPerguntaNovaCaracteristica;
		this.viewPerguntaJogarNovamente = viewPerguntaJogarNovamente;
		this.viewParabenizar = viewParabenizar;
	}
	 	
	public void cumprimentar() {
		viewCumprimentoInicial.executar();
	}
	
	public boolean perguntar(String pergunta) {
		return this.viewPergunta.executar(pergunta);
	}
	
	public String perguntarNovaEntidade() {
		return this.viewPerguntaNovaEntidade.executar();
	}
	
	public String perguntarNovaCaracteristica(String entidadeAntiga, String entidadeNova) {
		return this.viewPerguntaNovaCaracteristica.executar(entidadeAntiga, entidadeNova);
	}
	
	public void parabenizar() {
		this.viewParabenizar.executar();
	}
	
	public boolean jogarNovamente() {
		return this.viewPerguntaJogarNovamente.executar();
	}
}
