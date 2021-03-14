package com.eduardoshibukawa.joguinhogourmet.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoCaracteristicaTest {
	
	@Test
	void noCaracteristicaDevePossuirPerguntaCorreta() {
		NoCaracteristica no = new NoCaracteristica("Fruta", new NoEntidade("Limão"), new NoEntidade("Bolo"));
		
		assertEquals("Está pensando em algo que é um(a) fruta?", no.getPergunta());
	}
	
	
}
