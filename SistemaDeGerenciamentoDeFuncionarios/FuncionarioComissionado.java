
public class FuncionarioComissionado extends Funcionario {

    private double valorDasVendas;
    private double percentual;

    public FuncionarioComissionado(String nome, int matricula, double extra, double valorDasVendas, double percentual) {
        super(nome, matricula, extra);
        this.valorDasVendas = valorDasVendas;
        this.percentual = percentual;
    }

    public double getValorDasVendas() {
        return valorDasVendas;
    }

    public double getPercentual() {
        return percentual;
    }

    @Override
    public String getTipoFuncionario() {
        return "Funcionário comissionado.";
    }

    public void setValorDasVendas(double valorDasVendas) {
        this.valorDasVendas = valorDasVendas;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double calcularComissao() {
        return valorDasVendas * (percentual / 100);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + calcularComissao();
    }

    @Override
    public String exibirDados() {
        return "Tipo: " + getTipoFuncionario() + "\n" + super.exibirDados()
                + "\nComissão: " + calcularComissao()
                + "\nSalário total: " + calcularSalario();
    }

}
