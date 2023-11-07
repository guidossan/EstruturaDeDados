public class Quicksort {
    int tamanho;
    int[]x;

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
        int pivo;
        if (inferior >= superior) // o array está ordenado
            return;
        // encontra a posição correta para o pivo
        // o pivo pode ser considerado, por exemplo, o primeiro elemento do array
        pivo = particiona(x, inferior, superior);
        // executa o mesmo proced. sobre as subarrays à esquerda e à direita do pivo
        quick(x, inferior, pivo -1);
        quick(x, pivo + 1,superior);
    }

    private static int particiona(int[] x, int inferior, int superior) {
        int pivot = x[superior];
        int i = inferior - 1;
        for (int j = inferior; j  <superior; j++) {
            if (x[j] < pivot) {
                i++;
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }

        int temp = x[i + 1];
        x[i + 1] = x[superior];
        x[superior] = temp;
        return i + 1;
    }
    public static void quickSort(int []x) {
        quick(x, 0, tamanho(x) - 1);
    }
    public static void printar(int[]vetor){
        for (int i = 0; i < tamanho(vetor); i++) {
            int info = vetor[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
    }
}
