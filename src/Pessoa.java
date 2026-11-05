import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private final String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private int senha;
    private boolean aguardando;

    public Pessoa(String cpf, String nome, String telefone, LocalDate dataNascimento, int senha){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.aguardando = true;
    }

    public String getCpf(){
        return cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public boolean getAguardando(){
        return aguardando;
    }

    public void chamar(){
        aguardando = false;
    }

    public String toString(){

        int idade = Period.between(
            dataNascimento, LocalDate.now()
        ).getYears();

        String texto = "";

        texto += "Nome: " + nome;
        texto += "\nCPF: " + cpf;
        texto += "\nTelefone: " + telefone;
        texto += "\nData de nascimento: " + dataNascimento;
        texto += "\nIdade: " + idade;
        texto += "\nSenha: " + senha;

        return texto;
    }
}
