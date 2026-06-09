
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Tela {

    private final Scanner entrada = new Scanner(System.in);
    private final ArrayList<Funcionario> funcionarios = new ArrayList<>();

    private void exibirMenu() {
        System.out.println("\n===== MENU DE CADASTRO =====\n");
        System.out.println("1 - Funcionário padrão");
        System.out.println("2 - Funcionário comissionado");
        System.out.println("3 - Funcionário de produção");
        System.out.println("4 - Excluir funcionário");
        System.out.println("5 - Gerar folha de pagamento");
        System.out.println("0 - Encerrar\n");
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerEntradaInt("Digite uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarFuncionarioPadrao();
                    break;
                case 2:
                    cadastrarFuncionarioComissionado();
                    break;
                case 3:
                    cadastrarFuncionarioProducao();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    exibirFolhaDePagamento();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Digite uma opção Válida.");
                    break;
            }
        } while (opcao != 0);

    }

    private void cadastrarFuncionarioPadrao() {
        String nome = lerNome();
        double extra;
        int matricula;
        do {
            matricula = lerEntradaInt("Matrícula: ");
        } while (matriculaExiste(matricula));
        
        extra = lerEntradaDouble("Extras: ");
        
        FuncionarioPadrao funcionario = new FuncionarioPadrao(nome, matricula, extra);

        funcionarios.add(funcionario);
        System.out.println("Funcionário padrão cadastrado com sucesso!");
    }

    private void cadastrarFuncionarioProducao() {
        String nome = lerNome();
        int matricula;
        double extra;
        double valorPorPeca;
        int quantidadeProduzida;
        do {
            matricula = lerEntradaInt("Matrícula: ");

        } while (matriculaExiste(matricula));
        
        extra = lerEntradaDouble("Extras: ");

        quantidadeProduzida = lerEntradaInt("Informe quantidade de peças produzidas: ");
        valorPorPeca = lerEntradaDouble("Informe valor por peça: ");

        FuncionarioProducao funcionario = new FuncionarioProducao(nome, matricula, extra, quantidadeProduzida, valorPorPeca);

        funcionarios.add(funcionario);
        System.out.println("Funcionário de produção cadastrado com sucesso!");
    }

    private void cadastrarFuncionarioComissionado() {
        String nome = lerNome();
        int matricula;
        double extra;
        double valorDasVendas;
        double percentual;
        do {
            matricula = lerEntradaInt("Matrícula: ");

        } while (matriculaExiste(matricula));
        extra = lerEntradaDouble("Extras: ");

        valorDasVendas = lerEntradaDouble("Informe valor das vendas: ");
        percentual = lerEntradaDouble("Informe comissão percentual: ");

        FuncionarioComissionado funcionario = new FuncionarioComissionado(nome, matricula, extra, valorDasVendas, percentual);
        funcionarios.add(funcionario);
        System.out.println("Funcionário comissionado cadastrado com sucesso!");
    }

    private void exibirFolhaDePagamento() {
        System.out.println("===== FUNCIONÁRIOS =====\n");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("Total de funcionários: " + funcionarios.size() + "\n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.exibirDados() + "\n");
        }

    }

    private void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("===== FUNCIONÁRIOS =====\n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getMatricula());
            System.out.println(funcionario.getTipoFuncionario());
        }
    }

    private void excluirFuncionario() {

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        exibirFuncionarios();
        int matriculaDoFuncionario = lerEntradaInt("Digite a matrícula do funcionário a ser deletado: ");
        Iterator<Funcionario> iterator = funcionarios.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (matriculaDoFuncionario == funcionario.getMatricula()) {
                encontrado = true;
                System.out.println("Deseja realmente deletar o " + funcionario.getTipoFuncionario()
                        + " " + funcionario.getNome() + "?");
                while (true) {
                    System.out.print("Digite (sim) ou (não): ");
                    String resposta = entrada.nextLine();

                    if (resposta.equalsIgnoreCase("sim")) {
                        iterator.remove();
                        System.out.println("Funcionário removido com sucesso!");
                        return;
                    } else if (resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")) {
                        System.out.println("Operação cancelada.");
                        return;
                    } else {
                        System.out.println("Resposta inválida.");
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Não existe nenhum funcionário com a matrícula " + matriculaDoFuncionario);
        }
    }

    private String lerNome() {

        String nome;

        while (true) {
            System.out.print("Nome: ");
            nome = entrada.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("O nome não pode estar vazio.");
            } else if (!nome.matches("[\\p{L} ]+")) {
                System.out.println("O nome só pode conter letras e espaços.");
            } else {
                return nome;
            }
        }
    }

    private double lerEntradaDouble(String mensagem) {
        double num;

        while (true) {
            System.out.print(mensagem);
            if (entrada.hasNextDouble()) {
                num = entrada.nextDouble();
                entrada.nextLine();

                if (num >= 0) {

                    return num;
                } else {
                    System.out.println("Valor inválido, Digite um número maior ou igual a 0.");
                }

            } else {
                System.out.println("Somente números, tente novamente.");
                entrada.nextLine();
            }
        }

    }

    private int lerEntradaInt(String mensagem) {
        int num;

        while (true) {
            System.out.print(mensagem);
            if (entrada.hasNextInt()) {
                num = entrada.nextInt();
                entrada.nextLine();

                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("Valor inválido, Digite um número maior ou igual a 0.");

                }

            } else {
                entrada.nextLine();
                System.out.println("Somente números, tente novamente.");
            }
        }

    }

    private boolean matriculaExiste(int matricula) {
        for (Funcionario f : funcionarios) {

            if (f.getMatricula() == matricula) {
                System.out.println("Essa matrícula já está cadastrada!");
                return true;
            }
        }

        return false;
    }
    

}
