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
        int trocas =0;
        for(int mid = n/2; mid > 0; mid /=2){
            for(int i = mid; i < n; i++){
                temp       = vetor[i];
                int j = i;
                while(j >=mid) {// evita outsofbounds e faz andar conforme mid
                    //pois j = j - mid; ia decrementar para alem do vetor e nao pode
                    if (vetor[j - mid] > temp) {
                        int troc = vetor[j];
                        vetor[j] = vetor[j - mid];
                        vetor[j - mid] = troc;
                        trocas++;
                    }
                    //j = j-mid "zera" j para a proxima iteracao do i e assim realizar a comparacao
                    // na proxima iteracao de i o j vai reaceber i sem fazer  j+=i oque nao seria bom
                    j = j - mid;
                }
                iteracao++;
                printar(vetor, iteracao, trocas);
            }
        }
    }
    public static void swap(int []vetor, int a, int b){
        int temp;
        temp       = vetor[a];
        vetor[a] = vetor[b];
        vetor[b]   = temp;
    }

    public static void printar(int[]vetor, int iteracao, int trocas){
        for (int i = 0; i < tamanho(vetor); i++) {
            int info = vetor[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
        System.out.println("Iteração: " + iteracao);
        System.out.println("Trocas: " + trocas);
    }
}
