package com.eduardoshibukawa.joguinhogourmet.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho.Acao;
import com.eduardoshibukawa.joguinhogourmet.domain.exception.CaracteristicaObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.domain.exception.EntidadeObrigatoriaException;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

@ExtendWith(MockitoExtension.class)
class EngineJoguinhoTest {

	@Mock
	ViewJoguinho viewJoguinhoMock;

	@Mock
	NoCaracteristica noPerguntaMock;

	@Test
	void quandoPerguntarEntaoViewPerguntarDeveSerChamada() {
		when(noPerguntaMock.getPergunta()).thenReturn("Está pensando em uma massa?");
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);
		engine.perguntar();

		verify(viewJoguinhoMock).perguntar(anyString());
	}

	@Test
	void quandoBuscarProximaAcaoEntaoMetodoIsFilhoExistenteDeveSerChamado() {
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(true);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.getProximaAcao();

		verify(noPerguntaMock, times(1)).isFilhoExistente(anyBoolean());
	}

	@Test
	void quandoCumprimentarEntaoMetodoCumprimentarDeveSerChamado() {
		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.cumprimentar();

		verify(viewJoguinhoMock, times(1)).cumprimentar();
	}

	@Test
	void quandoParabenizarEntaoMetodoParabenizarDeveSerChamado() {
		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.parabenizar();

		verify(viewJoguinhoMock, times(1)).parabenizar();
	}

	@Test
	void quandoPerguntarSeDesejaJogarNovamenteEntaoMetodoDesejaJogarNovamenteDeveSerChamado() {
		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.desejaJogarNovamente();

		verify(viewJoguinhoMock, times(1)).jogarNovamente();
	}

	@Test
	void quandoErroValidacaoEntaoMetodoErroValidacaoDeveSerChamado() {
		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.erroValidacao("Erro");

		verify(viewJoguinhoMock, times(1)).erroValidacao("Erro");
	}

	@Test
	void quandoCriarFilhoEntaoMetodoPerguntaNovaCaracteristicaEntidadeDeveSerChamado() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn("Azedo");
		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();
		engine.criarFilho();

		verify(viewJoguinhoMock, times(1)).perguntarNovaEntidade();
		verify(viewJoguinhoMock, times(1)).perguntarNovaCaracteristica(anyString(), anyString());
	}

	@Test
	void quandoCriarFilhoComEntidadeNullEntaoDeveOcorrerErroEntidadeObrigatoriaException() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn(null);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();

		assertThrows(EntidadeObrigatoriaException.class, () -> {
			engine.criarFilho();
		});
	}

	@Test
	void quandoCriarFilhoComEntidadeVaziaEntaoDeveOcorrerErroEntidadeObrigatoriaException() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("");
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();

		assertThrows(EntidadeObrigatoriaException.class, () -> {
			engine.criarFilho();
		});
	}
	
	@Test
	void quandoCriarFilhoComCaracteristicaNullEntaoDeveOcorrerErroCaracteristicaObrigatoriaException() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn(null);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();

		assertThrows(CaracteristicaObrigatoriaException.class, () -> {
			engine.criarFilho();
		});
	}

	@Test
	void quandoCriarFilhoComCaracteristicaVaziaEntaoDeveOcorrerErroCaracteristicaObrigatoriaException() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntarNovaEntidade()).thenReturn("Limão");
		when(viewJoguinhoMock.perguntarNovaCaracteristica(anyString(), anyString())).thenReturn("");
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();

		assertThrows(CaracteristicaObrigatoriaException.class, () -> {
			engine.criarFilho();
		});
	}
	
	@Test
	void proximaAcaoDeveSerAvancarCasoPossuirFilho() {
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(true);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		Acao acao = engine.getProximaAcao();

		assertEquals(Acao.AVANCAR, acao, "Ação deve ser avançar sempre que nó possuir filhos!");
	}

	@Test
	void quandoNaoPossuirFilhoRetornoPerguntarSimEntaoProximaAcaoDeveSerParabenizar() {
		when(noPerguntaMock.getPergunta()).thenReturn("É um bolo ?");
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(false);
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.perguntar();
		Acao acao = engine.getProximaAcao();

		assertEquals(Acao.PARABENIZAR, acao, "Ação deve ser avançar sempre que nó possuir filhos!");
	}

	@Test
	void quandoNaoPossuirFilhoRetornoPerguntarNaoEntaoProximaAcaoDeveSerCriarFilho() {
		when(noPerguntaMock.getPergunta()).thenReturn("É um bolo ?");
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(false);
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		engine.perguntar();
		Acao acao = engine.getProximaAcao();

		assertEquals(Acao.CRIAR_FILHO, acao, "Ação deve ser avançar sempre que nó possuir filhos!");
	}

	@Test
	void quandoPossuirFilhoEntaoProximaAcaoDeveSerAvancarIndependenteRetornoPerguntar() {
		when(noPerguntaMock.isFilhoExistente(anyBoolean())).thenReturn(true);
		when(noPerguntaMock.getPergunta()).thenReturn("Está pensando em algo que é um(a) massa?");
		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(false, true);

		EngineJoguinho engine = new EngineJoguinho(noPerguntaMock, viewJoguinhoMock);

		IntStream.range(1, 2).forEach(n -> {
			engine.perguntar();
			Acao acao = engine.getProximaAcao();

			assertEquals(Acao.AVANCAR, acao, "Ação deve ser avançar sempre que nó possuir filhos!");
		});
	}

	@Test
	void cenarioHappyDayMenorCaminho() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.perguntar();
		engine.avancar();
		
		Acao acao = engine.getProximaAcao();

		assertEquals(Acao.PARABENIZAR, acao, "Ação deve ser parabenizar para o cenario Happy Day de menor caminho!");
	}

	@Test
	void quandoRealizarPerguntaEntaoDevePossuirDescricaoCorreta() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));

		when(viewJoguinhoMock.perguntar(anyString())).thenReturn(true);
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.perguntar();
		
		verify(viewJoguinhoMock).perguntar("Está pensando em algo que é um(a) massa?");
	}
	
	@Test
	void aposIniciarJogoProximaAcaoDeveSerAvancar() {
		NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		
		EngineJoguinho engine = new EngineJoguinho(noRaiz, viewJoguinhoMock);

		engine.avancar();
		engine.iniciar();

		Acao acao = engine.getProximaAcao();

		assertEquals(Acao.AVANCAR, acao, "Ação deve ser avançar ao inicializar um jogo!");
	}
}
