public class PilhaEncadeada {
        private Node base;
        private Node topo;


        public PilhaEncadeada(){
            this.base = null;
            this.topo = null;

        }

        //Inserindo elementos
        public void empilhar (int informacao){
            Node no = new Node(informacao);
            // Se essa nova inserção for a primeira da lista
            if(base == null){
                base=no;
                topo=no;
            }else{
                //Aqui se cria um apontador para a lista.
                no.setProximo(topo);
                topo=no;
            }

        }

        public void desempilhar(){
            topo = topo.getProximo();
            imprime();
        }

        //Imprimindo elementos
        public void imprime(){
            Node atual = topo;
            if(atual==null){
                System.out.print("|" + "-" + "|" + "\n");
            }
            while(atual!=null) {
                System.out.print("|" + atual.getDado() + "|" + "\n");
                atual = atual.getProximo();
            }
        }
        public boolean estavazia(){
            if(topo == null){
                return true;
            }
            return false;
        }


        public Node getPrimeiro(){
            return base;
        }
        public Node getTopo(){
            return topo;
        }
        public static void main(String[] args){
            PilhaEncadeada fila = new PilhaEncadeada();
            fila.empilhar(2);
            fila.empilhar(3);
            fila.empilhar(255);
            fila.empilhar(32);
            fila.empilhar(1);
            fila.empilhar(5);
            fila.empilhar(90);
            fila.imprime();
            fila.desempilhar();

        }





}
