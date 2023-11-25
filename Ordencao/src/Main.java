public class Main {
    public static void main(String[] args) {
        int []lista = new int[10000];

        for (int j = 0;j<lista.length;j++){
            int x = (int)Math.round(Math.random() * 99);
            lista[j] = x;
        }

//        long startTime = System.nanoTime();
//        Bubblesort.bubblesort(lista);
//        long endTime = System.nanoTime();
//        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
//        System.out.println("Tempo de execução para bubblesort " + tempoExecucao + " milissegundos");
//
        long startTime = System.nanoTime();
        Shellsort.shellsort(lista);
        long endTime = System.nanoTime();
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
        System.out.println("Tempo de execução para tabela para qshellsort " + tempoExecucao + " milissegundos");


//        long startTime = System.nanoTime();
//        Mergesort.fazMerge(lista);
//        long endTime = System.nanoTime();
//        double tempoExecucao = (endTime - startTime) / 1_000_000.0;
//        System.out.println("Tempo de execução para tabela para mergesort " + tempoExecucao + " milissegundos");


    }

}