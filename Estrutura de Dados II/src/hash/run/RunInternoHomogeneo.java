package hash.run;

import hash.colisaoTratamento.encadeado.InternoHomogeneo;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class RunInternoHomogeneo {
    public static void main(String[] args) throws IOException {

        int tam = jIntInput("Digite o tamanho da tabela hash", "Encadeamento interno Homogeneo");
        InternoHomogeneo hashTable1 = new InternoHomogeneo(tam);
        final String[] options = {"Inserir", "Buscar", "Remover", "Sair"};
        final int SAIR = Arrays.asList(options).indexOf("Sair");

        int op;

        do {
            String viewTable = hashTable1.toString();
            op = JOptionPane.showOptionDialog(null, viewTable+"\nEscolha uma opção", "Encadeamento Interno Homogeneo", 0, JOptionPane.PLAIN_MESSAGE, null, options, null);
            switch (op) {
                case 0 -> {
                    hashTable1.inserir(
                            jIntInput(viewTable+"\nDigite um inteiro positivo para ser inserido", "Inserir"));

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(hashTable1);
                }

                case 1 -> {
                    int key = hashTable1.buscar(
                            jIntInput(viewTable+"\nDigite um inteiro positivo para ser buscado", "Buscar"));
                    String msg = key<0 ? "Esse número não está na tabela" : "A posição do número é: "+key;
                    JOptionPane.showMessageDialog(null, msg, "Buscar",
                            key<0?JOptionPane.ERROR_MESSAGE : JOptionPane.PLAIN_MESSAGE);
                }

                case 2 -> {
                    hashTable1.remover(
                            jIntInput(viewTable+"\nDigite um inteiro positivo para ser removido", "Remover"));
                }
            }
        } while (op != SAIR && op != -1);
    }

    static int jIntInput(String msg, String title) {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                    msg, title, JOptionPane.PLAIN_MESSAGE)
                    );
        }catch (NumberFormatException e) {
            return -1;
        }
    }
}
