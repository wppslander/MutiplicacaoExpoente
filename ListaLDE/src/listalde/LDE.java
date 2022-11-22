package listalde;

public class LDE 
{
    public No comeco;
    public No fim;
    
    public LDE()
    {
        comeco = null;
        fim = null;
    } 
    
    public boolean vazia()
    {
        return (comeco==null);
    }

    public void inserir( int exp, double soma  )
    {
        No novo =  new No(exp, soma);
        
        if( comeco == null )// caso 1
        { 
            comeco = novo;
            fim = novo;
            return;
        }
        if( exp > comeco.exp )// Caso 2
        { 
            comeco.eloA = novo;
            novo.eloP = comeco;
            comeco = novo;
            return;
        }
        if( exp < fim.exp )// Caso 3
        { 
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
            if( exp == ant.exp){
                somar(ant, ant.coef);
            }
            if( exp > ant.exp && exp < prox.exp ){ 
                ant.eloP = novo;
                novo.eloP = prox;
                prox.eloA = novo;
                novo.eloA = ant;  
                return;
            }
            ant = ant.eloP;
        }
    }
    
    public LDE multiplicar(LDE f1, LDE f2){
        No l1 = f1.comeco;
        No l2 = f2.comeco;
        LDE f3 = new LDE();
        int exp;
        double coef;
        while(l1 != null){
            while(l2 != null){
                exp = l1.exp + l2.exp;
                coef = l1.coef * l2.coef;
                f3.inserir(exp, coef);
                l2 = l2.eloP;
            }
            l1 = l1.eloP;
        }
        
        return f3;
    }
    
    public void somar(No n1, double coefi )
    {
        n1.coef = n1.coef + coefi;
    }
    
    public LDE somarLista(LDE f1, LDE f2)
    {
        LDE f3 = new LDE();
        No l1 = f1.comeco;
        No l2 = f2.comeco;
                
        while(l1 != null)
        {
            f3.inserir(l1.exp, l1.coef);
            l1 = l1.eloP;
        }
        while (l2 != null)
        {
            f3.inserir(l2.exp, l2.coef);
            l2 = l2.eloP;
        }
        
        return f3;
    }
    
    public LDE subtrairLista(LDE f1, LDE f2)
    {
        LDE f3 = new LDE();
        No l1 = f1.comeco;
        No l2 = f2.comeco;
        
        
        if(l1.coef == l2.coef)
        {
            f3.subtrair(l1, l2.coef);
        }
        else
        {
            while(l1 != null)
            {
                f3.inserir(l1.exp, l1.coef);
                l1 = l1.eloP;
            }
            while (l2 != null)
            {
                f3.inserir(l2.exp, l2.coef);
                l2 = l2.eloP;
            }
        }
        return f3;
    }
    
    public void subtrair(No n1, double coefi)
    {
        n1.coef = n1.coef - coefi;
    }
    
    
    public void mostrar(String frase){
        No aux;
        
        System.out.print( frase + ": " );
        aux = comeco;
        while( aux != null )
        {
            if(aux.exp != 0) System.out.print( aux.coef + "X^" + aux.exp + " + ");
            else System.out.print(aux.coef +" ");
            aux = aux.eloP;
        }
        System.out.println();
    }
    
}