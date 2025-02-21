package jogomemoria;

import java.util.ArrayList;
import java.util.Collections;

public class JogoMemoria implements Regra {

    private ArrayList<CartaMemoria> cards;
    private int attempts;
    
    public JogoMemoria() {
        this.cards = new ArrayList<>();
        this.attempts = 0;
        initializeCards();
    }
    
    private void initializeCards() {
        String[] values = {"A", "A", "B", "B", "C", "C", "D", "D"};
        for (String value : values) {   // Percorre cada valor do array
            cards.add(new CartaMemoria(value));  // Cria e adiciona a carta
        }
        shuffleCards(); // Embaralha as cartas depois de adicioná-las
        
    }
    

    @Override
    public void shuffleCards() {
        Collections.shuffle(cards); // embaralha os elementos de uma lista
    }

    @Override
    public void displayBoard() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(i + ": " + cards.get(i) + "  ");
            if ((i + 1) % 4 == 0) {
                System.out.println(); // Quebra de linha a cada 4 cartas
            }
        }
        System.out.println();
    }
  

    @Override
    public boolean checkMatch(int firstChoice, int secondChoice) {
      try {
            if (firstChoice < 0 || secondChoice < 0 || firstChoice >= cards.size() || secondChoice >= cards.size()) {
                throw new IndexOutOfBoundsException("Escolha inválida!");
            }
            if (firstChoice == secondChoice) {
                throw new IllegalArgumentException("Escolha duas cartas diferentes!");
            }

            CartaMemoria firstCard = cards.get(firstChoice);
            CartaMemoria secondCard = cards.get(secondChoice);
            
            if (firstCard.isMatched() || secondCard.isMatched()) {
                System.out.println("Uma destas cartas (Ou as duas cartas) já faz parte de um par encontrado!");
                return false;
            }
            
            
            firstCard.reveal();
            secondCard.reveal();
            
            displayBoard();
      
          
            if (firstCard.getValue().equals(secondCard.getValue())) {
                System.out.println("Par encontrado!");
                disableMatchedCards(firstCard, secondCard); // Desabilita as cartas encontradas
                return true;
            } else {
                System.out.println("Não foi um par.");
                try {
                    
                    Thread.sleep(5000); // Aguarda 5 segundos antes de esconder as cartas
                    
                } catch (Exception e) {
                    System.out.println("Erro no temporizador do checkgame!");
                }
             
                Main.clearScreen(); // Metodo estatico para Limpar terminal
            
                firstCard.hide();
                secondCard.hide(); 
                
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            this.attempts++;
        }
    }
    
    public boolean isGameOver() {
        for (CartaMemoria card : cards) {
            if (!card.revealed) {
                return false;
            }
        }
        return true;
    }

    public int getAttempts() {
        return this.attempts;
    }

    private void disableMatchedCards(CartaMemoria firstCard, CartaMemoria secondCard) {
        firstCard.disable();
        secondCard.disable();
    }

   

}
