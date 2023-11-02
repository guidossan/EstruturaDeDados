package Hash;

public class Node {
    private Integer informacao;
    private Node proximo;

    public Node(int informacao){
        this.informacao = informacao;
        this.proximo = null;
    }

    public Integer getDado() {
        return informacao;
    }

    public void setDado(Integer informacao) {
        this.informacao = informacao;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
