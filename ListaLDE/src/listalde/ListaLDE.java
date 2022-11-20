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
                    System.out.print( "\nDigite uma letra p/ inserir: " );
                    letra = sc.nextLine().charAt(0);
                    lista.inserir(letra);
                    break;
                case 'R': case 'r':
                    System.out.print( "\nDigite uma letra p/ retirar: " );
                    letra = sc.nextLine().charAt(0);
                    if( lista.retirar(letra) )
                        System.out.print( "Retirada realizada com sucesso!" );
                    else
                        System.out.print( "Erro: Letra não presente na lista!" );
                    break;
                case 'C': case 'c':
                    lista.mostrarC("LDE");
                    break;
                case 'D': case 'd':
                    lista.mostrarD("LDE");
                    break;
            }
            
        }while( opcao != 'F' && opcao != 'f' );
        System.out.println();

    }
    
}
