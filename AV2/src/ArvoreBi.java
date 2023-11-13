public class ArvoreBi {
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
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getEsquerdo();
                }
            } else if (informacao >= noAtual.getDado()) {
                if (noAtual.getDireito() == null) {
                    noAtual.setDireito(novoNo);
                    return; // Inseriu o nó e sai do loop
                } else {
                    noAtual = noAtual.getDireito();
                }
            } else {
                return;
            }
        }
    }

        public void remover ( int valorRomover) {
            Node pai = null;
            Node filhoRE = raiz;
            while (filhoRE.getDado() != valorRomover) {
                pai = filhoRE;
                if (valorRomover >= filhoRE.getDado()) {
                    filhoRE = filhoRE.getDireito();
                } else {
                    filhoRE = filhoRE.getEsquerdo();
                }
            }
            //tem dois filhos
            if(filhoRE.getDireito() != null && filhoRE.getEsquerdo() != null){
                Node substituto = filhoRE.getDireito();
                Node paiSubstituto = filhoRE;
                while(substituto.getEsquerdo() !=null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerdo();//vai para esquerda para pegar o mais proximo do valorRemover
                }
                substituto.setEsquerdo(filhoRE.getEsquerdo());
                if(pai != null){
                    //substitui o filhoRE pelo substituto
                    if (filhoRE.getDado() >= pai.getDado()){
                        pai.setDireito(substituto);
                    }else{
                        pai.setEsquerdo(substituto);
                    }
                }else{//e a raiz
                    this.raiz = substituto;
                }

                //remove elemento da arvore
                if (substituto.getDado() >= paiSubstituto.getDado()){
                    paiSubstituto.setDireito(null);
                }else{
                    paiSubstituto.setEsquerdo(null);
                }
            }else if(filhoRE.getDireito() !=null){//tem filho direito
                Node substituto = filhoRE.getDireito();
                Node paiSubstituto = filhoRE;
                while(substituto.getEsquerdo() !=null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerdo();//vai para esquerda para pegar o mais proximo do valorRemover
                }
                if(pai != null){
                    //substitui o filhoRE pelo substituto
                    if (filhoRE.getDado() >= pai.getDado()){
                        pai.setDireito(substituto);
                    }else{
                        pai.setEsquerdo(substituto);
                    }
                }else{//e a raiz
                    this.raiz = substituto;
                }

                //remove elemento da arvore
                if (substituto.getDado() >= paiSubstituto.getDado()){
                    paiSubstituto.setDireito(null);
                }else{
                    paiSubstituto.setEsquerdo(null);
                }
            }else if(filhoRE.getEsquerdo()!=null){//tem filho esquerdo
                Node substituto = filhoRE.getEsquerdo();
                Node paiSubstituto = filhoRE;
                while(substituto.getDireito() !=null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireito();
                }
                if(pai != null) {
                    //substitui o filhoRE pelo substituto
                    if (filhoRE.getDado() >= pai.getDado()) {
                        pai.setDireito(substituto);
                    } else {
                        pai.setEsquerdo(substituto);
                    }
                }else {
                    this.raiz = substituto;
                }
                //remove elemento da arvore
                if (substituto.getDado() >= paiSubstituto.getDado()){
                    paiSubstituto.setDireito(null);
                }else{
                    paiSubstituto.setEsquerdo(null);
                }
            }else {//nao tem filhos
                if(pai != null) {
                    if (filhoRE.getDado() >= pai.getDado()) {
                        pai.setDireito(null);
                    } else {
                        pai.setEsquerdo(null);
                    }
                }else {
                    this.raiz = null;
                }
            }
        }
    public void imprimir() {
        imprimirArvore(raiz, "",false);
    }

    private void imprimirArvore(Node no, String prefix, boolean isLeft) {
        if (no != null) {
            System.out.println(prefix + (isLeft ? "├─ " : "└─ ") + no.getDado());

            imprimirArvore(no.getEsquerdo(), prefix + (isLeft ? "│  " : "   "), true);
            imprimirArvore(no.getDireito(), prefix + (isLeft ? "│  " : "   "), false);
        }
    }

}
