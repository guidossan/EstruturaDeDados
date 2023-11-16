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
        int mid = tamanho(vetor)/2;
        int iteracao =0;
        for(int i = mid; i > 0; i /=2){
            for(int j = i; j <= n; j++){
                temp       = vetor[j];
                //travei aqui
                for(int k = 0; k <= j; k++)
                    if(vetor[k] > temp){
                        vetor[k] = vetor[j];
                        vetor[j]   = vetor[k];
                }
            }
            iteracao++;
            printar(vetor, iteracao);
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
