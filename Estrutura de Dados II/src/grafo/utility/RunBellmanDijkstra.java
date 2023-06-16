package grafo.utility;

import grafo.Grafo;

public class RunBellmanDijkstra {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");

        grafo.addAresta(43, "A", "B");
        grafo.addAresta(15, "A", "C");
        grafo.addAresta(3, "B", "D");
        grafo.addAresta(-2, "C", "B");
        grafo.addAresta(12, "C", "D");
        grafo.addAresta(4, "C", "E");
        grafo.addAresta(-5, "D", "E");
        grafo.addAresta(7, "D", "F");
        grafo.addAresta(8, "E", "F");

        System.out.println("Busca em Largura: ");
        Busca.buscaEmLargura(grafo);
        System.out.println("\n");
        System.out.println("Matriz em Adjacencia");
        grafo.gerarMatrizAdjacencia();
        System.out.println("\n");

        System.out.println("Busca em profundidade");
        Busca.buscaEmProfundidade(grafo);

//        System.out.println("Dijkstra:");
//        Dijkstra dij = new Dijkstra();
//        dij.processaCaminho(grafo.getVertice("A")); // chamando

//        ArrayList<Vertice> caminho = dij.getMenorCaminho(grafo.getVertice("F"));

//        for(int i=0; i<caminho.size();i++){
//            System.out.println(caminho.get(i).getDados());
//        }
//        System.out.println("=================");


//        System.out.println("DijkstraMatriz");
//        DijkstraMatriz djMat = new DijkstraMatriz();
//        djMat.menorCaminho(grafo.gerarMatrizAdjacencia());

        System.out.println("Bellman Ford");
        BellmanFord bf = new BellmanFord(grafo);
        bf.menorCaminho(grafo.getVertice("A"), grafo.getVertice("F"));
    }
}
