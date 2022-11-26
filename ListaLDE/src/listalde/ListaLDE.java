package listalde;

import java.util.Scanner;

public class ListaLDE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letra, opcao;
        LDE l1, l2, l3;
        l1 = new LDE();
        l2 = new LDE();
        l3 = new LDE();
        
        do{
            System.out.println("\nOpção ((1-inserir Elementos na função 1// 2-inserir elementos na função 2"
                            + "\n// M-mostrar todas funções// *-Para multiplicar as duas funções// '-'-Para subtrair as duas funçõess// + Para somar as duas funções//F-fim): " );
            opcao = sc.nextLine().charAt(0);
            int exp;
            double coef;
            switch( opcao ){
                case '1' -> 
                {
                    System.out.println("Função 1: Digite o expoente:");
                    exp = sc.nextInt();
                    System.out.println("Função 1: Digite o coeficiente:");
                    coef = sc.nextDouble();
                    l1.inserir(exp, coef);
                }
                case '2' -> 
                {
                    System.out.println("Função 2: Digite o expoente:");
                    exp = sc.nextInt();
                    System.out.println("Função 2: Digite o coeficiente:");
                    coef = sc.nextDouble();
                    l2.inserir(exp, coef);
                }
                case 'M', 'm' -> 
                {
                    l1.mostrar("Função 1: ");
                    System.out.println("");
                    l2.mostrar("Função 2: ");
                    System.out.println("");
                    l3.mostrar("Função 3: ");
                }
                case '*' -> 
                {
                    l3.multiplicar(l1, l2);
                    l3.mostrar("Multiplicação: ");
                }
                case '-' -> 
                {
                    l3.subtrairLista(l1, l2);
                    l3.mostrar("Subtração: ");
                }
                case '+' -> 
                {
                    l3.somarLista(l1, l2);
                    l3.mostrar("Soma: ");
                }
                default -> System.out.println("Opção invalida.");

            }
            
        }while( opcao != 'F' && opcao != 'f' );
        System.out.println();

    }
    
}
