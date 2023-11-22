package Hash;

public class tabelaHashDobra {
    int tamanho = 0;
    int posicaoHash;
    Node[] tabela;
    Node contador;

    public tabelaHashDobra(int tamanho) {
        setTamanho(tamanho);
        this.tabela = new Node[tamanho];

        for (int i = 0; i < tamanho; i++) {
            if(i == 0){
                tabela[i] = posicao(0);
            }else{
                tabela[i] = posicao(i);
            }

        }
    }
    public Node posicao(int p){
        contador = new Node(p);
        return contador;


    }
    public int getTamanho(){
            return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void insereHash(int registro){
        int Part1 = (registro / getTamanho())%getTamanho();
        int Part2 = registro % getTamanho();
        int juncao = Part1 + Part2;
        int posicaoHash = juncao % getTamanho();
        Node no = new Node(registro);
        Node noAtual = tabela[posicaoHash];
        if (noAtual == null) {
            tabela[posicaoHash] = no;
        } else {
            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
            }
            noAtual.setProximo(no);
        }
    }


    public void buscar(int registro){
        float A = 0.6180339887f;
        float var = registro * A;
        var = var - (int)var;
        posicaoHash = (int) (tamanho * var);
        Node noBuscado = tabela[posicaoHash];
        long startTime = System.nanoTime();
        if (noBuscado != null) {
            System.out.print(noBuscado.getDado());
            Node proximo = noBuscado.getProximo();
            if (proximo != null) {
                System.out.print("Dado:" + proximo.getDado());
                System.out.println("Posicao:" + posicaoHash);
                long endTime = System.nanoTime();
                double tempoExecucao = (endTime - startTime) / 1_000_000.0;
                System.out.println("O tempo de execução para buscar o dado foi de: " + tempoExecucao);
            }
        }
        System.out.println();
    }
    public void imprimeTabela(){
        for (int i = 0; i < tamanho; i++) {
            Node node = tabela[i];
            while (node != null) {
                System.out.print(node.getDado() + " -> ");
                node = node.getProximo();
            }
            System.out.println("null"); // Marca o final da lista na posição
        }
    }


}
