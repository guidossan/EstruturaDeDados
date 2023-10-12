import java.util.Stack;
public class ArvoreAVL {
    public Node raiz;
    public ArvoreAVL inserir(int informacao) {
        Node no = new Node(informacao);

        if(raiz == null){
            raiz = no;
        }

        Node noAtual = raiz;

        while(true){
            Node pai = noAtual;

            if(informacao < noAtual.getDado()){
                noAtual = noAtual.getEsquerdo();
                if (noAtual == null) {
                    pai.setEsquerdo(no);
                    break;
                }
            } else if(informacao >= noAtual.getDado()){
                noAtual = noAtual.getDireito();
                if (noAtual == null) {
                    pai.setDireito(no);
                    break;
                }
            }
        }
        return this;
    }

    public void remover(int valorRomover){
        Node atual = raiz;
        while(atual!=null){
            if(raiz == null){
                System.out.println("Valor nao encontrado");
            }else{
                if(raiz.getDado()==valorRomover){
                    raiz = raiz.getDireito();
                }else{
                    if(valorRomover < raiz.getDado()){
                        atual = raiz.getEsquerdo();
                    }else if(valorRomover >= raiz.getDado()){
                        atual = raiz.getDireito();
                    }
                }
            }

        }
    }

    public void balancear(Node atual){
        int fb = fatorBalanciamento(atual);
        if(fb == -2){
            rotacionarEsquerda(atual);
        }else if(fb == 2){
            rotacionarDireita(atual);
        }
    }
    public int fatorBalanciamento(Node no){
        if(no.getEsquerdo()==null && no.getDireito()==null){
            return 0;
        }else if(no.getEsquerdo()!=null && no.getDireito()==null) {
            return 1;
        }else if(no.getDireito()!=null &&no.getEsquerdo()==null){
            return -1;
        }
        return 1+ Math.max(fatorBalanciamento(no.getEsquerdo()),fatorBalanciamento(no.getDireito()));
    }
    public void rotacionarEsquerda(Node no){
        Node novaRaiz = no.getDireito();
        Node temp = no.getDireito().getEsquerdo();
        novaRaiz.setEsquerdo(no);
        novaRaiz.getEsquerdo().setDireito(temp);


    }
    public void rotacionarDireita(Node no){
        Node novaRaiz = no.getEsquerdo();
        Node temp = no.getEsquerdo().getDireito();
        novaRaiz.setDireito(no);
        novaRaiz.getDireito().setDireito(temp);


    }
    public void rotacaoDireitaEsquerda(Node no){
        no.setDireito(no.getDireito().getEsquerdo());
        rotacionarEsquerda(no);
    }
    public void rotacaoEsquerdaDireita(Node no){
        no.setEsquerdo(no.getEsquerdo().getDireito());
        rotacionarDireita(no);
    }

    public void imprimir() {
        imprimirArvore(raiz, "", false);
    }

    private void imprimirArvore(Node no, String prefix, boolean isEsquerdo) {
        if (no != null) {
            System.out.print(prefix);
            System.out.print(isEsquerdo ? "├─ " : "└─ ");
            System.out.println(no.getDado());

            imprimirArvore(no.getDireito(), prefix + (isEsquerdo ? "│  " : "   "), true);
            imprimirArvore(no.getEsquerdo(), prefix + (isEsquerdo ? "│  " : "   "), false);
        }
    }



}
