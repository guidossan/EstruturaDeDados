package Hash;
public class tabelaHash{
    int tamanho = 0;
    int posicaoHash;
    Node[] tabela;
    Node contador;

    public tabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Node[tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int p = 1; p<tamanho; p++) {
                tabela[i] = posicao(p);
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
    public void insereHash(int registro){
        posicaoHash = registro % tamanho;
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
        posicaoHash = registro % tamanho;
        Node noBuscado = tabela[posicaoHash];
        if (noBuscado != null) {
            System.out.print(noBuscado.getDado());
            Node proximo = noBuscado.getProximo();
            if (proximo != null) {
                System.out.print(proximo.getDado());
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