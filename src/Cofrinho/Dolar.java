package Cofrinho;

//Classe que representa a moeda Dolar
class Dolar extends Moeda {
 public Dolar(double valor) {
     super(valor);
 }

 @Override
 public String getDescricao() {
     return "Dolar";
 }

 public double calcularValorEmReal() {
     return getValor() * 5.0; // Conversao de dolar para real
 }
}
