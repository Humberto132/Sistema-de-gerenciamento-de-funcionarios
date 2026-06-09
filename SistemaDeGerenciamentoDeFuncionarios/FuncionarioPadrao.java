
public class FuncionarioPadrao extends Funcionario {

    public FuncionarioPadrao(String nome, int matricula, double extra) {
        super(nome, matricula, extra);
    }

    @Override
    public String getTipoFuncionario() {
        return "Funcionário padrão.";
    }

    @Override
    public String exibirDados() {
        return "Tipo: " + getTipoFuncionario() + "\n" + super.exibirDados()
                + "\nSalário total: " + calcularSalario();

    }
}
