package Hash;

import java.util.Random;

public class Main {
    public static void main(String [] args){

        insereTabelaResto(100,200);
//        insereTabelaResto(100,20000);
//        insereTabelaResto(1000,1000000);
//        insereTabelaResto(10000,11000000);

        insereTabelaMult(100,200);
//        insereTabelaMult(100,20000);
//        insereTabelaMult(1000,1000000);
//        insereTabelaMult(10000,11000000);

        insereTabelaDobra(100,200);
//        insereTabelaMult(100,20000);
//        insereTabelaMult(1000,1000000);
//        insereTabelaMult(10000,11000000);

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
    public static void insereTabelaResto(int tamanhoTabela, int numRegistros){
        tabelaHashResto tabela = new tabelaHashResto(tamanhoTabela);
        tabela.insereHashResto(459001);
        tabela.insereHashResto(132002);
        tabela.insereHashResto(449003);
        tabela.insereHashResto(923004);
        tabela.insereHashResto(459005);
        tabela.insereHashResto(459006);
        tabela.insereHashResto(59007);
        tabela.insereHashResto(301001);
        tabela.insereHashResto(123001);
        tabela.insereHashResto(234005);
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < numRegistros; i++) {
            int numeroAleatorio = random.nextInt(900000) + 100000;
            tabela.insereHashResto(numeroAleatorio);
        }
        long endTime = System.nanoTime();
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
        tabela.imprimeTabela();
        System.out.println("Tempo de execução para tabela por resto de tamanho " + tamanhoTabela + ": " + tempoExecucao + " milissegundos");
        tabela.buscar(34005);
        tabela.buscar(59007);
        tabela.buscar(59001);
        tabela.buscar(32002);
        tabela.buscar(59006);
    }
    public static void insereTabelaMult(int tamanhoTabela, int numRegistros){
        tabelaHashMult tabela = new tabelaHashMult(tamanhoTabela);
        tabela.insereHash(459001);
        tabela.insereHash(132002);
        tabela.insereHash(449003);
        tabela.insereHash(923004);
        tabela.insereHash(459005);
        tabela.insereHash(459006);
        tabela.insereHash(459007);
        tabela.insereHash(301001);
        tabela.insereHash(123001);
        tabela.insereHash(234005);
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < numRegistros; i++) {
            int numeroAleatorio = random.nextInt(900000) + 100000;
            tabela.insereHash(numeroAleatorio);
        }
        long endTime = System.nanoTime();
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
        tabela.imprimeTabela();
        System.out.println("Tempo de execução para tabela por multiplicacao de tamanho " + tamanhoTabela + ": " + tempoExecucao + " milissegundos");
        tabela.buscar(234005);
        tabela.buscar(459007);
        tabela.buscar(459001);
        tabela.buscar(132002);
        tabela.buscar(459006);
    }
    public static void insereTabelaDobra(int tamanhoTabela, int numRegistros){
        tabelaHashDobra tabela = new tabelaHashDobra(tamanhoTabela);
        tabela.insereHash(459001);
        tabela.insereHash(132002);
        tabela.insereHash(449003);
        tabela.insereHash(923004);
        tabela.insereHash(459005);
        tabela.insereHash(459006);
        tabela.insereHash(459007);
        tabela.insereHash(301001);
        tabela.insereHash(123001);
        tabela.insereHash(234005);
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < numRegistros; i++) {
            int numeroAleatorio = random.nextInt(900000) + 100000;
            tabela.insereHash(numeroAleatorio);
        }
        long endTime = System.nanoTime();
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
        tabela.imprimeTabela();
        System.out.println("Tempo de execução para tabela por multiplicacao de tamanho " + tamanhoTabela + ": " + tempoExecucao + " milissegundos");
        tabela.buscar(234005);
        tabela.buscar(459007);
        tabela.buscar(459001);
        tabela.buscar(132002);
        tabela.buscar(459006);
    }
}
