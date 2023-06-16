/*
1. Crie um programa que trate colisão de forma externa para nome entre 3 e 8 caracteres
    adicionar nomes
    excluir nomes
    buscar se nome existe

2. Colisão dividida

3. Colisão sequencial

 */
package hash;

import hash.colisaoTratamento.encadeado.InternoHeterogeneo;

import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
        InternoHeterogeneo heterogeneo = new InternoHeterogeneo(10, 5);
        heterogeneo.inserir(5);
        heterogeneo.inserir(8);
        heterogeneo.inserir(20);
        System.out.println(heterogeneo);
        System.out.println(heterogeneo.buscar(20));
    }
}
