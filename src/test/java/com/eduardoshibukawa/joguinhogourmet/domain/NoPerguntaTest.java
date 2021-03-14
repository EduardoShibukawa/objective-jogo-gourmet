package com.eduardoshibukawa.joguinhogourmet.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoPerguntaTest {
	
	private class NoTeste extends NoPergunta {

		public NoTeste(String pergunta) {
			super(pergunta);
		}
		
	}

	@Test
	void quandoCriarNoEntaoPerguntaDeveSerIgual() {
		NoPergunta no = new NoTeste("Teste");
		NoPergunta noFilho = new NoTeste("Filho Teste");
		
		no.setFilho(false, noFilho);
		
		assertEquals("Teste", no.getPergunta());
	}
	
	@Test
	void quandoCriarNoComFilhoEntaoNoDeveSerIgual() {
		NoPergunta no = new NoTeste("Teste");
		NoPergunta noFilho = new NoTeste("Filho Teste");
		
		no.setFilho(false, noFilho);
		
		assertEquals(noFilho, no.getFilho(false));
	}

	@Test
	void quandoBuscarNoSemFilhoEntaoDeveRetornarNull() {
		NoPergunta no = new NoTeste("Teste");
				
		assertEquals(null, no.getFilho(false));
	}
	@Test
	void quandoNoPossuirFilhoEntaoIsFilhoExistenteDeveRetornarVerdadeiro() {
		NoPergunta no = new NoTeste("Teste");
		NoPergunta noFilho = new NoTeste("Filho Teste");
		
		no.setFilho(false, noFilho);
		
		assertTrue(no.isFilhoExistente(false));
	}

}
