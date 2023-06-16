package hash;

public class Entrada {
    private int key;
    private int value;

    public Entrada(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{%d: %d}", key, value);
    }
}
