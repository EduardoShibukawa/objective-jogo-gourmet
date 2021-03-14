package com.eduardoshibukawa.joguinhogourmet;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.NoCaracteristica;
import com.eduardoshibukawa.joguinhogourmet.domain.NoEntidade;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

@ExtendWith(MockitoExtension.class)
class JoguinhoTest {

	@Mock
	EngineJoguinho engineJoguinhoMock;

	@Test
	void quandoExecutarJogoEntaoCumprimentoDeveSerChamado() {
		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).cumprimentar();
	}

	@Test
	void quandoPerguntarRetornarVerdadeiroEntaoDeveRetornarNoVerdadeiro() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(true);
		
		joguinho.executar();
		
		verify(viewMock, times(1)).perguntar("O que você está pensando é um(a) lasanha?");
	}

			
	@Test
	void quandoPerguntarRetornarFalsoEntaoDeveRetornarNoFalso() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, true);
		
		joguinho.executar();
		
		verify(viewMock, times(1)).perguntar("O que você está pensando é um(a) bolo?");
	}
	
	@Test
	void quandoJogoCriarFilhoEntaoPerguntaNovaEntidadeDeveSerChamada() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewMock.perguntarNovaCaracteristica("Bolo", "Limão")).thenReturn("Fruta");
		
		
		joguinho.executar();

		verify(viewMock, times(1)).perguntarNovaEntidade();
	}

	@Test
	void quandoJogoCriarFilhoEntaoPerguntaNovaCaracteristicaDeveSerChamada() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewMock.perguntarNovaCaracteristica("Bolo", "Limão")).thenReturn("Fruta");
		
		
		joguinho.executar();

		verify(viewMock, times(1)).perguntarNovaEntidade();
	}
	
	@Test
	void quandoJogoCriarFilhoEntaoDeveExistirNaProximaIteracaoDoJogo() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewMock.perguntarNovaCaracteristica("Bolo", "Limão")).thenReturn("Fruta");
		
		
		joguinho.executar();

		verify(viewMock, times(1)).perguntar("O que você está pensando é um(a) limão?");
		verify(viewMock, times(1)).parabenizar();
	}
	
	@Test
	void quandoJogoCriarFilhoSemEntidadeEntaoDeveMostrarErroValidacao() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("");
		
		joguinho.executar();

		verify(viewMock, times(1)).erroValidacao(anyString());
	}

	@Test
	void quandoJogoCriarFilhoSemEntidadeEntaoDeveMostrarErroValidacaoComMensagemCorreta() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("");
		
		joguinho.executar();

		verify(viewMock, times(1)).erroValidacao("Não foi possivel criar filho: Entidade deve ser informada!");
	}

	@Test
	void quandoJogoCriarFilhoSemCaracteristicaEntaoDeveMostrarErroValidacao() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewMock.perguntarNovaCaracteristica("Bolo", "Limão")).thenReturn("");
		
		joguinho.executar();

		
		verify(viewMock, times(1)).erroValidacao(anyString());
	}
	
	@Test
	void quandoJogoCriarFilhoSemCaracteristicaEntaoDeveMostrarErroValidacaoComMensagemCorreta() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(false, false, true);
		when(viewMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewMock.perguntarNovaCaracteristica("Bolo", "Limão")).thenReturn("");
		
		joguinho.executar();

		verify(viewMock, times(1)).erroValidacao("Não foi possivel criar filho: Característica deve ser informada!");
	}	
	
	@Test
	void quandoJogarDuasVezesEntaoUsuarioDeveTerSidoParabenizadoDuasVezes() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(true);
		when(viewMock.jogarNovamente()).thenReturn(true, false);
		
		joguinho.executar();
		
		verify(viewMock, times(2)).parabenizar();
	}		
}