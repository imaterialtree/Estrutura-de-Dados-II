package guloso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NotasRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor: ");
        int value = sc.nextInt();
        List<Integer> note_values = Arrays.asList(100, 50, 20, 10, 5, 2, 1);
        List<Integer> notes = contNotesRec(value, new ArrayList<>(note_values));

        // Answer
        System.out.println(value);
        for (int i=0; i<note_values.size(); i++) {
            System.out.print(notes.get(i) + " nota(s) de R$"+note_values.get(i)+",00\n");
        }
    }



    // notes: lista de qtd de notas
    // qtd_note_values: tamanho original da lista note_values
    public static ArrayList<Integer> contNotesRec(int value, ArrayList<Integer>note_values, ArrayList<Integer>notes, int qtd_note_values) {
        if (note_values.isEmpty())
            return notes;
        if (notes.size() <= qtd_note_values - note_values.size())
            notes.add(0);

        if (note_values.get(0) <= value) {
            value -= note_values.get(0);
            notes.set(notes.size()-1, notes.get(notes.size()-1)+1);
        } else{
            note_values.remove(0);
        }
        return contNotesRec(value, note_values, notes, qtd_note_values);
    }

// chamada encapsulada
    public static ArrayList<Integer> contNotesRec(int value, ArrayList<Integer> note_values){
        return contNotesRec(value, note_values, new ArrayList<>(), note_values.size());
    }
}
