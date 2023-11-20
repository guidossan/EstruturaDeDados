public class Quicksort {
    int tamanho;
    int[]x;
    static int iteracao = 0;

    public Quicksort() {
    }

    public static int tamanho(int[]x){
        int tamanho = 0;
        for (int elemento : x) {
            tamanho++;
        }
        return tamanho;
    }
    public static void quick(int []x, int inferior, int superior){

    }

    private static int particiona(int[] x, int inferior, int superior,int iteracao) {


    }
    public static void quickSort(int []x) {

    }
    public static void printar(int[]vetor, int iteracao){
        for (int i = 0; i < tamanho(vetor); i++) {
            int info = vetor[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
        System.out.println("Iteração: " + iteracao);
    }
}
