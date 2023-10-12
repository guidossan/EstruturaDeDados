import java.util.Stack;
public class ArvoreAVL {
    public Node raiz;
    public void inserir(int informacao) {
        Node novoNo = new Node(informacao);

        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        Node noAtual = raiz;

        while (true) {
            if (informacao < noAtual.getDado()) {
                if (noAtual.getEsquerdo() == null) {
                    noAtual.setEsquerdo(novoNo);
                    raiz.calcBalanceamento();
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getEsquerdo();
                }
            } else if (informacao >= noAtual.getDado()) {
                if (noAtual.getDireito() == null) {
                    noAtual.setDireito(novoNo);
                    raiz.calcBalanceamento();
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getDireito();
                }
            } else {
                return;
            }
        }
    }
//    public void calcBalanceamento(){
//        while(raiz!=null){
//            Node atual = raiz;
//            if(atual.getEsquerdo() == null && atual.getDireito() == null){
//                atual.setBalanceamento(0);
//            } else if (atual.getEsquerdo() != null && atual.getDireito() == null)
//                atual.setBalanceamento(1);
//            else if (atual.getEsquerdo() == null && atual.getDireito() != null) {
//                atual.setBalanceamento(-1);
//            }
//            atual.setBalanceamento((atual.getEsquerdo().calcBalanceamento()) + (atual.getDireito().calcBalanceamento())-1);
//        }



//    }

//        public void remover ( int valorRomover){
//            Node atual = raiz;
//            while (atual != null) {
//                if (raiz == null) {
//                    System.out.println("Valor nao encontrado");
//                } else {
//                    if (raiz.getDado() == valorRomover) {
//                        raiz = raiz.getDireito();
//                    } else {
//                        if (valorRomover < raiz.getDado()) {
//                            atual = raiz.getEsquerdo();
//                        } else if (valorRomover >= raiz.getDado()) {
//                            atual = raiz.getDireito();
//                        }
//                    }
//                }
//
//            }
//        }

//        public void balancear (Node atual){
//            int fb = fatorBalanciamento(atual);
//            if (fb == -2) {
//                rotacionarEsquerda(atual);
//            } else if (fb == 2) {
//                rotacionarDireita(atual);
//            }
//        }
//        public int fatorBalanciamento (Node no){
//            if (no.getEsquerdo() == null && no.getDireito() == null) {
//                return 0;
//            } else if (no.getEsquerdo() != null && no.getDireito() == null) {
//                return 1;
//            } else if (no.getDireito() != null && no.getEsquerdo() == null) {
//                return -1;
//            }
//            return 1 + Math.max(fatorBalanciamento(no.getEsquerdo()), fatorBalanciamento(no.getDireito()));
//        }
//        public void rotacionarEsquerda (Node no){
//            Node novaRaiz = no.getDireito();
//            Node temp = no.getDireito().getEsquerdo();
//            novaRaiz.setEsquerdo(no);
//            novaRaiz.getEsquerdo().setDireito(temp);
//
//
//        }
//        public void rotacionarDireita (Node no){
//            Node novaRaiz = no.getEsquerdo();
//            Node temp = no.getEsquerdo().getDireito();
//            novaRaiz.setDireito(no);
//            novaRaiz.getDireito().setDireito(temp);
//
//
//        }
//        public void rotacaoDireitaEsquerda (Node no){
//            no.setDireito(no.getDireito().getEsquerdo());
//            rotacionarEsquerda(no);
//        }
//        public void rotacaoEsquerdaDireita (Node no){
//            no.setEsquerdo(no.getEsquerdo().getDireito());
//            rotacionarDireita(no);
//        }
//    public boolean isEmpty() {
//        return raiz == null;
//    }

    public void imprimir() {
        imprimirArvore(raiz, "",false);
        System.out.println(raiz.getBalanceamento());
    }

    private void imprimirArvore(Node no, String prefix, boolean isLeft) {
        if (no != null) {
            System.out.println(prefix + (isLeft ? "├─ " : "└─ ") + no.getDado());

            imprimirArvore(no.getEsquerdo(), prefix + (isLeft ? "│  " : "   "), true);
            imprimirArvore(no.getDireito(), prefix + (isLeft ? "│  " : "   "), false);
        }
    }









}
