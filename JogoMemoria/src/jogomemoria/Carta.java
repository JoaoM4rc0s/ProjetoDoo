package jogomemoria;

public abstract class Carta {
    protected String value;
    protected boolean revealed;

    public Carta(String value) {
        this.value = value;
        this.revealed = false;
    }

    public abstract void reveal();
    public abstract void hide();
    public abstract String getValue();
}
