package grafo;

import java.util.ArrayList;

public class Grafo {
    ArrayList<Vertice> vertices;
    ArrayList<Aresta> arestas;
    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void addVertice(String dado) {
        vertices.add(new Vertice(dado));
    }


}
