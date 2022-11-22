package listalde;

public class LDE {
    public No comeco;
    public No fim;
    
    public LDE(){
        comeco = null;
        fim = null;
    } 
    
    public boolean vazia(){
        return (comeco==null);
    }

    public void inserir( int exp, double soma  ){
        No novo =  new No(exp, soma);
        
        if( comeco == null ){ // caso 1
            comeco = novo;
            fim = novo;
            return;
        }
        if( exp > comeco.expoente ){ // Caso 2
            comeco.eloA = novo;
            novo.eloP = comeco;
            comeco = novo;
            return;
        }
        if( exp < fim.expoente ){ // Caso 3
            fim.eloP = novo;
            novo.eloA = fim;
            fim = novo;
            return;
        }
        // Caso 4 se já existe fazer o que deseja, subtrair somar ou multipicar
        No ant, prox;
        ant = comeco;
        while( ant != null ){
            prox = ant.eloP;
            if( exp == ant.expoente || exp == prox.expoente ){
                System.out.println("Elemento selecionado já existe o que deseja fazer?");
            }
            if( exp > ant.expoente && exp < prox.expoente ){ 
                ant.eloP = novo;
                novo.eloP = prox;
                prox.eloA = novo;
                novo.eloA = ant;  
                return;
            }
            ant = ant.eloP;
        }
    }
    
    public boolean remover(int exp, int soma){
        No novo =  new No(exp, soma);
        
        if( comeco == null ){ // caso 1
            System.out.println("Função esta vazia");
            return false;
        }
        if( exp == comeco.expoente ){ // Caso 2
            novo = comeco.eloP;
            comeco = novo;
            return true;
        }
        if( exp == fim.expoente ){ // Caso 3
            novo.eloA = fim;
            fim = novo;
            return true;
        }
        // Caso 4 se já existe fazer o que deseja, subtrair somar ou multipicar
        No ant, prox;
        ant = comeco;
        while( ant != null ){
            prox = ant.eloP;
            if( exp == ant.expoente || exp == prox.expoente ){
                System.out.println("Elemento seleciinado já existe o que deseja fazer?");
            }
            if( exp > ant.expoente && exp < prox.expoente ){ 
                ant.eloP = novo;
                novo.eloP = prox;
                prox.eloA = novo;
                novo.eloA = ant;  
                return true;
            }
            ant = ant.eloP;
        }
        
        return false;
    }
    
    public LDE somar(LDE f1, LDE f2){
        LDE f3 = new LDE();
        No e1 = f1.comeco;
        No e2 = f2.comeco;
        if(f2.comeco.expoente > f1.comeco.expoente){
            e1 = f2.comeco;
            e2 = f1.comeco;
        }
        int maiorExp = e1.expoente;
        while(e1 != null || e2 != null){
            double som = 0; 
            if (maiorExp == e2.expoente && maiorExp == e2.expoente) som = e1.somatoria + e2.somatoria;
            else if(maiorExp == e1.expoente) som = e1.somatoria;
            else if( maiorExp == e2.expoente) som = e2.somatoria;
            f3.inserir(maiorExp, som);
        
        
        if (maiorExp == e2.expoente && maiorExp == e2.expoente){
            e1 = e1.eloP;
            e2 = e2.eloP;
        }
        else if(maiorExp == e1.expoente) e1= e1.eloP;
        else if(maiorExp == e2.expoente) e2 = e2.eloP;
        
        if(e1.expoente >= e2.expoente) maiorExp = e1.expoente;
        else if(e2.expoente > e1.expoente) maiorExp = e2.expoente;
        }
        
        
        return f3;
    }
    
    public void mostrar( String frase ){
        No aux;
        
        System.out.print( frase + ": " );
        aux = comeco;
        while( aux != null ){
            if(aux.expoente != 0) System.out.print( aux.somatoria + "X^" + aux.expoente + " + ");
            else System.out.print(aux.somatoria +" ");
            aux = aux.eloP;
        }
        System.out.println();
    }
    
    public int contar(){
        No aux = comeco;
        int cont = 0;
        while(aux != null){
            cont ++;
            aux = aux.eloP;
        }
        return cont;
    }
   
    public LDE copy(LDE orig){
        LDE copia = new LDE();
        No aux = orig.comeco;
        
        while(aux != null){
            copia.inserir(aux.expoente, aux.somatoria);
            aux = aux.eloP;
        }
        
        return copia;
    }

    
}
