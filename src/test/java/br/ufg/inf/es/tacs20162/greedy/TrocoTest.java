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

        System.out.println("===================================\n"
        				 + "Problema do Troco com solução ótima\n"
        				 + "===================================\n");

        double conta = 24.00; // conta a ser paga
        double pago = 50.00; // dinheiro pago pelo cliente
        int[] notasDisponiveis = {1, 2, 5, 10, 20}; // reais
        int[] moedasDisponiveis = {5, 10, 25, 50, 100}; // centavos

        Troco expResult = new Troco();
        expResult.troco = 26.00;   // Troco de R$ 26,00 
        expResult.notas.put(20, 1);// 1 nota de R$ 20,00
        expResult.notas.put(5, 1); // 1 nota de R$ 5,00
        expResult.notas.put(1, 1); // 1 nota de R$ 1,00
        // troco sem moedas
        System.out.println("Expected output:\n"
        				 + "----------------\n");
        System.out.println(expResult.toString());

        Troco result = ProblemaDoTroco.calculaTroco(notasDisponiveis, moedasDisponiveis, conta, pago);
        System.out.println("Output:\n"
        				 + "-------\n");
        System.out.println(result.toString() + "\n");

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Caso de teste do algoritmo do Problema do Troco que NÃO dá uma solução ótima.
     */
    @Test
    public void testCalculaTroco() {

        System.out.println("=================\n"
        				 + "Problema do Troco\n"
        				 + "=================\n");

        double conta = 12.00; // conta a ser paga
        double pago = 20.00; // dinheiro pago pelo cliente
        int[] notasDisponiveis = {1, 4, 6}; // reais
        int[] moedasDisponiveis = {5, 10, 25, 50, 100}; // centavos

        Troco expResult = new Troco();
        expResult.troco = 8.00;   // Troco de R$ 8,00 
        expResult.notas.put(4, 2); // 2 notas de R$ 4,00
        System.out.println("Expected output:\n"
				 + "----------------\n");
        System.out.println(expResult.toString());

        Troco result = ProblemaDoTroco.calculaTroco(notasDisponiveis, moedasDisponiveis, conta, pago);
        System.out.println("Output:\n"
				 + "-------\n");
        System.out.println(result.toString() + "\n");

        assertEquals(expResult.toString(), result.toString());
    }
}
