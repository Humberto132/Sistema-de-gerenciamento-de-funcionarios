
public abstract class Funcionario {

    private String nome;
    private int matricula;
    private double extra;
    private static final double SALARIO_BASE = 2000;

    public Funcionario(String nome, int matricula, double extra) {
        this.nome = nome.trim();
        this.matricula = matricula;
        this.extra = extra;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
    
    public double getExtra(){
        return extra;
    }

    public double getSalarioBase() {
        return SALARIO_BASE;
    }

    public abstract String getTipoFuncionario();

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void setExtra(double extra){
        this.extra = extra;
    }

    public double calcularSalario(){
        return getSalarioBase() + extra;
    }
    
    public String exibirDados() {
        return "Nome: " + nome
                + "\nMatrícula: " + matricula
                + "\nSalário fixo: " + getSalarioBase()
                 + "\nExtra: " + extra;

    }
}
