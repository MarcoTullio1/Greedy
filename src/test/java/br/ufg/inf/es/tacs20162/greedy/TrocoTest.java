package br.ufg.inf.es.tacs20162.greedy;

import org.junit.Test;
import static org.junit.Assert.*;

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

        //String expResult = "";
        String result = Troco.calculaTroco(conta, pago);
        //assertEquals(expResult, result);
        System.out.println(result);
    }
}
