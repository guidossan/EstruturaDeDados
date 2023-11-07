package Hash;

import java.util.Random;

public class Main {
    public static void main(String [] args){

//        insereTabela(100,200);
//        insereTabela(100,20000);
//        insereTabela(1000,1000000);
//        insereTabela(10000,11000000);
//        insereTabela(100000,500000000);
//        tabelaHash tabela = new tabelaHash(10);
//        tabela.insereHash(4459001);
//        tabela.insereHash(4132002);
//        tabela.insereHash(4449003);
//        tabela.insereHash(8923004);
//        tabela.insereHash(4459005);
//        tabela.insereHash(4459006);
//        tabela.insereHash(4459007);
//        tabela.insereHash(9001001);
//        tabela.insereHash(9123001);
//        tabela.insereHash(9234005);
//        tabela.imprimeTabela();
//        tabela.buscar(9234005);
//        int numero1 = 1261295;
//        int numero2 = 100;
//
//        int resto = numero1 % numero2;
//
//        System.out.println("O resto da divisão de " + numero1 + " por " + numero2 + " é: " + resto);

    }
    public static void insereTabela(int tamanhoTabela, int numRegistros){
        tabelaHash tabela = new tabelaHash(tamanhoTabela);
        tabela.insereHash(4459001);
        tabela.insereHash(4132002);
        tabela.insereHash(4449003);
        tabela.insereHash(8923004);
        tabela.insereHash(4459005);
        tabela.insereHash(4459006);
        tabela.insereHash(4459007);
        tabela.insereHash(9001001);
        tabela.insereHash(9123001);
        tabela.insereHash(9234005);
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < numRegistros; i++) {
            int numeroAleatorio = random.nextInt(9000000) + 1000000;
            tabela.insereHash(numeroAleatorio);
        }
        long endTime = System.nanoTime();
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
        tabela.imprimeTabela();
        System.out.println("Tempo de execução para tabela de tamanho " + tamanhoTabela + ": " + tempoExecucao + " milissegundos");
        tabela.buscar(9234005);
        tabela.buscar(4459007);
        tabela.buscar(4459001);
        tabela.buscar(4132002);
        tabela.buscar(4459006);
    }
}
