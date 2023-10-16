package Cofrinho;

//Classe abstrata para todas as moedas
abstract class Moeda {
 private double valor;

 public Moeda(double valor) {
     this.valor = valor;
 }

 public double getValor() {
     return valor;
 }

 public abstract String getDescricao();
}
