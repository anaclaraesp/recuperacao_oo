import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App{

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        Fila fila = new Fila();
        int opcao;

        do {
            System.out.println("FILA DE ATENDIMENTO");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Chamar proxima pessoa");
            System.out.println("3 - Listar pessoas aguardando");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("CPF: ");
                    String cpf = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Data de nascimento (dd/MM/yyyy): ");
                    String data = entrada.nextLine();

                    LocalDate nascimento = LocalDate.parse(
                        data,
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    );

                    int senha = fila.cadastrar(
                        cpf, nome, telefone, nascimento
                    );

                    if (senha != -1){
                        System.out.println("Cadastro realizado!");
                        System.out.println("Sua senha: " + senha);
                    } 
                    else{
                        System.out.println("CPF ja cadastrado ou limite atingido!");
                    }
                    break;

                case 2:
                    Pessoa chamada = fila.chamarPessoa();

                    if (chamada != null) {
                        System.out.println("\nPESSOA CHAMADA:");
                        System.out.println(chamada.toString());
                    } else {
                        System.out.println("Nao existem pessoas aguardando.");
                    }
                    break;

                case 3:
                    System.out.println(fila.listar());
                    break;

                case 0:
                    System.out.println("Sistema encerrado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        entrada.close();
    }
}
