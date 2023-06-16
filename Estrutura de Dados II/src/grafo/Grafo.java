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

    public void addVertice(String id) {
        vertices.add(new Vertice(id));
    }
    public Vertice getVertice(String id) {
        for (Vertice v : vertices)
            if (v.getId().equals(id))
                return v;
        return null;
    }

    public void addAresta (int peso, String idInicio, String idFim) {
        Vertice inicio =  this.getVertice(idInicio);
        Vertice fim = this.getVertice(idFim);
        Aresta aresta = new Aresta(peso, inicio, fim);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    public void addAresta (String idInicio, String idFim) {
        Vertice inicio =  this.getVertice(idInicio);
        Vertice fim = this.getVertice(idFim);
        Aresta aresta = new Aresta(inicio, fim);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    public void addArestaBi (String id1, String id2) {
        Vertice v1 =  this.getVertice(id1);
        Vertice v2 = this.getVertice(id2);
        Aresta aresta1 = new Aresta(v1, v2);
        Aresta aresta2 = new Aresta(v2, v1);
        v1.addArestaSaida(aresta1);
        v1.addArestaSaida(aresta2);
        v2.addArestaEntrada(aresta1);
        v2.addArestaEntrada(aresta2);
        this.arestas.add(aresta1);
        this.arestas.add(aresta2);
    }


    public int[][] gerarMatrizAdjacencia()
    {
        int[][] matriz =  new int[vertices.size()][vertices.size()];
        for(int i=0;i<vertices.size();i++)
        {
            for(int j=0;j<vertices.size();j++)
            {
                matriz[i][j] = 0;
            }
        }
        for(int i=0;i<vertices.size();i++)
        {
            for(int j=0;j<vertices.size();j++)
            {
                for(int k=0;k<arestas.size();k++)
                {
                    if(arestas.get(k).getInicio().getId().equals(vertices.get(i).getId())
                            && arestas.get(k).getFim().getId().equals(vertices.get(j).getId())
                            || arestas.get(k).getInicio().getId().equals(vertices.get(j).getId())
                            && arestas.get(k).getFim().getId().equals(vertices.get(i).getId()))
                    {
                        matriz[i][j] = arestas.get(k).getPeso();
                    }
                }
            }
        }
        for(int i=0;i<vertices.size();i++)
        {
            for(int j=0;j<vertices.size();j++)
            {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
        return matriz;
    }
}
