
import java.util.Scanner;


    public class PilhaEncadeada {
        private Node Pilha;
        private int topo;
        public PilhaEncadeada(){
            this.topo = -1;
            this.Pilha = null;
        }

        //Inserindo elementos
        public void empilhar (int informacao){
            //Declarando nosso novo nó
            Node no = new Node();

            no.setInformacao(informacao);
            if(Pilha == null){
                topo++;
                Pilha = no;
            }
            else{
                //Aqui se cria um apontador para a lista.
                Node atual = Pilha;
                while(atual.getProximo()!=null){
                    atual = atual.getProximo();
                }
                atual.setProximo(no);
                topo++;
            }
        }
        public void desempilhar(){
            Node atual = Pilha;
            int contador = 0;
            if (atual.getProximo() == null) {
                Pilha = null;
                System.out.println("Pilha vazia");
                return;
            }
            while(atual.getProximo().getProximo()!= null){
                contador++;
                atual = atual.getProximo();
            }
            atual.setProximo(null);
            topo = -1;
        }

        //Imprimindo elementos
        public void imprime(){
            Node atual = Pilha;
            while (atual != null) {
                System.out.print(atual.getInformacao()+ " -> ");
                atual= atual.getProximo();
            }
            System.out.println("Null");


        }


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            PilhaEncadeada pilha = new PilhaEncadeada();
            while(true){
                System.out.println("Digite oque deseja fazer");
                System.out.println("1- Empilhar. 2- Desempilhar 3- Pilha");
                int opcao;
                opcao = scanner.nextInt();
                if(opcao == 1){
                    System.out.println("Digite os itens da lista (digite '0' para parar):");
                    int item;
                    while (true) {
                        item = scanner.nextInt();
                        if (item == 0) {
                            break;
                        }
                        pilha.empilhar(item);
                    }
                    System.out.println("Lista Encadeada:");
                    pilha.imprime();

                }
                if(opcao == 2){
                    pilha.desempilhar();
                    System.out.println("Lista Encadeada:");
                    pilha.imprime();
                }
                if(opcao == 3){
                    System.out.println("Pilha Encadeada:");
                    pilha.imprime();

                }
                if(opcao == 0){
                    break;
                }

            }
        }

    }


