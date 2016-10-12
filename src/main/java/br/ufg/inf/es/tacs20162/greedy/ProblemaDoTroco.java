package br.ufg.inf.es.tacs20162.greedy;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author gustavosotnas
 */
public class ProblemaDoTroco {

	/**
	 * Estrutura de dados ("struct") que armazena as informações sobre o troco
	 * a ser devolvido.
	 */
	public static class Troco {

		/** Valor a ser devolvido de troco. */
		public double troco;

		/** A forma de distribuição de células que será entregue de troco:
		 * <"valor das cédulas", "quantidade de cédulas daquele valor">*/
		public HashMap<Integer, Integer> notas = new HashMap<Integer, Integer>();

		/** A forma de distribuição de moedas que será entregue de troco:
		 * <"valor das moedas", "quantidade de moedas daquele valor">*/
		public HashMap<Integer, Integer> moedas = new HashMap<Integer, Integer>();
	}

	/**
     * Calcula o troco a ser dado para um cliente com a menor quantidade de
     * cédulas possível, dada uma quantidade infinita de notas e moedas de
     * determinados valores, passado pelo usuário.
     * 
     * Obs.: Algoritmo guloso, haverá casos em que a menor
     * quantidade dada pelo código não será a ideal (a solução ótima).
     * 
	 * @param notasDisponiveis que valores de notas existem no caixa para
	 * fazer troco
	 * @param moedasDisponiveis que valores de moedas existem no caixa para
	 * fazer troco
	 * @param conta a quantia a ser paga pelo cliente
	 * @param pago a quantia que o cliente pagou pela conta
	 * @return a quantia a ser dada de troco, com informação de quantas notas e
	 * moedas de cada valor devem ser dadas para o cliente receber seu troco
	 * @throws IllegalArgumentException quando o cliente dá menos dinheiro que
     * deveria
	 */
    public static Troco calculaTroco(int[] notasDisponiveis, int[] moedasDisponiveis,
    		double conta, double pago) throws IllegalArgumentException {

    	Troco resultado = new Troco();

        if (pago >= conta) {

            resultado.troco = pago - conta;

            resultado.notas = calculaNotas(notasDisponiveis, resultado.troco);
            resultado.moedas = calculaMoedas(moedasDisponiveis, resultado.troco);

            return resultado;

        } else {
        	DecimalFormat formatador = new DecimalFormat("###,##0.00");
            throw new IllegalArgumentException("Pagamento insuficiente, faltam "
                    + "R$" + formatador.format(conta - pago) + "\n");
        }
    }

    private static HashMap<Integer, Integer> calculaNotas (int[] notasDisponiveis, double troco) {

        notasDisponiveis = sortReverse(notasDisponiveis);

        int valor;
        int qtdNotasNecessarias;

        int contadorNota = 0;

        HashMap<Integer, Integer> resultado = new HashMap<Integer, Integer>();

        valor = (int) troco;
        while (valor != 0) {
            qtdNotasNecessarias = valor / notasDisponiveis[contadorNota];
            if (qtdNotasNecessarias != 0) {
                resultado.put(notasDisponiveis[contadorNota], qtdNotasNecessarias); 
                valor = valor % notasDisponiveis[contadorNota]; // sobra
            }
            contadorNota++; // próxima nota
        }
        return resultado;
    }

    private static HashMap<Integer, Integer> calculaMoedas (int[] moedasDisponiveis, double troco) {

    	moedasDisponiveis = sortReverse(moedasDisponiveis);

        int valor;
        int qtdMoedasNecessarias;

        int contadorMoeda = 0;

        HashMap<Integer, Integer> resultado = new HashMap<Integer, Integer>();

        valor = (int) Math.round((troco - (int) troco) * 100);
        while (valor != 0) {
            qtdMoedasNecessarias = valor / moedasDisponiveis[contadorMoeda];
            if (qtdMoedasNecessarias != 0) {
            	resultado.put(moedasDisponiveis[contadorMoeda], qtdMoedasNecessarias);
                valor = valor % moedasDisponiveis[contadorMoeda]; // sobra
            }
            contadorMoeda++; // próxima moeda
        }
        return resultado;
    }

	/**
	 * Ordena um vetor de números inteiros qualquer na ordem decrescente.
	 * 
	 * Código baseado em: http://stackoverflow.com/a/3523066
	 * 
	 * @param vector o vetor desordenado.
	 * @return o vetor ordenado decrescentemente.
	 */
    static int[] sortReverse(int[] vector) {

    	java.util.Arrays.sort(vector); // sort

        int left = 0;
        int right = vector.length - 1;

        while (left < right) {
            // swap the values at the left and right indices
            int temp = vector[left];
            vector[left] = vector[right];
            vector[right] = temp;

            // move the left and right index pointers in toward the center
            left++;
            right--;
        }
        return vector;
    }
}
