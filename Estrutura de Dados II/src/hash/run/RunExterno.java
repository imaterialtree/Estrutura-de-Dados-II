package hash.run;

import hash.Entrada;
import hash.colisaoTratamento.encadeado.EncadeamentoExterno;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class RunExterno {
    public static void main(String[] args) throws IOException {

        int tam = jIntInput("Digite o tamanho da tabela hash", "Encadeamento Externo");
        EncadeamentoExterno hashTable1 = new EncadeamentoExterno(tam);
        final String[] options = {"Inserir", "Buscar", "Remover", "Sair"};
        final int SAIR = Arrays.asList(options).indexOf("Sair");

        int op;

        do {
            String viewTable = hashTable1.toString();
            op = JOptionPane.showOptionDialog(null, viewTable+"\nEscolha uma opção", "Encadeamento Externo", 0, JOptionPane.PLAIN_MESSAGE, null, options, null);
            switch (op) {
                case 0 -> {
                    hashTable1.inserir(
                            jIntInput(viewTable+"\nDigite a chave a ser inserida", "Inserir"),
                            jIntInput(viewTable+"\nDigite o valor a ser inserido", "Inserir"));

                    System.out.println(hashTable1);
                }

                case 1 -> {
                    int value = hashTable1.buscar(
                            jIntInput(viewTable+"\nDigite a chave para buscar", "Buscar"));
                    String msg = value==-1 ? "Essa chave não está na tabela" : "O valor correspondente a essa chave é: "+value;
                    JOptionPane.showMessageDialog(null, msg, "Buscar",
                            value<0?JOptionPane.ERROR_MESSAGE : JOptionPane.PLAIN_MESSAGE);
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
