
public class FuncionarioProducao extends Funcionario {

    private double quantidadeProduzida;
    private double valorPorPeca;

    public FuncionarioProducao(String nome, int matricula, double extra, double quantidadeProduzida, double valorPorPeca) {
        super(nome, matricula, extra);
        this.quantidadeProduzida = quantidadeProduzida;
        this.valorPorPeca = valorPorPeca;
    }

    public double getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public double getValorPorPeca() {
        return valorPorPeca;
    }

    @Override
    public String getTipoFuncionario() {
        return "Funcionário de produção.";
    }

    public void setQuantidadeProduzida(double quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public void setValorPorPeca(double valorPorPeca) {
        this.valorPorPeca = valorPorPeca;
    }

    public double calcularBonus() {
        return (valorPorPeca * quantidadeProduzida);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + calcularBonus();
    }

    @Override
    public String exibirDados() {
        return "Tipo: " + getTipoFuncionario() + "\n" + super.exibirDados()
                + "\nProdutividade: " + calcularBonus()
                + "\nSalário total: " + calcularSalario();
    }
}
