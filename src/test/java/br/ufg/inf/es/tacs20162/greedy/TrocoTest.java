package br.ufg.inf.es.tacs20162.greedy;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 *
 * @author gustavosotnas
 */
public class TrocoTest {

    /**
     * Caso de teste do algoritmo do Problema do Troco que dá uma solução ótima.
     */
/*    @Test
    public void testCalculaTrocoOtimo() {

        System.out.println("Problema do Troco com solução ótima");

        double conta = 24.00; // conta a ser paga
        double pago = 50.00; // dinheiro pago pelo cliente

        //String expResult = "";
        String result = ProblemaDoTroco.calculaTroco(conta, pago);
        //assertEquals(expResult, result);
        System.out.println(result);
    }*/

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
