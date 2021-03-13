package com.eduardoshibukawa.joguinhogourmet.domain;

import com.eduardoshibukawa.joguinhogourmet.domain.exception.CaracteristicaObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.domain.exception.EntidadeObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

public class EngineJoguinho {
	public enum Acao {
		AVANCAR, CRIAR_FILHO, PARABENIZAR
	}

	final private ViewJoguinho view;
	final private NoPergunta noRaiz;
	private NoPergunta noAtual;
	private NoPergunta noAnterior;
	private boolean opcaoEscolhida;
	private boolean opcaoEscolhidaAnterior;

	public EngineJoguinho(NoCaracteristica noRaiz, ViewJoguinho viewJoguinho) {
		this.view = viewJoguinho;
		this.noRaiz = noRaiz;
		this.iniciar();
	}

	public void perguntar() {
		this.opcaoEscolhidaAnterior = this.opcaoEscolhida;
		this.opcaoEscolhida = view.perguntar(noAtual.getPergunta());
	}

	public Acao getProximaAcao() {
		if (this.noAtual.isFilhoExistente(this.opcaoEscolhida)) {
			return Acao.AVANCAR;
		}

		if (this.opcaoEscolhida) {
			return Acao.PARABENIZAR;
		}

		return Acao.CRIAR_FILHO;
	}

	public void avancar() {
		this.noAnterior = this.noAtual;
		this.noAtual = this.noAtual.getFilho(opcaoEscolhida);
	}

	public void criarFilho() throws EntidadeObrigatoriaException, CaracteristicaObrigatoriaException {
		String novaEntidade = view.perguntarNovaEntidade();

		if (novaEntidade == null || novaEntidade.isBlank())
			throw new EntidadeObrigatoriaException();

		String novaCaracteristica = view.perguntarNovaCaracteristica(((NoEntidade) this.noAtual).getEntidade(),
				novaEntidade);

		if (novaCaracteristica == null || novaCaracteristica.isBlank())
			throw new CaracteristicaObrigatoriaException();

		NoPergunta novoNo = new NoCaracteristica(novaCaracteristica, new NoEntidade(novaEntidade), this.noAtual);

		this.noAnterior.setFilho(this.opcaoEscolhidaAnterior, novoNo);
	}

	public void iniciar() {
		this.noAtual = this.noRaiz;
		this.noAnterior = null;
		this.opcaoEscolhida = false;
		this.opcaoEscolhidaAnterior = false;
	}

	public void cumprimentar() {
		view.cumprimentar();
	}

	public void parabenizar() {
		view.parabenizar();
	}

	public boolean desejaJogarNovamente() {
		return view.jogarNovamente();
	}
}
