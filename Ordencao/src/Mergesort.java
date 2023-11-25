public class Mergesort {
    int[]a;
    int iteracao=0;
    int trocas =0;

    public static int tamanho(int[]a){
        int tamanho = 0;
        for (int elemento : a) {
            tamanho++;
        }
        return tamanho;
    }
    public static void mergeSort(int[] a, int n, int iteracao) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        //dividir em listas menores
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        iteracao++;
        //dividir em array menores para comparacao e ordenação desses menores
        mergeSort(l, mid,iteracao);
        mergeSort(r, n - mid,iteracao);

        merge(a, l, r, mid, n - mid, iteracao);

    }
    public static void merge(int[] a, int[] l, int[] r, int left, int right, int iteracao) {
        int i = 0, j = 0, k = 0;
        int trocas =0;
        while (i < left && j < right) {
            //faz o merge
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
            trocas++;
            iteracao++;
        }

        //caso ainda hava nas listas l e r
        while (i < left) {
            a[k++] = l[i++];
            iteracao++;
        }
        while (j < right) {
            a[k++] = r[j++];
            iteracao++;
        }
        printar(a, iteracao, trocas);
    }
    public static void fazMerge(int[]a){

        mergeSort(a,tamanho(a), 0);
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
