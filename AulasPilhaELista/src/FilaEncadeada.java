import java.util.Scanner;
public class FilaEncadeada {
    private Node primeiro;
    private Node ultimo;


//    public void inserirFila(FilaEncadeada filaNova){
//
//        Node.insereNovoElementoNoUltimoNode(primeiro, filaNova.getPrimeiro());
//
//    }
    public FilaEncadeada(){
        this.primeiro = null;
    }

    //Inserindo elementos
    public void inserir (int informacao){
        Node no = new Node(informacao);
        // Se essa nova inserção for a primeira da lista
        if(primeiro == null){
            primeiro=no;
            ultimo=no;
        }else{
            //Aqui se cria um apontador para a lista.
            Node atual = ultimo;
            atual.setProximo(no);
            ultimo=no;
        }

    }

    public void remover(){
        imprime();
        System.out.println("Dado removido: " + primeiro.getDado());
        primeiro = primeiro.getProximo();
        //define o primeiro (Lista) sendo o segundo(Lista.getNext())

    }

    //Imprimindo elementos
    public void imprime(){

        System.out.println("\nFila encadeada:");

        Node atual = primeiro;

        while (atual != null) {

            System.out.print(atual.getDado()+ " -> ");
            atual= atual.getProximo();

        }

        System.out.print("Fim da fila");

    }

    public Node getPrimeiro(){

        return primeiro;

    }
//    public static void main(String[] args){
//        FilaEncadeada fila = new FilaEncadeada();
//        fila.inserir(2);
//        fila.inserir(3);
//        fila.inserir(255);
//        fila.inserir(32);
//        fila.inserir(1);
//        fila.inserir(5);
//        fila.inserir(90);
//        fila.remover();
//        fila.imprime();
//
//    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FilaEncadeada lista = new FilaEncadeada();
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

