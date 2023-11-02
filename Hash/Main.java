package Hash;

public class Main {
    public static void main(String [] args){
        tabelaHash tabela = new tabelaHash(10);
        tabela.insereHash(4459001);
        tabela.insereHash(4132002);
        tabela.insereHash(4449003);
        tabela.insereHash(8923004);
        tabela.insereHash(4459005);
        tabela.insereHash(4459006);
        tabela.insereHash(4459007);
        tabela.insereHash(9001001);
        tabela.imprimeTabela();
        tabela.buscar(4459005);
    }
}
