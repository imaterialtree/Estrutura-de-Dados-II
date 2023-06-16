package grafo;

import java.util.ArrayList;
import java.util.Objects;

public class Vertice {
    String id;
    ArrayList<Aresta> arestaEntrada;
    ArrayList<Aresta> arestaSaida;

    public Vertice(String id) {
        this.id = id;
        this.arestaEntrada = new ArrayList<>();
        this.arestaSaida = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }
    public ArrayList<Aresta> getArestaEntrada() {
        return arestaEntrada;
    }

    public ArrayList<Aresta> getArestaSaida() {
        return arestaSaida;
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
            if (a.peso < menor) menor = a.peso;
        }
        return menor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return id.equals(vertice.id) && Objects.equals(arestaEntrada, vertice.arestaEntrada) && Objects.equals(arestaSaida, vertice.arestaSaida);
    }
}
