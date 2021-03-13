package com.eduardoshibukawa.joguinhogourmet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho;
import com.eduardoshibukawa.joguinhogourmet.domain.EngineJoguinho.Acao;

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
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.CRIAR_FILHO,
				Acao.AVANCAR, Acao.PARABENIZAR);
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
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.CRIAR_FILHO, Acao.AVANCAR,
				Acao.PARABENIZAR);
		when(engineJoguinhoMock.desejaJogarNovamente()).thenReturn(false);

		Joguinho joguinho = new Joguinho(engineJoguinhoMock);
		joguinho.executar();

		verify(engineJoguinhoMock, times(1)).criarFilho();
	}

	@Test
	void quandoExecutarJogoCriandoFilhoDuasVezesEntaoCriarFilhoDeveSerChamadaDuasVezes() {
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.CRIAR_FILHO, Acao.AVANCAR,
				Acao.PARABENIZAR, Acao.CRIAR_FILHO, Acao.AVANCAR, Acao.PARABENIZAR);
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
		when(engineJoguinhoMock.getProximaAcao()).thenReturn(Acao.AVANCAR, Acao.AVANCAR,
				Acao.PARABENIZAR);
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
}