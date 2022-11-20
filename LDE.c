#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <locale.h>

typedef struct No{
    char info;
    struct No *eloA, *eloP;
} LDE;

void inserirLDE( LDE **comeco, LDE **fim, char letra ){
    LDE *novo, *ant, *prox;

    novo = malloc( sizeof(LDE) );
    novo->info = letra;
    novo->eloA = NULL;
    novo->eloP = NULL;

    if( (*comeco) == NULL ){ // Caso 1
        (*comeco) = novo;
        (*fim) = novo;
        return;
    }
    if( letra < (*comeco)->info ){ // Caso 2
        novo->eloP = (*comeco);
        (*comeco)->eloA = novo;
        (*comeco) = novo;
        return;
    }
    if( letra > (*fim)->info ){ // Caso 3
        (*fim)->eloP = novo;
        novo->eloA = (*fim);
        (*fim) = novo;
        return;
    }
    // Caso 4
    ant = (*comeco);
    while( ant != NULL ){
        prox = ant->eloP;
        if( letra > ant->info && letra < prox->info ){
            ant->eloP = novo;
            novo->eloP = prox;
            prox->eloA = novo;
            novo->eloA = ant;
            return;
        }
        ant = ant->eloP;
    }
}

int retirarLDE( LDE **comeco, LDE **fim, char letra ){
    LDE *aux;

    aux = (*comeco);
    while( aux != NULL ){

        if( aux->info == letra ){

            if( aux == (*comeco) ){
                if( aux->eloP == NULL ){ // Caso 1 - único elemento
                    (*comeco) = NULL;
                    (*fim) = NULL;
                }
                else{ // Caso 2 - início da lista
                    (*comeco) = aux->eloP;
                    (*comeco)->eloA = NULL;
                }
            }
            else{
                if( aux == (*fim) ){ // Caso 3 - final da lista
                    (*fim) = aux->eloA;
                    (*fim)->eloP = NULL;
                }
                else{ // Caso 4 - meio da lista
                    LDE *ant, *prox;
                    ant = aux->eloA;
                    prox = aux->eloP;
                    ant->eloP = prox;
                    prox->eloA = ant;
                }
            }
            free( aux );
            return 1;
        }
        aux = aux->eloP;
    }
    return 0;
}

void mostrarLDE_C(char frase[], LDE *comeco ){
    LDE *aux;

    printf( "\n%s: ",frase );
    aux = comeco;
    while( aux != NULL ){
        printf( "%c", aux->info );
        aux = aux->eloP;
        if( aux != NULL ) printf( " -> " );
    }
    printf( "\n" );
}

void mostrarLDE_D(char frase[], LDE *fim ){
    LDE *aux;

    printf( "\n%s: ",frase );
    aux = fim;
    while( aux != NULL ){
        printf( "%c", aux->info );
        aux = aux->eloA;
        if( aux != NULL ) printf( " -> " );
    }
    printf( "\n" );
}

int main(){
    setlocale(LC_ALL, "Portuguese");
    LDE *comeco=NULL, *fim=NULL, *aux;
    char letra, op;

    do{
        printf( "\nOpção (I-inserir//R-retirar//C-mostrar cres.//D-mostrar desc.//F-fim): " );
        op = getche();
        switch( op ){
            case 'I': case 'i':
                printf( "\nLetra para inserção: " );
                letra = getche();
                inserirLDE( &comeco, &fim, letra );
                break;
            case 'R': case 'r':
                printf( "\nLetra para retirada: " );
                letra = getche();
                if( retirarLDE( &comeco, &fim, letra ) )
                    printf( "\nRetirada realizada com sucesso!" );
                else
                    printf( "\nErro: Letra não presente na lista!" );
                break;
            case 'C': case 'c':
                mostrarLDE_C( "LDE Crescente", comeco );
                break;
            case 'D': case 'd':
                mostrarLDE_D( "LDE Decrescente", fim );
                break;
        }
    }while( op != 'F' && op != 'f' );
    printf( "\n" );
}
