package Cofrinho;

//Classe que representa a moeda Euro
class Euro extends Moeda {
 public Euro(double valor) {
     super(valor);
 }

 @Override
 public String getDescricao() {
     return "Euro";
 }

 public double calcularValorEmReal() {
     return getValor() * 5.30; // Conversao de euro para real
 }
}
