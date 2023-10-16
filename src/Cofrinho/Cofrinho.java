package Cofrinho;
import java.util.ArrayList;
import java.util.List;

// na classe cofrinho armazeno o arraylist onde são adicionadas as moedas de cada país
class Cofrinho {
    private List<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    // Adiciona uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada: " + moeda.getDescricao() + " - Valor: " + moeda.getValor());
    }

    // Remove uma moeda do cofrinho com base no indice do arraylist
    public void removerMoeda(int index) {
        if (index >= 0 && index < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(index);
            System.out.println("Moeda removida: " + moedaRemovida.getDescricao());
        } else {
            System.out.println("Opcao invalida. Nao foi possivel remover a moeda.");
        }
    }

    // mostra todas as moedas do cofrinho
    public void listarMoedas() {
        System.out.println("Moedas no cofrinho:");
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            System.out.println(i + ": " + moeda.getDescricao() + " - Valor: " + moeda.getValor());
        }
    }

    // Calcula o valor total das moedas no cofrinho convertido para Real puxando a conversao de cada classe
    public double calcularValorTotalEmReal() {
        double valorTotal = 0;
        for (Moeda moeda : moedas) {
            if (moeda instanceof Real) {
                valorTotal += moeda.getValor();
            } else if (moeda instanceof Dolar) {
                Dolar dolar = (Dolar) moeda;
                valorTotal += dolar.calcularValorEmReal();
            } else if (moeda instanceof Euro) {
                Euro euro = (Euro) moeda;
                valorTotal += euro.calcularValorEmReal();
            } else if (moeda instanceof Guarani) {
                Guarani guarani = (Guarani) moeda;
                valorTotal += guarani.calcularValorEmReal();
            }
        }
        return valorTotal;
    }
}
