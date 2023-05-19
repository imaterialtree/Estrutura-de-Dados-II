package escalonamentoIntervalo;

public class Intervalo {
    private String id;
    private int inicio, fim;

    public Intervalo(String id, int inicio, int fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getId() {
        return id;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    @Override
    public String toString() {
        return "Intervalo{" +
                "id='" + id + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}

