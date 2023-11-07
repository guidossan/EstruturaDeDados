public class Mergesort {
    int[]a;
    public static int tamanho(int[]a){
        int tamanho = 0;
        for (int elemento : a) {
            tamanho++;
        }
        return tamanho;
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        //cria e desloca os elementos para os outros array para ordenacao
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public static void fazMerge(int[]a){
        mergeSort(a,tamanho(a));
    }
    public static void printar(int[]a){
        for (int i = 0; i < tamanho(a); i++) {
            int info = a[i];
            System.out.print(info + " -> ");
        }
        System.out.println();
    }

}
