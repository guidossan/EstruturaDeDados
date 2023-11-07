public class Bubblesort {
    int[]vetor;
    int tamanho;

    public Bubblesort() {
    }

    public static int tamanho(int[]vetor){
        int tamanho = 0;
        for (int elemento : vetor) {
            tamanho++;
        }
        return tamanho;
    }
    public static void bubblesort(int[]vetor){
        int n = tamanho(vetor);
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < (n-i); j++){
                if(vetor[j-1]> vetor[j]){
                    temp       = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j]   = temp;
                }
            }
        }
    }

    public static void printar(int[]vetor){
        for (int i = 0; i < tamanho(vetor); i++) {
            int info = vetor[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
    }

}
