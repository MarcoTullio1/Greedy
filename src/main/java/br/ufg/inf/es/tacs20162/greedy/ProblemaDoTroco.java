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
     * cédulas possível. Obs.: Algoritmo guloso, haverá casos em que a menor
     * quantidade dada pelo código não será a ideal (a solução ótima).
     *
     * @param conta a conta a ser paga pelo cliente
     * @param pago a quantia que o cliente pagou pela conta
     * @return um texto explicando quais e quantas notas devem ser dadas para o
     * cliente receber seu troco
     * @throws IllegalArgumentException quando o cliente dá menos dinheiro que
     * deveria
     */
    public static String calculaTroco(double conta, double pago) throws IllegalArgumentException {

        DecimalFormat formatador = new DecimalFormat("###,##0.00");

        if (pago >= conta) {

            String resultado;
            double troco;

            troco = pago - conta;
            resultado = "\nTroco = R$" + formatador.format(troco) + "\n\n";

            resultado = calculaNotas(troco, resultado);
            resultado = calculaMoedas(troco, resultado);

            resultado = resultado + "\n";

            return resultado;
        } else {
            throw new IllegalArgumentException("Pagamento insuficiente, faltam "
                    + "R$" + formatador.format(conta - pago) + "\n");
        }
    }

    private static String calculaNotas(final double troco, String resultado) {

        int nota[] = {100, 50, 20, 10, 5, 2, 1};

        int valor;
        int ct;

        int contadorNota = 0;

        valor = (int) troco;
        while (valor != 0) {
            ct = valor / nota[contadorNota]; // calculando a qtde de notas
            if (ct != 0) {
                resultado = resultado + (ct + " nota(s) de R$" + nota[contadorNota] + "\n");
                valor = valor % nota[contadorNota]; // sobra
            }
            contadorNota++; // próxima nota
        }
        return resultado;
    }

    private static String calculaMoedas(final double troco, String resultado) {

        int centavos[] = {50, 25, 10, 5, 1};

        int contadorMoeda = 0;
        int valor;
        int ct;

        valor = (int) Math.round((troco - (int) troco) * 100);
        while (valor != 0) {
            ct = valor / centavos[contadorMoeda]; // calculando a qtde de moedas
            if (ct != 0) {
                resultado = resultado + (ct + " moeda(s) de" + centavos[contadorMoeda] + "centavo(s)\n");
                valor = valor % centavos[contadorMoeda]; // sobra
            }
            contadorMoeda++; // próximo centavo
        }
        return resultado;
    }

}