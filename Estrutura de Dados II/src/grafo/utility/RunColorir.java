package grafo.utility;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.HashMap;
import java.util.Map;

import static grafo.utility.ColorirVertices.colorVertices;
import static grafo.utility.ColorirArestas.colorArestas;

public class RunColorir {
    public static void main(String[] args) {
        Map<Integer, String> cores = new HashMap<>();
        for (int i=0; i<7; i++) {
            cores.put(i, "\033[3"+(i+1)+";1m");
        }
        Grafo grafo = new Grafo();
        String[] vertices = {"A", "B", "C", "D", "E"};
        for (String v : vertices) {
            grafo.addVertice(v);
        }
        grafo.addAresta("A", "B");
        grafo.addAresta("A", "C");
        grafo.addAresta("A", "E");
        grafo.addAresta("B", "C");
        grafo.addAresta("B", "E");
        grafo.addAresta("C", "D");
        grafo.addAresta("D", "E");

        colorVertices(grafo);
        colorArestas(grafo);

        System.out.println("Vértices coloridos: ");
        for (Aresta a : grafo.getArestas()) {
            String inicio = cores.get(a.getInicio().getCor()) + a.getInicio().getId() + "\033[0;0m";
            String fim = cores.get(a.getFim().getCor()) + a.getFim().getId() + "\033[0;0m";
            System.out.printf("%s ---> %s\n", inicio, fim);
        }

        System.out.println("\nArestas coloridas: ");
        for (Aresta a : grafo.getArestas()) {
            String arestaCor = String.format("%s--->%s", cores.get(a.getCor()), "\033[0;0m");
            System.out.printf("%s %s %s\n", a.getInicio(), arestaCor, a.getFim());
        }

        System.out.println("\nGrafo colorido: ");
        for (Aresta a : grafo.getArestas()) {
            String inicio = cores.get(a.getInicio().getCor()) + a.getInicio().getId() + "\033[0;0m";
            String fim = cores.get(a.getFim().getCor()) + a.getFim().getId() + "\033[0;0m";
            String arestaCor = String.format("%s--->%s", cores.get(a.getCor()), "\033[0;0m");
            System.out.printf("%s %s %s\n", inicio, arestaCor, fim);
        }
    }
}
