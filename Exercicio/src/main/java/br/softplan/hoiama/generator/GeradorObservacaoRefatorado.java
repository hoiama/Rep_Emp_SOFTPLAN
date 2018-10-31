package main.java.br.softplan.hoiama.generator;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacaoRefatorado {

	/**
	 * Organizei as variaveis separadas dos métodos para reutilização, modifiquei a nomeclaruta dos atributos e métodos da classe..
	 */
	private StringBuilder stringBuilder = new StringBuilder();
	private static final String mensagemFaturaSimples = "Fatura da nota fiscal de simples remessa: ";
	private static final String mensagemFaturaMultipla = "Fatura das notas fiscais de simples remessa: ";
	private String mensagemFatura;


	/**
	 * Gerar observaçẽes com texto pre-definido, incluindo os números das notas fiscais, recebidos no parâmetro.
	 * Usei o retorno do método para encadear  o "." no StringBuilder retornado.
	 */
	public String gerarObservacao(List lista){
		if (! lista.isEmpty()) {
			return retornaCodigos(lista).append(".").toString();
		}		
		return "";
	}


	/**
	 * Cria observação separando por virgula.
	 * Uso dos atributos da claase no ligar de atributo de método.
	 * Delimitação da List<Integer>
	 * Uso de StringBuilder emcadeado para "concatenar" os separadores nos itens da lista.
	 * Inviável uso de Stream() do java8 em vista da complexidade do laço.
	 *
	 */
	private StringBuilder retornaCodigos(List<Integer> lista) {

		if (lista.size() >= 2) {
			this.mensagemFatura = this.mensagemFaturaMultipla;
		} else {
			this.mensagemFatura = this.mensagemFaturaSimples;
		}

		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer itemList = iterator.next();
			String separator = "";

			if(stringBuilder.toString().length() <= 0 )
				separator =  "";
			else if(iterator.hasNext())
				separator =  ", ";
			else{
				separator =  " e ";
			}

			this.stringBuilder.append(separator).append(itemList);
		}

		return stringBuilder.insert(0, mensagemFatura);
	}

}