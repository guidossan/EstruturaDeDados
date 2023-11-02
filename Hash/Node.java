package Hash;

public class Node {
    private Integer registro;
    private Node proximo;

    public Node(int informacao){
        this.registro = informacao;
        this.proximo = null;
    }
    public Node(){
        this.registro = null;
        this.proximo = null;
    }

    public Integer getDado() {
        return registro;
    }

    public void setDado(Integer informacao) {
        this.registro = informacao;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
