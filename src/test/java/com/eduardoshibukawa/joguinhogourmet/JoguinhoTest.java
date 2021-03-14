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
import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho.Acao;
import com.eduardoshibukawa.joguinhogourmet.view.ViewJoguinho;

@ExtendWith(MockitoExtension.class)
class JoguinhoTest {

	@Mock
	EngineJoguinho engineJoguinhoMock;

	@Test
	void quandoExecutarJogoEntaoCumprimentoDeveSerChamado() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).cumprimentar();
	}

	@Test
	void quandoExecutarJogoEntaoPerguntarDeveSerChamadaPeloMenosUmaVez() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).perguntar();
	}

	@Test
	void quandoExecutarJogoPossuirDuasAcoesEntaoPerguntarDeveSerChamadoDuasVez() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(2)).perguntar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarEntaoParabenizarDeveSerChamadaApenasUmaVez() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.CRIAR_FILHO, Acao.AVANCAR,
				Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).parabenizar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarNaQuintaIteracaoEntaoParabenizarDeveSerChamadaCincoVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(true, true, true, true, false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(5)).parabenizar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarEntaoDesejaJogarNovamenteDeveSerChamadoUmaVez() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).desejaJogarNovamente();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarNaQuintaIteracaoEntaoDesejaJogarNovamenteDeveSerChamadaCincoVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(true, true, true, true, false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(5)).desejaJogarNovamente();
	}

	@Test
	void quandoExecutarJogoCriandoFilhoUmaVezEntaoCriarFilhoDeveSerChamadaUmaVez() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.CRIAR_FILHO, Acao.AVANCAR, Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).criarFilho();
	}

	@Test
	void quandoExecutarJogoCriandoFilhoDuasVezesEntaoCriarFilhoDeveSerChamadaDuasVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.CRIAR_FILHO, Acao.AVANCAR, Acao.PARABENIZAR,
				Acao.CRIAR_FILHO, Acao.AVANCAR, Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(true, false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(2)).criarFilho();
	}

	@Test
	void quandoExecutarJogoComAcaoAvancarEntaoAvancarDeveSerChamado() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).avancar();
	}

	@Test
	void quandoExecutarJogoComAcaoAvancarDuasVezesEntaoAvancarDeveSerChamadoDuasVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.AVANCAR, Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(2)).avancar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarEntaoIniciarNãoDeveSerChamado() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(0)).iniciar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarNaSegundaIteracaoEntaoIniciarDeveSerChamadoUmaVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(true, false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).iniciar();
	}

	@Test
	void quandoExecutarJogoDesejandoFinalizarNaQuintaIteracaoEntaoIniciarDeveSerChamadoQuatroVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(true, true, true, true, false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(4)).iniciar();
	}
	
	@Test
	void quandoAcertarRespostaEntaoDeveParabenizar() {
		final ViewJoguinho viewMock = mock(ViewJoguinho.class);
		final NoCaracteristica noRaiz = new NoCaracteristica("Massa", new NoEntidade("Lasanha"), new NoEntidade("Bolo"));
		final EngineJoguinho engine = new EngineJoguinho(noRaiz, viewMock);
		final Joguinho joguinho = new Joguinho(engine);
		
		when(viewMock.perguntar(anyString())).thenReturn(true);
		
		joguinho.executar();
		
		verify(viewMock, times(1)).parabenizar();
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
}