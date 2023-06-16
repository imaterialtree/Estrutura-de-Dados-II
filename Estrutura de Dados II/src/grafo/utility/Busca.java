package grafo.utility;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Stack;

public class Busca {
    public static void buscaEmLargura(Grafo grafo)
    {
        ArrayList<Vertice> marcados = new ArrayList<Vertice>();
        ArrayList<Vertice> fila = new ArrayList<Vertice>();
        Vertice atual = grafo.getVertices().get(0);
        marcados.add(atual);
        System.out.println(atual.getId());
        fila.add(atual);
        while(!fila.isEmpty())
        {
            Vertice visitado = fila.get(0);
            for(int i=0; i<visitado.getArestaSaida().size();i++)
            {
                Vertice proximo = visitado.getArestaSaida().get(i).getFim();
                if(!marcados.contains(proximo))
                {
                    marcados.add(proximo);
                    System.out.println(proximo.getId());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public static void buscaEmProfundidade(Grafo grafo) {
        ArrayList<Vertice> visitados = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();

        Vertice inicial = grafo.getVertices().get(0);
        pilha.push(inicial);

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();

            if (!visitados.contains(atual)) {
                visitados.add(atual);
                System.out.println(atual.getId());

                for (Aresta aresta : atual.getArestaSaida()) {
                    Vertice proximo = aresta.getFim();

                    if (!visitados.contains(proximo)) {
                        pilha.push(proximo);
                    }
                }
            }
        }
    }
}
