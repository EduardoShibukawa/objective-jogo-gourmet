package com.eduardoshibukawa.joguinhogourmet.domain;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

@ExtendWith(MockitoExtension.class)
class EngineJoguinhoTest {

	@Mock
	ViewJoguinho viewJoguinhoMock;

	@Mock
	NoCaracteristica noPerguntaMock;

	@Test
	void quandoRealizarAcaoEntaoViewPerguntarDeveSerChamada() {
		when(noPerguntaMock.getPergunta()).thenReturn("Está pensando em uma massa?");
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);
		engine.realizarAcao();

		verify(viewJoguinhoMock).perguntar(anyString());
	}

	@Test
	void quandoRealizarAcaoEntaoMetodoIsFilhoExistenteDeveSerChamado() {
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(true);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.realizarAcao();

		verify(noPerguntaMock, times(1)).isFilhoExistente(anyBoolean());
	}

	@Test
	void quandoCumprimentarEntaoMetodoCumprimentarDeveSerChamado() {
		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.cumprimentar();

		verify(viewJoguinhoMock, times(1)).cumprimentar();
	}
	
	@Test
	void quandoPerguntarSeDesejaJogarNovamenteEntaoMetodoDesejaJogarNovamenteDeveSerChamado() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);
		
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);

		while (engine.isExecutando())
			engine.realizarAcao();		

		verify(viewJoguinhoMock, times(1)).jogarNovamente();
	}

	@Test
	void quandoCriarFilhoEntaoMetodoPerguntaNovaCaracteristicaEntidadeDeveSerChamado() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);
		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn("Azedo");
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();

		verify(viewJoguinhoMock, times(1)).perguntarNovaEntidade();
		verify(viewJoguinhoMock, times(1)).perguntarNovaCaracteristica(anyString(), anyString());
	}

	@Test
	void quandoCriarFilhoComEntidadeNullEntaoErroValidacaoDeveSerChamadoComMensagemCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);		
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn(null);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();

		verify(viewJoguinhoMock, times(1)).erroValidacao("Não foi possivel criar filho: Entidade deve ser informada!");
	}

	@Test
	void quandoCriarFilhoComEntidadeVaziaEntaoErroValidacaoDeveSerChamadoComMensagemCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);		
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn(null);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();

		verify(viewJoguinhoMock, times(1)).erroValidacao("Não foi possivel criar filho: Entidade deve ser informada!");
	}
	
	@Test
	void quandoCriarFilhoComCaracteristicaNullEntaoErroValidacaoDeveSerChamadoComMensagemCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);			
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn(null);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);


		while(engine.isExecutando())
			engine.realizarAcao();

		verify(viewJoguinhoMock, times(1)).erroValidacao("Não foi possivel criar filho: Característica deve ser informada!");
	}

	@Test
	void quandoCriarFilhoComCaracteristicaVaziaEntaoErroValidacaoDeveSerChamadoComMensagemCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);			
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn("");
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();

		verify(viewJoguinhoMock, times(1)).erroValidacao("Não foi possivel criar filho: Característica deve ser informada!");
	}
	
	@Test
	void cenarioHappyDayMenorCaminho() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);			
			
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();
		
		verify(viewJoguinhoMock, times(1)).parabenizar();
	}
	
	@Test
	void cenarioHappyDayMenorCaminhoDeveTerPerguntandoDuasVezes() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		when(viewJoguinhoMock.jogarNovamente()).thenReturn(false);			
			
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		while(engine.isExecutando())
			engine.realizarAcao();
		
		verify(viewJoguinhoMock, times(2)).perguntar(anyString());
	}

	@Test
	void quandoRealizarPerguntaEntaoDevePossuirDescricaoCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);
	
		engine.realizarAcao();
		
		verify(viewJoguinhoMock).perguntar("Está pensando em algo que é um(a) massa?");
	}
}
