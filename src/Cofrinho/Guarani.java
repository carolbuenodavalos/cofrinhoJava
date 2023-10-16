package Cofrinho;

// Classe que representa a moeda Guarani
class Guarani extends Moeda {
    public Guarani(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Guarani";
    }

    public double calcularValorEmReal() {
        return getValor() * 0.0067; // Conversao de guarani para real
    }
}
