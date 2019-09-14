package AG;

public class Ciudad {

    private int x;
    private int y;
    private String numero;

    public Ciudad(int x, int y, String numero) {
        this.x = x;
        this.y = y;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return numero;
    }
}
