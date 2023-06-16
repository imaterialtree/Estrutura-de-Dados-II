package grafo.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import grafo.*;

public class BellmanFord extends Grafo{
    Map<Vertice, Double> distanciaMinima = new HashMap<>();
    Map<Vertice, Vertice> anterior = new HashMap<>();


    public BellmanFord(Grafo grafo){

        for (Vertice v : this.getVertices()) {
            distanciaMinima.put(v, Double.MAX_VALUE);
            anterior.put(v, null);
        }
    }

    public void menorCaminho(Vertice origem, Vertice destino){
        distanciaMinima.put(destino, Double.MAX_VALUE);
        ArrayList<Vertice> vertices = this.getVertices();
        ArrayList<Aresta> arestas = this.getArestas();
        distanciaMinima.put(origem, 0.);

        for(int i=0; i<vertices.size()-1;i++){
            for(Aresta aresta : arestas){
                if(distanciaMinima.get(aresta.getInicio()) == Double.MAX_VALUE)continue;
                Vertice x = aresta.getInicio();
                Vertice y = aresta.getFim();

                double novaDistancia = distanciaMinima.get(x) + aresta.getPeso();

                if(novaDistancia < distanciaMinima.get(y)){
                    distanciaMinima.replace(y, novaDistancia);
                    anterior.replace(y, x);
                }
            }
        }
        for(Aresta aresta: arestas)
        {
            if(distanciaMinima.get(aresta.getInicio()) != Double.MAX_VALUE)continue;
            if(temNegativo(aresta))
            {
                System.out.println("Aresta negativa detectada");
                return;
            }
        }
        if(distanciaMinima.get(destino) == Double.MAX_VALUE)
        {
            System.out.println("Não existem caminhos de origem ao destino");
        }
        else
        {
            System.out.println("O menor caminho é: "+distanciaMinima.get(destino));
        }

        ArrayList<Vertice> listVertice = new ArrayList<>();
        for(Vertice vertice = destino; vertice !=null; vertice = anterior.get(vertice))
            listVertice.add(vertice);
        Collections.reverse(listVertice);
        for(int i=0; i<listVertice.size();i++){
            System.out.println(listVertice.get(i).getId());
        }
    }

    private boolean temNegativo(Aresta aresta){
        return (distanciaMinima.get(aresta.getInicio()) + aresta.getPeso() < distanciaMinima.get(aresta.getFim()));
    }
}
