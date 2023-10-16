package Cofrinho;

//Classe para o real, sem conversao
class Real extends Moeda {
 public Real(double valor) {
     super(valor);
 }

 @Override
 public String getDescricao() {
     return "Real";
 }
}
