package br.ufg.inf.es.tacs20162.greedy;

import org.junit.Test;
import static org.junit.Assert.*;

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
     * Caso de teste do algoritmo do Problema do Troco que NÃO dá uma solução ótima,
     * o teste "falha" propositalmente.
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

    /**
     * Caso de teste do algoritmo do Problema do Troco com moedas (solução ótima)
     */
    @Test
    public void testCalculaTrocoMoedasOtimo() {

        System.out.println("================================================\n"
        				 + "Problema do Troco (com moedas) com solução ótima\n"
        				 + "================================================\n");

        double conta = 27.25; // conta a ser paga
        double pago = 50.00; // dinheiro pago pelo cliente
        int[] notasDisponiveis = {1, 2, 5, 10, 50}; // reais
        int[] moedasDisponiveis = {5, 10, 50, 100}; // centavos

        Troco expResult = new Troco(); // Resultado esperado:
        expResult.troco = 22.75;   // Troco de R$ 22,75
        expResult.notas.put(10, 2);// 2 nota de R$ 10,00
        expResult.notas.put(2, 1); // 1 nota de R$ 2,00
        expResult.moedas.put(50, 1);//1 moeda de R$ 0,50
        expResult.moedas.put(10, 2);//2 moeda de R$ 0,10
        expResult.moedas.put(5, 1); //1 moeda de R$ 0,05
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
     * Caso de teste do algoritmo do Problema do Troco com moedas que NÃO dá uma
     * solução ótima, o teste "falha" propositalmente.
     */
    @Test
    public void testCalculaTrocoMoedas() {

        System.out.println("==============================\n"
				         + "Problema do Troco (com moedas)\n"
				         + "==============================\n");

        double conta = 11.88; // conta a ser paga
        double pago = 20.00; // dinheiro pago pelo cliente
        int[] notasDisponiveis = {1, 4, 6}; // reais
        int[] moedasDisponiveis = {1, 5, 6, 7}; // centavos

        Troco expResult = new Troco(); // Resultado esperado:
        expResult.troco = 8.12;    // Troco de R$ 8,36
        expResult.notas.put(4, 2); // 2 notas de R$ 4,00
        expResult.moedas.put(6, 2);// 2 moedas de R$0,06
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
