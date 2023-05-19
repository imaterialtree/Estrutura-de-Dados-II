package escalonamentoIntervalo;

public class IntervaloPonderado extends Intervalo implements Comparable{
    private int valor;

    public IntervaloPonderado(String id, int inicio, int fim, int valor) {
        super(id, inicio, fim);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int compareTo(Object o) {
        IntervaloPonderado i = (IntervaloPonderado) o;
        return this.getValor() - i.getValor();
    }

    @Override
    public String toString() {
        return "IntervaloPonderado{" +
                "id='" + super.getId() + '\'' +
                ", inicio=" + super.getInicio() +
                ", fim=" + super.getFim() +
                ", valor=" + valor +
                "}";
    }
}
