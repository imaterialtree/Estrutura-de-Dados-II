package guloso;

import java.util.Scanner;

public class NotasDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor: ");
        int value = sc.nextInt();
        int[] noteValues = {100, 50, 20, 10, 5, 2, 1};
        int[] notes = contNotesDp(value, noteValues);
        // Answer
        System.out.println(value);
        for (int i = 0; i < noteValues.length; i++)
            System.out.print(notes[i] + " nota(s) de R$" + noteValues[i] + ",00\n");
    }

    public static int[] contNotesDp(int value, int[] noteValues) {
        int[] notes = new int[noteValues.length];
        for (int i = 0; i < noteValues.length; i++) {
            while (noteValues[i]<=value) {
                value -= noteValues[i];
                notes[i] += 1;
            }
        }
        return notes;
    }
}
