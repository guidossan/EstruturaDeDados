package Hash;
public class tabelaHash{
    int tamanho;
    Node tabela[];
    Node informacao;
    public tabelaHash(int tamanho){
        this.tamanho = tamanho;
        for (int i = 0, i < tamanho, i++){
            tabela[i] = new Node();

        }
}