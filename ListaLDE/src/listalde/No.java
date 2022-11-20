package listalde;

public class No {
    public int expoente;
    public double somatoria;
    public No eloA, eloP;
    
    public No(){
        eloA = null;
        eloP = null;
    }
    
    public No(int exp, double soma ){
        expoente = exp;
        somatoria = soma;
        eloA = null;
        eloP = null;
    }
    
}
