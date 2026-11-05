import java.time.LocalDate;

public class Fila{

    private static final int MAX = 50;

    private Pessoa[] pessoas;
    private int posicaoLivre;
    private int proximaSenha;

    public Fila(){
        this.pessoas = new Pessoa[MAX];
        this.posicaoLivre = 0;
        this.proximaSenha = 1;
    }

    public int cadastrar(String cpf, String nome, String telefone, LocalDate nascimento){

        for (int i = 0; i < posicaoLivre; i++){

            if (pessoas[i].getCpf().equals(cpf)){
                return -1;
            }
        }

        if (posicaoLivre < MAX){

            int senha = proximaSenha++;

            pessoas[posicaoLivre] = new Pessoa(
                cpf, nome, telefone, nascimento, senha
            );
            posicaoLivre++;

            return senha;
        }

        return -1;
    }

    public Pessoa chamarPessoa() {

        int posicao = -1;

        for (int i = 0; i < posicaoLivre; i++){

            if (pessoas[i].getAguardando()) {

                if (posicao == -1 ||
                    pessoas[i].getDataNascimento()
                    .isBefore(pessoas[posicao].getDataNascimento())){

                    posicao = i;
                }
            }
        }

        if (posicao == -1){
            return null;
        }

        pessoas[posicao].chamar();

        return pessoas[posicao];
    }

    public String listar() {

        String texto = "";

        for (int i = 0; i < posicaoLivre; i++){

            if (pessoas[i].getAguardando()){
                texto += "\n" + pessoas[i].toString();
            }
        }

        if (texto.equals("")){
            return "Nao existem pessoas aguardando.";
        }

        return texto;
    }
}
