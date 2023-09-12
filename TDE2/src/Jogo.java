import java.util.Scanner;
import java.util.*;
public class Jogo {
    private int origem;
    private int destino;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        PilhaEncadeada pilha1 = new PilhaEncadeada();
        PilhaEncadeada pilha2 = new PilhaEncadeada();
        PilhaEncadeada pilha3 = new PilhaEncadeada();
        int jogadas = 0;
        while(true){
            System.out.println("Digite o tamanho da pilha");
            int tamanho = scanner.nextInt();
            for (int i = 0; i < tamanho; i++) {
                int numeroAleatorio = random.nextInt(100) + 1;
                pilha1.empilhar(numeroAleatorio);
            }
            System.out.println("Digite oque deseja fazer");
            System.out.println("0 - sair do jogo.\n" +
                    "1 - movimentar.\n" +
                    "\n" +
                    "2 - Solução automática.");
            int opcao;
            opcao = scanner.nextInt();
            if(opcao == 0){
                break;
            }
            else if(opcao == 1){
                System.out.println("Digite a origem:");
                int origem = scanner.nextInt();
                System.out.println("Digite o destino:");
                int destino = scanner.nextInt();
                if(movimentaPilha(origem,destino)){
                    jogadas++;
                }
            }
//            if(opcao == 2){
//                lista.remover();
//                System.out.println("Lista Encadeada:");
//                lista.imprime();
//            }
            }
        public static void movimentaPilha(int origem,int destino){
            if(origem == 1){
                int dado = pilha1.getTopo().getDado();
                pilha1.desempilhar();
                if(destino == 2){
                    pilha2.empilhar(dado);
                }else{
                    pilha3.empilhar(dado);
                }
            } else if (origem == 2) {
                int dado = pilha2.getTopo().getDado();
                pilha2.desempilhar();
                if(destino == 1){
                    pilha1.empilhar(dado);
                }else{
                    pilha3.empilhar(dado);
                }
            }else{
                int dado = pilha3.getTopo().getDado();
                pilha3.desempilhar();
                if(destino == 1){
                    pilha1.empilhar(dado);
                }else{
                    pilha2.empilhar(dado);
                }
            }
        }
    }
}
