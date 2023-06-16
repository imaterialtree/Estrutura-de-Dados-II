package guloso;

import java.util.*;
/*
* Maximizar o valor dos itens da mochila
*/
public class Mochila {
    public static void main(String[] args) {
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item("tempero", 5, 4));
        itens.add(new Item("porcelana", 20, 5));
        itens.add(new Item("marmore", 110, 20));
        itens.add(new Item("seda", 530, 8));
        itens.add(new Item("gemas", 900, 12));

        Map<Item, Integer> mochila = escolher(itens.toArray(new Item[0]), 1700, 50);
        System.out.println("\nInventário:");
        for (Map.Entry e : mochila.entrySet()) {
            System.out.println(e.getKey()+": "+e.getValue());
        }
    }

    public static Map<Item, Integer> escolher(Item[] items, int dinheiro, int capacidade) {
        System.out.println("Inicial: R$"+dinheiro+", "+capacidade+"kg disponivel");
        Map<Item, Integer> mochila = new HashMap<>();
        for (Item i: items) {
            mochila.put(i, 0);
        }
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());
        for (Item item: items) {
            while (item.peso <= capacidade && item.preco <= dinheiro) {
                dinheiro -= item.preco;
                capacidade -= item.peso;
                mochila.put(item, mochila.get(item)+1);
            }
        }
        System.out.println("Sobrou: R$"+dinheiro+", "+capacidade+"kg disponivel");
        return mochila;
    }
}
class Item {
    String nome;
    int preco; //compra
    int peso;

    public Item(String nome, int preco, int peso) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }
    double getRatio() {
        return (double) preco/peso;
    }
    @Override
    public String toString() {
        return nome;
    }
}