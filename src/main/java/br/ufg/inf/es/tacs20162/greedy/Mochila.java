package br.ufg.inf.es.tacs20162.greedy;

public class Mochila{
      public int[] verificarMochila(int[] vetor, qntNumeros, capacidade){
          int[] mochila = new int[];
          int j = 1;

          while(j <= qntNumeros && vetor[j] <= capacidade){
              mochila[j] = 1;
              capacidade = capacidade - vetor[j];
              j = j - 1;
          }

          if(j <= qntNumeros){

            mochila[j] = capacidade/vetor[j];
          }
          for(int k = j+1; k < qntNumeros; k++){
            mochila[k] = 0;
          }

          return mochila;
      }

}
