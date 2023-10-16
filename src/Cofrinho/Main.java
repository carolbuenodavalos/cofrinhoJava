package Cofrinho;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;


// no menu criei uma interface para o programa, tentei deixar o mais simples e informativo possivel
public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("---- Bem vindo ao Cofrinho de Moedas! ----");
            System.out.println("O que deseja fazer hoje?\n");
            System.out.println("1. Adicionar moedas no cofrinho");
            System.out.println("2. Tirar alguma moeda do cofrinho");
            System.out.println("3. Mostrar as moedas do cofrinho");
            System.out.println("4. Calcular valor total em Real");
            System.out.println("0. Sair\n");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ops! Parece que essa opcao nao existe no menu");
                scanner.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Qual valor quer adicionar?");
                    String valorString = scanner.next();
                    double valor;

                    try {
                        valor = Double.parseDouble(valorString);
                    } catch (NumberFormatException e) {
                        System.out.println("Valor invalido. \nObs: ao inves de separar as casas decimais por ',' utilize '.' (Ex: 3.50)");
                        continue;
                    }
                    System.out.println("De qual pais é a moeda?\nAceitamos: 1. Real, 2. Dolar, 3. Euro, 4. Guarani (digite o numero da moeda ou o nome)");
                    String descricao = scanner.next();
                    Moeda moeda;

                    if (descricao.equalsIgnoreCase("real") || descricao.equals("1")) {
                        moeda = new Real(valor);
                    } else if (descricao.equalsIgnoreCase("dolar") || descricao.equals("2")) {
                        moeda = new Dolar(valor);
                    } else if (descricao.equalsIgnoreCase("euro") || descricao.equals("3")) {
                        moeda = new Euro(valor);
                    } else if (descricao.equalsIgnoreCase("guarani") || descricao.equals("4")) {
                        moeda = new Guarani(valor);
                    } else {
                        System.out.println("Moeda nao suportada.");
                        continue;
                    }

                    cofrinho.adicionarMoeda(moeda);
                    break;
                case 2:
                    System.out.println("Moedas do cofrinho:\n1. Real\n2. Dolar\n3. Euro\n4. Guarani\ndigite o numero da moeda que deseja remover:");
                    int numeroMoeda;

                    try {
                        numeroMoeda = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("ops! numero invalido, não temos essa moeda no cofrinho");
                        scanner.nextLine();
                        continue;
                    }

                    int indice = numeroMoeda - 1; // Ajusta o indice para comecar em 1 no arraylist

                    cofrinho.removerMoeda(indice);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    double valorTotalEmReal = cofrinho.calcularValorTotalEmReal();
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    String valorTotalEmRealFormatado = decimalFormat.format(valorTotalEmReal);
                    System.out.println("Valor total em Real: " + valorTotalEmRealFormatado);
                    break;
                case 0:
                    System.out.println("ATE LOGO!");
                    break;
                default:
                    System.out.println("Ops! Parece que essa opcao nao existe no menu");
            }

            System.out.println();
        }

        scanner.close();
    }
}
