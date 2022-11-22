package listalde;

import java.util.Scanner;

public class ListaLDE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letra, opcao;
        LDE lista = new LDE();
        
        do{
            System.out.print("\nOpção ((1-inserir Elementos na função 1// 2-inserir elementos na função 2"
                            + "\n// M-mostrar funções// *-Para multiplicar as duas operações// '-'-Para subtrair as duas funçõess// + Para somar as duas funções//F-fim): " );
            opcao = sc.nextLine().charAt(0);
            
            switch( opcao ){
                case '1':
                    
                    break;
                case 'R': case 'r':
                    
                case 'C': case 'c':
                    
                case 'D': case 'd':
                    
            }
            
        }while( opcao != 'F' && opcao != 'f' );
        System.out.println();

    }
    
}
