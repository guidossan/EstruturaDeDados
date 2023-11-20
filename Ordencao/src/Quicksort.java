public class Quicksort {
    int tamanho;
    int[]vetor;
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
    public static void quick(int []vetor, int inferior, int superior){
        int pivo;
        if (inferior >= superior) // o array está ordenado
            return;
        // encontra a posição correta para o pivo
        // o pivo pode ser considerado, por exemplo, o primeiro elemento do array
        pivo = particiona(vetor, inferior, superior);
        // executa o mesmo proced. sobre as subarrays à esquerda e à direita do pivo
        quick(vetor, inferior, pivo -1);
        quick(vetor, pivo + 1,superior);

    }

    private static int particiona(int[] x, int inferior, int superior) {
        int inicio = inferior;
        int fim = superior;
        while(inicio < fim){
            if(inicio > fim){
                swap(x,inicio,fim);

            }
        }
        return inicio;

    }
    public static void quickSort(int []x) {
        quick(x,x[0],x[tamanho(x)-1]);
    }
    public static void printar(int[]vetor, int iteracao){
        for (int i = 0; i < tamanho(vetor); i++) {
            int info = vetor[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
        System.out.println("Iteração: " + iteracao);
    }
    public static void swap(int []vetor, int a, int b){
        int temp;
        temp       = vetor[a];
        vetor[a] = vetor[b];
        vetor[b]   = temp;
    }
}
