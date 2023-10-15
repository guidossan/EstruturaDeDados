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
    public void calcBalanceamento(){
        if(this.esquerdo == null && this.direito == null){
            this.balanceamento=0;//sem filhos
        } else if (this.esquerdo != null && this.direito == null) {
            this.balanceamento = this.esquerdo.calcAltura();//filho esquerdo
        } else if (this.esquerdo == null && this.direito != null) {
            this.balanceamento = 0 - this.direito.calcAltura();//filho direito
        }else {
            this.balanceamento = this.direito.calcAltura() - this.esquerdo.calcAltura();//se houver os dois
        }
        if(this.esquerdo!=null){
            this.esquerdo.calcBalanceamento();
        }
        if(this.direito!=null){
            this.direito.calcBalanceamento();
        }

    }
    public int calcAltura() {
        if(this.esquerdo == null && this.direito == null){
            return 1;
        } else if (this.esquerdo != null && this.direito == null) {
            return 1 +this.esquerdo.calcAltura();
        } else if (this.esquerdo == null && this.direito != null) {
            return 1 +this.direito.calcAltura();
        }else {
            return 1 + Math.max(this.esquerdo.calcAltura(),this.direito.calcAltura());
        }
    }


    public String toStrinG(){
        return "("+this.balanceamento+")";
    }

    public void setBalanceamento(int balanceamento){
        this.balanceamento = balanceamento;
    }
    public int getBalanceamento(){
        return balanceamento;
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
