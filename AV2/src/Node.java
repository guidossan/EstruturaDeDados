public class Node {
    private Integer informacao;
    private Node esquerdo;
    private Node direito;
    private int altura;

    public Node(int informacao) {
        this.informacao = informacao;
        this.esquerdo = null;
        this.direito = null;
        this.altura = 0;
    }
    public int maior(int esquerdo, int direito){
        return esquerdo > direito? esquerdo : direito;
    }
    public int altura(Node no){
        if(no == null){
            return -1;
        } else{
            return no.getAltura();
        }
    }
    public int fatorBalanciamento(Node no){
        if (no!=null) {
            return altura(no.getEsquerdo())-altura(no.getDireito());
        } else {
            return 0;
        }
    }

    public int getAltura(){
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
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
