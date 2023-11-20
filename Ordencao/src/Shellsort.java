public class Shellsort {
    int tamanho;
    int [] vetor;
    public static int tamanho(int[]vetor){
        int tamanho = 0;
        for (int elemento : vetor) {
            tamanho++;
        }
        return tamanho;
    }

    public static void shellsort(int[]vetor){
        int n = tamanho(vetor);
        int temp = 0;
        int iteracao =0;
        for(int mid = n/2; mid > 0; mid /=2){
            for(int i = mid; i < n; i++){
                temp       = vetor[i];
                int j;
                for ( j = i; j >= mid && vetor[j- mid] > temp; j = j- mid)
                    vetor[j] = vetor[j - mid];
                vetor[j] = temp;
                iteracao++;
                printar(vetor, iteracao);
            }
        }
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
