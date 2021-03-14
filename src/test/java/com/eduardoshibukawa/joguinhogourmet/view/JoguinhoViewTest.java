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

	@Mock
	ViewErroValidacao viewErroValidacaoMock;

	@Test
	void quandoExecutarIniciarNoJoguinhoViewEntaoViewInicioDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.cumprimentar();

		verify(viewCumprimentoInicialMock, times(1)).executar();
	}

	@Test
	void quandoExecutarFinalizarNoJoguinhoViewEntaoViewFinalizarDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.jogarNovamente();

		verify(viewPerguntaJogarNovamenteMock, times(1)).executar();
	}

	@Test
	void quandoExecutarPerguntarNoJoguinhoViewEntaoViewPerguntaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.perguntar(anyString());

		verify(viewPerguntaMock, times(1)).executar(anyString());
	}

	@Test
	void quandoExecutarPerguntarNovaEntidadeNoJoguinhoViewEntaoViewPerguntaNovaEntidadeDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.perguntarNovaEntidade();

		verify(viewPerguntaNovaEntidadeMock, times(1)).executar();
	}

	@Test
	void quandoExecutarPerguntarNovaCaracteristicaNoJoguinhoViewEntaoViewPerguntaNovaCaracteristicaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.perguntarNovaCaracteristica(anyString(), anyString());

		verify(viewPerguntaNovaCaracteristicaMock, times(1)).executar(anyString(), anyString());
	}

	@Test
	void quandoExecutarPerguntaNoJoguinhoViewEntaoViewPerguntaDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();

		joguinhoView.parabenizar();

		verify(viewParabenizarMock, times(1)).executar();
	}
	
	@Test
	void quandoExecutarErroNoJoguinhoViewEntaoViewErroDeveTerSidoChamada() {
		ViewJoguinho joguinhoView = createMockedView();
		
		joguinhoView.erroValidacao("Erro");
		
		verify(viewErroValidacaoMock, times(1)).executar("Erro");
	}

	private ViewJoguinho createMockedView() {
		return new ViewJoguinhoTest(
				viewCumprimentoInicialMock, 
				viewPerguntaMock, 
				viewPerguntaNovaEntidadeMock,
				viewPerguntaNovaCaracteristicaMock, 
				viewPerguntaJogarNovamenteMock, 
				viewParabenizarMock,
				viewErroValidacaoMock
		);
	}
	
	private class ViewJoguinhoTest extends ViewJoguinho {

		public ViewJoguinhoTest(
				ViewCumprimentoInicial viewCumprimentoInicial, 
				ViewPergunta viewPergunta,
				ViewPerguntaNovaEntidade viewPerguntaNovaEntidade,
				ViewPerguntaNovaCaracteristica viewPerguntaNovaCaracteristica,
				ViewPerguntaJogarNovamente viewPerguntaJogarNovamente, 
				ViewParabenizar viewParabenizar,
				ViewErroValidacao viewErroValidacao) {
			super(
				viewCumprimentoInicial, 
				viewPergunta, 
				viewPerguntaNovaEntidade, 
				viewPerguntaNovaCaracteristica,
				viewPerguntaJogarNovamente, 
				viewParabenizar,
				viewErroValidacao
			);
		}
	}
}
