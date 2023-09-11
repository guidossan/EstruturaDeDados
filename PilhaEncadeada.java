
import java.util.Scanner;
    public class PilhaEncadeada {
        private Node primeiro;
        private Node ultimo;


        public PilhaEncadeada(){
            this.primeiro = null;
            this.ultimo = null;

        }

        //Inserindo elementos
        public void empilhar (int informacao){
            Node no = new Node(informacao);
            // Se essa nova inserção for a primeira da lista
            if(primeiro == null){
                primeiro=no;
                ultimo=no;
            }else{
                //Aqui se cria um apontador para a lista.
                no.setProximo(ultimo);
                ultimo=no;
            }

        }

        public void remover(){
            System.out.println("Dado removido: " + ultimo.getDado());
            ultimo = ultimo.getProximo();
            imprime();
        }

        //Imprimindo elementos
        public void imprime(){

            System.out.println("\nFila encadeada:");

            Node atual = ultimo;

            while (atual != null) {

                System.out.print(atual.getDado()+ " -> ");
                atual= atual.getProximo();

            }

            System.out.print("Fim da pilha");

        }

        public Node getPrimeiro(){

            return primeiro;

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
            fila.remover();

        }

    }


