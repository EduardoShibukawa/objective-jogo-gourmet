package com.eduardoshibukawa.joguinhogourmet.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoEntidadeTest {

	@Test
	void noEntidadeDevePossuirEntidadeCorreta() {
		String expected = "Bolo";
		NoEntidade no = new NoEntidade(expected);
		
		assertEquals(expected, no.getEntidade());
	}
	
	@Test
	void noEntidadeDevePossuirDescricaoCorreta() {
		NoEntidade no = new NoEntidade("Bolo");
		
		assertEquals("É um(a) bolo?", no.getPergunta());
	}	
	
}
