package grafo.utility;

import grafo.Aresta;
import grafo.Vertice;

import java.util.*;

public class Dijkstra {
    Map<Vertice, Double> distanciaMinima = new HashMap<>();
    Map<Vertice, Vertice> anterior;
    public void processaCaminho(Vertice origem)
    {
        distanciaMinima.put(origem, 0.);
        PriorityQueue<Vertice> filaVertice = new PriorityQueue<Vertice>();
        filaVertice.add(origem);

        while (!filaVertice.isEmpty()) {
            Vertice verticeAux = filaVertice.poll();
            distanciaMinima.put(verticeAux, Double.MAX_VALUE);

            // Visita se existir aresta ligada ao vertice
            for (Aresta e : verticeAux.getArestaSaida())
            {
                Vertice v = e.getFim();
                distanciaMinima.put(v, Double.MAX_VALUE);
                double custo = e.getPeso();
                double menorDistancia = distanciaMinima.get(verticeAux) + custo;
                if (menorDistancia < distanciaMinima.get(v)) {
                    filaVertice.remove(v);

                    distanciaMinima.put(v, menorDistancia);
                    anterior.put(v, verticeAux);
                    filaVertice.add(v);
                }
            }
        }
    }

    public ArrayList<Vertice> getMenorCaminho(Vertice destino)
    {
        ArrayList<Vertice> listVertice = new ArrayList<Vertice>();
        for (Vertice vertice = destino; vertice != null; vertice = anterior.get(vertice))
            listVertice.add(vertice);

        Collections.reverse(listVertice);
        return listVertice;
    }
}
