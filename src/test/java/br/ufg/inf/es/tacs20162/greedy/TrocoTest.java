package br.ufg.inf.es.tacs20162.greedy;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

import br.ufg.inf.es.tacs20162.greedy.ProblemaDoTroco.Troco;

/**
 *
 * @author gustavosotnas
 */
public class TrocoTest {

    /**
     * Caso de teste do algoritmo do Problema do Troco que dá uma solução ótima.
     */
    @Test
    public void testCalculaTrocoOtimo() {

        System.out.println("Problema do Troco com solução ótima");

        double conta = 24.00; // conta a ser paga
        double pago = 50.00; // dinheiro pago pelo cliente
        int[] notasDisponiveis = {1, 2, 5, 10, 20}; // reais
        int[] moedasDisponiveis = {5, 10, 25, 50, 100}; // centavos

        Troco expResult = new Troco();
        expResult.troco = 26.00;   // Troco de R$ 26,00 
        expResult.notas.put(20, 1);// 1 nota de R$ 20,00
        expResult.notas.put(5, 1); // 1 nota de R$ 5,00
        expResult.notas.put(1, 1); // 1 nota de R$ 1,00
        expResult.moedas.put(100, 0);
        expResult.moedas.put(50, 0);
        expResult.moedas.put(25, 0);
        expResult.moedas.put(10, 0);
        expResult.moedas.put(5, 0); // troco sem moedas

        Troco result = ProblemaDoTroco.calculaTroco(notasDisponiveis, moedasDisponiveis, conta, pago);
        assertEquals(expResult, result);
    }

	/**
	 * Teste da função ProblemaDoTroco.sortReverse(int[] vector)
	 */
	@Test
	public void testSortReverse() {
		System.out.println("Ordena Vetor\n");

		int[] input = {20, 50, 1, 100, 2, 5, 10};
		int[] expOutput = {100, 50, 20, 10, 5, 2, 1}; 
		System.out.println("Expected output: " + Arrays.toString(expOutput));

		int[] output = ProblemaDoTroco.sortReverse(input);
		System.out.println("Output:          " + Arrays.toString(output));		

		assertArrayEquals(expOutput, output);
	}
}
