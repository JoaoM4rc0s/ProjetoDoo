package jogomemoria;

public class CartaMemoria extends Carta {
    private boolean matched;

    public CartaMemoria(String value) {
        super(value);    // Chama o construtor de Card
        this.matched = false;  // Inicializa o atributo específico de CartaMemoria
    }

    
    @Override
    public void reveal() {
        if (!matched) { // Só revela se a carta ainda não estiver desativada
            this.revealed = true;
        }
    }

    @Override
    public void hide() {
        if (!matched) { // Só esconde se a carta ainda não estiver desativada
            this.revealed = false;
        }
    }
    
    public void disable() {
        this.matched = true;  // Marca a carta como parte de um par encontrado
    }
    
    public boolean isMatched() {
        return this.matched;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() { // Metodo da classe Object, define como o objeto é representado 
        return revealed ? value : "[?]"; // Operador ternario
    }
    
}
