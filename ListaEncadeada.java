import java.util.Scanner;
public class ListaEncadeada {
        private Node Lista;
        public ListaEncadeada(){
            this.Lista = null;
        }

        //Inserindo elementos
        public void inserir (int informacao){
            //Declarando nosso novo nó
            Node no = new Node();
            no.setInformacao(informacao);
            if(Lista == null){
                Lista=no;
            }
            else{
                //Aqui se cria um apontador para a lista.
                Node atual =Lista;
                while(atual.getProximo()!=null){
                    atual = atual.getProximo();
                }
                atual.setProximo(no);
            }
        }

        public void remover(){
            Lista = Lista.getProximo();//define o primeiro (Lista) sendo o segundo(Lista.getProximo())

        }

        //Imprimindo elementos
        public void imprime(){
            Node atual = Lista;
            while (atual != null) {
                System.out.print(atual.getInformacao()+ " -> ");
                atual= atual.getProximo();
            }
            System.out.println("Null");


        }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();
        while(true){
            System.out.println("Digite oque deseja fazer");
            System.out.println("1- Insere. 2- Remover 3- Mostra Lista");
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
                    lista.inserir(item);
                }
                System.out.println("Lista Encadeada:");
                lista.imprime();

            }
            if(opcao == 2){
                lista.remover();
                System.out.println("Lista Encadeada:");
                lista.imprime();
            }
            if(opcao == 3){
                System.out.println("Lista Encadeada:");
                lista.imprime();

            }
            if(opcao == 0){
                break;
            }

        }
    }

    }

