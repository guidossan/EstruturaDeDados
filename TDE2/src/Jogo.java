import java.util.*;

public class Jogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite o tamanho das pilhas: ");
        int tamanho = scanner.nextInt();
        boolean ordemCrescente = true;

        System.out.print("Deseja ordem crescente? (S/N): ");
        String resposta = scanner.next();
        if (resposta.equalsIgnoreCase("N")) {
            ordemCrescente = false;
        }

        PilhaEncadeada pilha1 = new PilhaEncadeada();
        PilhaEncadeada pilha2 = new PilhaEncadeada();
        PilhaEncadeada pilha3 = new PilhaEncadeada();

        for (int i = 0; i < tamanho; i++) {
            int numeroAleatorio = random.nextInt(100) + 1;
            pilha1.empilhar(numeroAleatorio);
        }

//        if (!ordemCrescente) {
//            Collections.sort(pilha1, Collections.reverseOrder());
//        }

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

                if (verificarOrdenacao(pilha1) || verificarOrdenacao(pilha2) || verificarOrdenacao(pilha3)) {
                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                    break;
                }
            } else if (opcao == 2) {
                // Implemente a lógica da solução automática aqui, se desejar.
            }
        }
    }

    public static void imprimirPilhas(PilhaEncadeada pilha1, PilhaEncadeada pilha2, PilhaEncadeada pilha3) {
        System.out.println("Pilha 1: " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);
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
}