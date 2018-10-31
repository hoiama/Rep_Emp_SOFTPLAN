package test.java.br.softplan.hoiama.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collections;
import main.java.br.softplan.hoiama.generator.GeradorObservacaoRefatorado;
import org.junit.Before;
import org.junit.Test;


public class GeradorObservacaoTestRefatorado {

	private GeradorObservacaoRefatorado geradorObservacao;

	@Before
	public void setUp() {
		geradorObservacao = new GeradorObservacaoRefatorado();
	}

	@Test
	public void geraObservacaoVaziaQuandoNaoExistemNotas() {
		String observacaoGerada = this.geradorObservacao.gerarObservacao(Collections.EMPTY_LIST);
		assertTrue(observacaoGerada.isEmpty());
	}

	@Test
	public void geraObservacaoParaUmaNota() {
		String observacaoGerada = this.geradorObservacao.gerarObservacao(Arrays.asList(1));

		String observacaoEsperada = "Fatura da nota fiscal de simples remessa: 1.";
		assertEquals(observacaoEsperada, observacaoGerada);
	}

	@Test
	public void geraObservacaoParaDuasNotas() {
		String observacaoGerada = this.geradorObservacao.gerarObservacao(Arrays.asList(1, 2));

		String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 1 e 2.";
		assertEquals(observacaoEsperada, observacaoGerada);
	}

	@Test
	public void geraObservacaoParaMultiplasNotas() {
		String observacaoGerada = this.geradorObservacao.gerarObservacao(Arrays.asList(1, 2, 3, 4, 5));

		String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";
		assertEquals(observacaoEsperada, observacaoGerada);
	}
}
