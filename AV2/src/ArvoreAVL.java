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
                    precisaBalancear();
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getEsquerdo();
                }
            } else if (informacao >= noAtual.getDado()) {
                if (noAtual.getDireito() == null) {
                    noAtual.setDireito(novoNo);
                    raiz.calcBalanceamento();
                    precisaBalancear();
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getDireito();
                }
            } else {
                return;
            }
        }
    }
    public boolean precisaBalancear(){
        int bal = raiz.balanceamento;
        if(bal >=2 ||bal <=-2){
            if(bal == 2){
//                rotacionarEsquerda(raiz);
                System.out.println("Rotacao esquerda");
                imprimir();
                if(raiz.getEsquerdo().balanceamento==-1||raiz.getDireito().balanceamento==-1){
                    System.out.println("duplarotacao esqueda direita");
                }
            }else if(bal == -2){
//                rotacionarDireita(raiz);
                System.out.println("Rotacao direita");
                imprimir();
                if(raiz.getEsquerdo().balanceamento==1||raiz.getDireito().balanceamento==1){
                    System.out.println("duplarotacao direita esquerda");
                }
            }
        }
        return false;
    }

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


//        public Node rotacionarEsquerda (Node no){
//            if(no.getDireito().getEsquerdo()!=null){//diz que .getEsquerdo eh nulo
//                Node novaRaiz = no.getDireito();
//                Node temp = no.getDireito().getEsquerdo();//aqui tambem seria
//                novaRaiz.setEsquerdo(no);
//                novaRaiz.getEsquerdo().setDireito(temp);
//                return novaRaiz;
//            }
//            Node novaRaiz = no.getDireito();
//            novaRaiz.setEsquerdo(no);
//            return novaRaiz;
//        }
//        public Node rotacionarDireita (Node no){
//            if(no.getEsquerdo().getDireito()!=null){
//                Node novaRaiz = no.getEsquerdo();
//                Node temp = no.getEsquerdo().getDireito();
//                novaRaiz.setDireito(no);
//                novaRaiz.getDireito().setDireito(temp);
//                return novaRaiz;
//            }
//            Node novaRaiz = no.getEsquerdo();
//            novaRaiz.setDireito(no);
//            return novaRaiz;
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
