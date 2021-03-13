package com.eduardoshibukawa.joguinhogourmet.view;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JoguinhoViewTest {

	@Mock
	ViewCumprimentoInicial viewCumprimentoInicialMock;

	@Mock
	ViewPergunta viewPerguntaMock;

	@Mock
	ViewPerguntaNovaEntidade viewPerguntaNovaEntidadeMock;

	@Mock
	ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristicaMock;

	@Mock
	ViewPerguntaJogarNovamente viewPerguntaJogarNovamenteMock;

	@Mock
	ViewParabenizar viewParabenizarMock;

	@Test
	void quandoExecutarIniciarNoJoguinhoViewEntaoViewInicioDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.cumprimentar();

		verify(viewCumprimentoInicialMock, times(1)).executar();
	}

	@Test
	void quandoExecutarFinalizarNoJoguinhoViewEntaoViewFinalizarDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.jogarNovamente();

		verify(viewPerguntaJogarNovamenteMock, times(1)).executar();
	}
	
	@Test
	void quandoExecutarPerguntarNoJoguinhoViewEntaoViewPerguntaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.perguntar(anyString());

		verify(viewPerguntaMock, times(1)).executar(anyString());
	}

	@Test
	void quandoExecutarPerguntarNovaEntidadeNoJoguinhoViewEntaoViewPerguntaNovaEntidadeDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.perguntarNovaEntidade();

		verify(viewPerguntaNovaEntidadeMock, times(1)).executar();
	}
	
	@Test
	void quandoExecutarPerguntarNovaCaracteristicaNoJoguinhoViewEntaoViewPerguntaNovaCaracteristicaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.perguntarNovaCaracteristica(anyString(), anyString());

		verify(viewPerguntaNovaCaracteristicaMock, times(1)).executar(anyString(), anyString());
	}
	
	@Test
	void quandoExecutarPerguntaNoJoguinhoViewEntaoViewPerguntaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = new ViewJoguinho(viewCumprimentoInicialMock, viewPerguntaMock, viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, viewPerguntaJogarNovamenteMock, viewParabenizarMock);
		
		joguinhoView.parabenizar();

		verify(viewParabenizarMock, times(1)).executar();
	}	
}
