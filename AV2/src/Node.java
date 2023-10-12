public class Node {
    private Integer informacao;
    private Node esquerdo;
    private Node direito;
    private int altura;
    public int balanceamento;

    public Node(int informacao) {
        this.informacao = informacao;
        this.esquerdo = null;
        this.direito = null;
        this.altura = 0;
        this.balanceamento = 0;
    }
    public int calcBalanceamento(){
        int alturaEsquerda = (this.getEsquerdo() != null) ? this.esquerdo.calcAltura() : -1;
        int alturaDireita = (this.getDireito() != null) ? this.direito.calcAltura() : -1;
        int balanceamentoA = alturaEsquerda - alturaDireita;
        setBalanceamento(balanceamentoA);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    public int calcAltura() {
        int alturaEsquerda = (this.esquerdo != null) ? this.esquerdo.calcAltura() : 0;
        int alturaDireita = (this.direito != null) ? this.direito.calcAltura() : 0;

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }


    public String toString(){
        return "["+this.getDado()+"]("+this.balanceamento+")";
    }

    public void setBalanceamento(int balanceamento){
        this.balanceamento = balanceamento;
    }
    public int getAltura(){
        return altura;
    }

    public Integer getDado() {
        return informacao;
    }

    public void setDado(Integer informacao) {
        this.informacao = informacao;
    }

    public Node getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Node proximo) {
        this.esquerdo = proximo;
    }

    public Node getDireito() {
        return direito;
    }

    public void setDireito(Node proximo) {
        this.direito = proximo;
    }
}
