import java.util.*;

public class Jogo {
    private static final boolean crescente = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite o tamanho das pilhas: ");
        int tamanho = scanner.nextInt();
        boolean verificaCres = true;

        System.out.print("Deseja ordem crescente? (S/N): ");
        String resposta = scanner.next();
        if (resposta.equalsIgnoreCase("N")) {
            verificaCres = false;
        }

        PilhaEncadeada pilha1 = new PilhaEncadeada();
        PilhaEncadeada pilha2 = new PilhaEncadeada();
        PilhaEncadeada pilha3 = new PilhaEncadeada();

        for (int i = 0; i < tamanho; i++) {
            int numeroAleatorio = random.nextInt(100) + 1;
            pilha2.empilhar(numeroAleatorio);
        }

        int jogadas = 0;

        while (true) {
            imprimirPilhas(pilha1, pilha2, pilha3);

            System.out.println("Escolha uma opção:");
            System.out.println("0 - Sair do jogo");
            System.out.println("1 - Movimentar");
            System.out.println("2 - Solução automática");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                System.out.print("Digite a pilha de origem (1, 2, ou 3): ");
                int origem = scanner.nextInt();

                System.out.print("Digite a pilha de destino (1, 2, ou 3): ");
                int destino = scanner.nextInt();

                movimentaPilha(origem, destino, pilha1, pilha2, pilha3);
                jogadas++;

                boolean A = verificarOrdenacao(pilha1.getTopo());
                boolean B = verificarOrdenacao(pilha2.getTopo());
                boolean C = verificarOrdenacao(pilha3.getTopo());
                if (  (  A ^ B ^ C ) && ( ! ( A && B && C ) )) {
                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                    break;
                }
            } else if (opcao == 2) {
                automatica(pilha1, pilha2, pilha3);
                boolean A = verificarOrdenacao(pilha1.getTopo());
                boolean B = verificarOrdenacao(pilha2.getTopo());
                boolean C = verificarOrdenacao(pilha3.getTopo());
                if (  (  A ^ B ^ C ) && ( ! ( A && B && C ) )) {
                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                    break;
                }
            }
        }

    }

    public static boolean verificarOrdenacao(Node node ){
        return verificaCres(node) ^ verificaDecre(node);
    }
    public static boolean verificaCres(Node node) {
        if(node==null){
            return false;
        }
        Node atual = node;
        while (atual.getProximo() != null){

            if(atual.getDado() > atual.getProximo().getDado()){
                return false;
            }
            return verificaDecre(atual.getProximo());
        }
        return true;
    }

    public static boolean verificaDecre(Node node){
        if(node==null){
            return false;
        }
        Node atual = node;
        while (atual.getProximo() != null){

            if(atual.getDado() < atual.getProximo().getDado()){
                return false;
            }
            return verificaDecre(atual.getProximo());
            }
        return true;
    }

    public static void imprimirPilhas(PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        System.out.println("Pilha 1");pilha1.imprime();
        System.out.println("Pilha 2");pilha2.imprime();
        System.out.println("Pilha 3");pilha3.imprime();
    }

    public static void movimentaPilha(int origem, int destino, PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        if (origem == 1) {
            int dado = pilha1.getTopo().getDado();
            pilha1.desempilhar();
            if (destino == 2) {
                pilha2.empilhar(dado);

            } else {
                pilha3.empilhar(dado);

            }
        } else if (origem == 2) {
            int dado = pilha2.getTopo().getDado();
            pilha2.desempilhar();
            if (destino == 1) {
                pilha1.empilhar(dado);

            } else {
                pilha3.empilhar(dado);

            }
        } else {
            int dado = pilha3.getTopo().getDado();
            pilha3.desempilhar();
            if (destino == 1) {
                pilha1.empilhar(dado);

            } else {
                pilha2.empilhar(dado);

            }

        }
    }

    public static void automatica(PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        if(pilha1.estavazia()){
            movimentaPilha(2,1,pilha1,  pilha2,  pilha3);
            movimentaPilha(2,3,pilha1,  pilha2,  pilha3);
        }
        if( pilha2.estavazia() && pilha3.estavazia()){
            Integer B = pilha2.getTopo().getDado();
            Integer C = pilha3.getTopo().getDado();
        }
        int jogadas = 0;
        while(true){
            boolean a = verificarOrdenacao(pilha1.getTopo());
            boolean b = verificarOrdenacao(pilha2.getTopo());
            boolean c = verificarOrdenacao(pilha3.getTopo());
            if ( (  a ^ b ^ c )  && ( ! ( a && b && c ) )) {
                System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                break;
            }
            if(!pilha1.estavazia() && !pilha2.estavazia() && !pilha3.estavazia()){
                Integer A = pilha1.getTopo().getDado();
                Integer B = pilha2.getTopo().getDado();
                Integer C = pilha3.getTopo().getDado();
                if ((A > B) && (A > C) ) {
                    if(B<C){
                        movimentaPilha(3,1,pilha1,  pilha2,  pilha3);
                    } else {
                        movimentaPilha(2,1,pilha1,  pilha2,  pilha3);
                    }
                } else if ((B > A) && (B > C)) {
                    if(A>C){
                        movimentaPilha(1,2,pilha1,  pilha2,  pilha3);
                    } else {
                        movimentaPilha(3, 2, pilha1, pilha2, pilha3);
                    }
                } else if((C > A) && (C > B)){
                    if (A > B) {
                        movimentaPilha(1, 3, pilha1, pilha2, pilha3);
                    } else {
                        movimentaPilha(2, 3, pilha1, pilha2, pilha3);
                    }
                }
                if (( A >= B) && ( A <= C)) {
                    movimentaPilha(1, 3, pilha1, pilha2, pilha3);
                } else if ((B >= A) && ( B <= C)) {
                    movimentaPilha(2, 3, pilha1, pilha2, pilha3);
                } else if (( C >= A) && (C <= B)) {
                    movimentaPilha(3, 1, pilha1, pilha2, pilha3);
                }
                jogadas++;
            }
            if(pilha1.estavazia()&& (!pilha2.estavazia()&&!pilha3.estavazia())){
                if(pilha2.getTopo().getDado()>pilha3.getTopo().getDado()){
                    movimentaPilha(3,2,pilha1,  pilha2,  pilha3);
                } else {
                    movimentaPilha(2, 3, pilha1, pilha2, pilha3);
                }
            } else if (pilha2.estavazia()&& (!pilha1.estavazia()&&!pilha3.estavazia())){
                if(pilha1.getTopo().getDado()>pilha3.getTopo().getDado()){
                    movimentaPilha(3,1,pilha1,  pilha2,  pilha3);
                } else {
                    movimentaPilha(1, 3, pilha1, pilha2, pilha3);
                }
            } else if(pilha3.estavazia()&& (!pilha1.estavazia()&&!pilha2.estavazia())){
                if(pilha1.getTopo().getDado()>pilha2.getTopo().getDado()){
                    movimentaPilha(2,1,pilha1,  pilha2,  pilha3);
                } else {
                    movimentaPilha(1, 2, pilha1, pilha2, pilha3);
                }
            }

        }
    }
}
