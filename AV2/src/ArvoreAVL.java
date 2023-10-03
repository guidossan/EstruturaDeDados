public class ArvoreAVL {
    public Node raiz;
    public void inserir(int informacao){
        Node no = new Node(informacao);

        if(raiz == null){
            raiz=no;
        } else{
            if(informacao >= raiz.getDado()){
                raiz.setDireito(no);
            }else if(informacao < raiz.getDado()){
                raiz.setEsquerdo(no);
            }
        }
    }
    public void remover(){

    }
    public void rotacionarEsquerda(Node no){
        Node novaRaiz = no.getDireito();
        Node temp = no.getDireito().getEsquerdo();
        novaRaiz.setEsquerdo(no);
        novaRaiz.getEsquerdo().setDireito(temp);

        novaRaiz.getEsquerdo().setAltura(novaRaiz.getEsquerdo().maior(novaRaiz.getEsquerdo().altura(novaRaiz.getEsquerdo().getEsquerdo()), novaRaiz.altura(novaRaiz.getDireito().getDireito()))+1);
        novaRaiz.setAltura(novaRaiz.maior(novaRaiz.altura(novaRaiz.getEsquerdo()), novaRaiz.altura(novaRaiz.getDireito()))+1);
    }
    public void rotacionarDireita(Node no){
        Node novaRaiz = no.getEsquerdo();
        Node temp = no.getEsquerdo().getDireito();
        novaRaiz.setDireito(no);
        novaRaiz.getDireito().setDireito(temp);

        novaRaiz.getDireito().setAltura(novaRaiz.getDireito().maior(novaRaiz.getDireito().altura(novaRaiz.getDireito().getDireito()), novaRaiz.altura(novaRaiz.getEsquerdo().getEsquerdo()))+1);
        novaRaiz.setAltura(novaRaiz.maior(novaRaiz.altura(novaRaiz.getDireito()), novaRaiz.altura(novaRaiz.getEsquerdo()))+1);
    }
    public void rotacaoDireitaEsquerda(Node no){
        no.setDireito(no.getDireito().getEsquerdo());
        rotacionarEsquerda(no);
    }
    public void rotacaoEsquerdaDireita(Node no){
        no.setEsquerdo(no.getEsquerdo().getDireito());
        rotacionarDireita(no);
    }
}
