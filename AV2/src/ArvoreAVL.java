public class ArvoreAVL {
    public Node raiz;
    public void inserir(int informacao) {
        Node no = new Node(informacao);

        if(raiz == null){
            raiz = no;
            return;
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
        balancear(raiz);
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
    public void balancear(Node raiz){
        int fb = fatorBalanciamento(raiz);
        if(fb < -1 && fatorBalanciamento(raiz.getDireito())<=0){
            rotacionarEsquerda(raiz);
        } else if (fb >1 && fatorBalanciamento(raiz.getDireito())>=0){
            rotacionarEsquerda(raiz);
        } else if (fb >1 && fatorBalanciamento(raiz.getDireito())<0){
            rotacionarEsquerda(raiz);
        } else if (fb <-1 && fatorBalanciamento(raiz.getDireito())>0){
            rotacionarEsquerda(raiz);
        }
    }
    public int fatorBalanciamento(Node no){
        if (no!=null) {
            return no.altura(no.getEsquerdo())-no.altura(no.getDireito());
        } else {
            return 0;
        }
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
