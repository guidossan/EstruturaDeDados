import java.util.*;

public class Jogo {

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

                if (movimentaPilha(origem, destino, pilha1, pilha2, pilha3)) {
                    jogadas++;
                }
                boolean A = verificarOrdenacao(pilha1);
                boolean B = verificarOrdenacao(pilha2);
                boolean C = verificarOrdenacao(pilha3);
                if (  (  A ^ B ^ C ) && ( ! ( A && B && C ) )) {
                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                    break;
                }
            } else if (opcao == 2) {
                while(true){
                    boolean A = verificarOrdenacao(pilha1);
                    boolean B = verificarOrdenacao(pilha2);
                    boolean C = verificarOrdenacao(pilha3);
                    if ( (  A ^ B ^ C )  && ( ! ( A && B && C ) )) {
                        System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                        break;
                    }
                    automatica(pilha1,  pilha2, pilha3);
                    jogadas++;
                }
            }
        }

    }
    public static boolean verificarOrdenacao(PilhaEncadeada pilha ){
        if (verificaCres(pilha)||verificaDecre(pilha)){
            return true;
        }
        return false;
    }
    public static boolean verificaCres(PilhaEncadeada pilha){
        Node atual = pilha.getTopo();
        if(atual==null){
            return false;
        }
        while (atual != null){
            if(atual.getProximo() == null){
                return true;
            }
            if(atual.getProximo().getDado() > atual.getDado()){
                return false;
            }
            return true;
        }
        return false;
    }
    public static boolean verificaDecre(PilhaEncadeada pilha){
        Node atual = pilha.getTopo();
        while (atual != null){
            if(atual==null){
                return false;
            }
            if(atual.getProximo().getDado() < atual.getDado()){
                return false;
            }
            return true;
        }
        return false;
    }

    public static void imprimirPilhas(PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        System.out.println("Pilha 1");pilha1.imprime();
        System.out.println("Pilha 2");pilha2.imprime();
        System.out.println("Pilha 3");pilha3.imprime();
    }

    public static boolean movimentaPilha(int origem, int destino, PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        if (origem == 1) {
            int dado = pilha1.getTopo().getDado();
            pilha1.desempilhar();
            if (destino == 2) {
                pilha2.empilhar(dado);
                return true;
            } else {
                pilha3.empilhar(dado);
                return true;
            }
        } else if (origem == 2) {
            int dado = pilha2.getTopo().getDado();
            pilha2.desempilhar();
            if (destino == 1) {
                pilha1.empilhar(dado);
                return true;
            } else {
                pilha3.empilhar(dado);
                return true;
            }
        } else {
            int dado = pilha3.getTopo().getDado();
            pilha3.desempilhar();
            if (destino == 1) {
                pilha1.empilhar(dado);
                return true;
            } else {
                pilha2.empilhar(dado);
                return true;
            }

        }
    }

    public static void automatica(PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        movimentaPilha(2,1, pilha1,  pilha2,  pilha3);
        movimentaPilha(2,3, pilha1,  pilha2,  pilha3);
        Integer A = pilha1.getTopo().getDado();
        Integer B = pilha2.getTopo().getDado();
        Integer C = pilha3.getTopo().getDado();
        if(A == null){
            if(B<C){
                movimentaPilha(2,3,pilha1,  pilha2,  pilha3);

            } else {
                movimentaPilha(3,2,pilha1,  pilha2,  pilha3);

            }
        }
        if(B == null){
            if(A<C){
                movimentaPilha(3,1,pilha1,  pilha2,  pilha3);

            } else {
                movimentaPilha(1,3,pilha1,  pilha2,  pilha3);

            }
        }
        if(C == null){
            if(B<A){
                movimentaPilha(2,1,pilha1,  pilha2,  pilha3);

            } else {
                movimentaPilha(1,2,pilha1,  pilha2,  pilha3);

            }
        }
                    if ((A >= B && A <= C) || (A >= C && A <= B)) {         //valor intermadiario eh A
                        if(B<C){
                            movimentaPilha(1,3,pilha1,  pilha2,  pilha3);
                        } else {
                            movimentaPilha(1,2,pilha1,  pilha2,  pilha3);
                        }
                    } else if ((B >= A && B <= C) || (B >= C && B <= A)) {  //valor intermadiario eh B
                        if(A>C){
                            movimentaPilha(2,1,pilha1,  pilha2,  pilha3);
                        } else {
                            movimentaPilha(2, 3, pilha1, pilha2, pilha3);
                        }
                    } else {                                                //valor intermadiario eh C
                        if (A > B) {
                            movimentaPilha(3, 1, pilha1, pilha2, pilha3);
                        } else {
                            movimentaPilha(3, 2, pilha1, pilha2, pilha3);
                        }
                    }
    }
}
