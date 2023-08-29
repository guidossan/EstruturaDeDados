
    public class Pilha {

        private int topo;
        private int dado[];
        public Pilha(){
            this.topo = -1;
            dado = new int[5];
        };
        public void empilhar(int valor){
            if(topo<dado.length){
                topo++;
                dado[topo]=valor;
            }else{
                System.out.println("Pilha cheia");
            }

        }

        public void vazia(){
            if(topo == -1){
                System.out.println("Pilha vazia");
            }else {
                System.out.println("Valor do topo: " + dado[topo]);;
            }
        }
        public void imprimepilha(){
            for (int i = topo; i > -1; i--) {
                System.out.println(dado[i]);
            }
        }

}
