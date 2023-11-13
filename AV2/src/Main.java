public class Main {
    public static void main(String[] args){
        ArvoreAVL arvore = new ArvoreAVL();
        arvore.inserir(20);
        arvore.inserir(13);
        arvore.inserir(15);
        arvore.imprimir();
        ArvoreBi arvore2 = new ArvoreBi();
        arvore2.inserir(20);
        arvore2.inserir(13);
        arvore2.inserir(15);
        arvore2.inserir(55);
        arvore2.imprimir();
        arvore2.remover(20);
        arvore2.imprimir();
    }
}
