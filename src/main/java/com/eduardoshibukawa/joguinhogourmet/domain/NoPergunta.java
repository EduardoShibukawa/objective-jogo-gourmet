package com.eduardoshibukawa.joguinhogourmet.domain;

public abstract class NoPergunta {
	private String pergunta;
	private NoPergunta noVerdadeiro;
	private NoPergunta noFalso;

	public NoPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public void setFilho(boolean opcao, NoPergunta no) {
		if (opcao) {
			this.noVerdadeiro = no;
		} else {
			this.noFalso = no;
		}
	}

	public String getPergunta() {
		return pergunta;
	}

	public NoPergunta getFilho(boolean opcao) {
		if (opcao) 
			return this.noVerdadeiro;		

		return this.noFalso;
	}
	
	public boolean isFilhoExistente(boolean opcao) {
		return this.getFilho(opcao) != null;	
	}
	
	public boolean isFilhoNaoExistente(boolean opcao) {
		return !this.isFilhoExistente(opcao);	
	}
}