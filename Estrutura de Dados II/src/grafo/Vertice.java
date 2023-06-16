package grafo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vertice {
    String id;
    int cor;
    ArrayList<Aresta> arestaEntrada;
    ArrayList<Aresta> arestaSaida;

    public Vertice(String id) {
        this.id = id;
        cor = -1;
        this.arestaEntrada = new ArrayList<>();
        this.arestaSaida = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public ArrayList<Aresta> getArestaEntrada() {
        return arestaEntrada;
    }

    public ArrayList<Aresta> getArestaSaida() {
        return arestaSaida;
    }
    public ArrayList<Aresta> getArestaTodas() {
        return  (ArrayList<Aresta>) Stream.concat(arestaEntrada.stream(), arestaSaida.stream())
                .collect(Collectors.toList());
    }

    // adds
    public boolean addArestaEntrada(Aresta a) {
        return this.arestaEntrada.add(a);
    }

    public boolean addArestaEntrada(int peso, String fim) { // Cria uma aresta que inclui this e outro vértice criado a partir de dado
        Aresta a = new Aresta(peso, this, new Vertice(fim));
        return arestaEntrada.add(a);
    }

    public boolean addArestaSaida(Aresta a) {
        return this.arestaSaida.add(a);
    }

    public boolean addArestaSaida(int peso, String inicio) { // Cria uma aresta que inclui this e outro vértice criado a partir de dado
        Aresta a = new Aresta(peso, new Vertice(inicio), this);
        return arestaSaida.add(a);
    }

    public void addArestaBidirecional (String vizinho) {
        Aresta aIn = new Aresta(new Vertice(vizinho), this);
        Aresta aOut = new Aresta(this, new Vertice(vizinho));
        arestaEntrada.add(aIn);
        arestaEntrada.add(aOut);
    }
    //removes
    public boolean removeArestaEntrada(Aresta a) {
        return this.arestaEntrada.remove(a);
    }
    public boolean removeArestaSaida(Aresta a) {
        return this.arestaSaida.remove(a);
    }


    // Get menor aresta
    public int menorDistancia() {
        int menor = Integer.MAX_VALUE;
        for (Aresta a : arestaEntrada) {
            if (a.getPeso() < menor) menor = a.getPeso();
        }
        return menor;
    }
    public Set<Vertice> getVizinhos() {
        Set<Vertice> vizinhos = new HashSet<>();
        for (Aresta aresta : arestaSaida) {
            vizinhos.add(aresta.getFim());
        }
        return vizinhos;
    }
    public Set<Vertice> getVizinhosBidirecional() {
        Set<Vertice> vizinhos = new HashSet<>();
        for (Aresta aresta : arestaSaida) {
            vizinhos.add(aresta.getFim());
        }
        for (Aresta aresta : arestaEntrada) {
            vizinhos.add(aresta.getInicio());
        }
        return vizinhos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return id.equals(vertice.id) && Objects.equals(arestaEntrada, vertice.arestaEntrada) && Objects.equals(arestaSaida, vertice.arestaSaida);
    }

    @Override
    public String toString() {
        return id;
    }
}
