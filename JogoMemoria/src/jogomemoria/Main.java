package jogomemoria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        JogoMemoria game = new JogoMemoria();
        
        
        System.out.println("Bem-vindo ao Jogo da Memória!");
        
        while (!game.isGameOver()) {
            game.displayBoard();
            try {
                System.out.print("Escolha a primeira carta (índice): ");
                int firstChoice = scanner.nextInt();
                
                System.out.print("Escolha a segunda carta (índice): ");
                int secondChoice = scanner.nextInt();

                game.checkMatch(firstChoice, secondChoice);
            } catch (Exception e) {
                System.out.println("Entrada inválida! Escolha um número válido.");
                scanner.next(); // Limpa o buffer e evita um loop infinito de erros
            }
        }
        
        System.out.println("Parabéns! Você venceu em " + game.getAttempts() + " tentativas.");
        scanner.close();
        
        
    }
    
    
    public static void clearScreen() {
        for (int i = 0; i < 500; i++) {  
            System.out.println();
        }
    }
}


