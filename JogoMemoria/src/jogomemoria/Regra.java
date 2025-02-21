package jogomemoria;

public interface Regra {
    void shuffleCards();
    void displayBoard();
    boolean checkMatch(int firstChoice, int secondChoice);
}
