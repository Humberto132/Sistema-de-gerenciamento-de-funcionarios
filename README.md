# Sistema de Gerenciamento de Funcionários

## Descrição do Projeto

Este projeto foi desenvolvido em Java com o objetivo de realizar o cadastro e gerenciamento de funcionários de diferentes categorias, permitindo a consulta dos dados cadastrados, o cálculo automático dos salários e a geração da folha de pagamento.

O sistema funciona através de um menu interativo no terminal, onde o usuário pode cadastrar funcionários, consultar informações, excluir registros e visualizar a folha de pagamento.

O projeto foi desenvolvido aplicando os principais conceitos da Programação Orientada a Objetos (POO), como abstração, herança, encapsulamento e polimorfismo.

---

## Funcionalidades

- Cadastro de Funcionário Padrão
- Cadastro de Funcionário Comissionado
- Cadastro de Funcionário de Produção
- Consulta dos dados dos funcionários cadastrados
- Exclusão de funcionários por matrícula
- Validação de entradas do usuário
- Cálculo automático dos salários
- Geração da folha de pagamento

---

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections Framework
- ArrayList
- Iterator
- Scanner
- Estruturas condicionais
- Estruturas de repetição
- Métodos
- Atributos
- Criação de objetos
- Classes abstratas

---

## Estrutura do Projeto

### Principal

Classe responsável por iniciar a aplicação.

**Responsabilidades:**
- Criar um objeto da classe `Tela`.
- Iniciar a execução do sistema.

```java
public static void main(String[] args) {
    Tela tela = new Tela();
    tela.executar();
}
```

---

### Tela

Classe responsável pela interação com o usuário através do terminal.

**Responsabilidades:**
- Exibir o menu principal.
- Receber entradas do usuário.
- Validar dados.
- Cadastrar funcionários.
- Consultar funcionários cadastrados.
- Excluir funcionários.
- Gerar folha de pagamento.
- Armazenar os funcionários cadastrados.

---

## Conceitos de Programação Orientada a Objetos Aplicados

### Abstração

A classe `Funcionario` foi declarada como abstrata, servindo como modelo para os demais tipos de funcionários.

```java
public abstract class Funcionario
```

Também possui um método abstrato:

```java
public abstract String getTipoFuncionario();
```

---

### Encapsulamento

Os atributos foram declarados como privados e são acessados através de métodos getters e setters.

```java
private String nome;

public String getNome() {
    return nome;
}
```

---

### Herança

As classes especializadas herdam da classe `Funcionario`.

```java
public class FuncionarioPadrao extends Funcionario
public class FuncionarioComissionado extends Funcionario
public class FuncionarioProducao extends Funcionario
```

---

### Polimorfismo

Uma única lista pode armazenar diferentes tipos de funcionários.
Sobrescrita de métodos da superclasse.

```java
private final ArrayList<Funcionario> funcionarios = new ArrayList<>();
```

---

### Sobrescrita de Métodos (Override)

As subclasses implementam comportamentos específicos sobrescrevendo métodos da superclasse.

```java
@Override
public double calcularSalario() {
    return super.calcularSalario() + calcularComissao();
}
```

---

## Estruturas de Dados Utilizadas

### ArrayList

Utilizado para armazenar todos os funcionários cadastrados.

```java
private final ArrayList<Funcionario> funcionarios = new ArrayList<>();
```

### Iterator

Utilizado para remover funcionários de forma segura durante a iteração.

```java
Iterator<Funcionario> iterator = funcionarios.iterator();
```

---

## Entrada de Dados

O sistema utiliza a classe Scanner para realizar a leitura das informações digitadas pelo usuário.

```java
private final Scanner entrada = new Scanner(System.in);
```

---

## Validações Implementadas

- Nome não pode estar vazio.
- Nome deve conter apenas letras e espaços.
- Matrícula não pode ser negativa.
- Matrícula não pode estar duplicada.
- Valores monetários não podem ser negativos.
- Quantidades não podem ser negativas.
- Entradas inválidas são tratadas antes do cadastro.

---

## Fluxo de Funcionamento

1. O usuário executa a classe Principal.
2. O menu principal é exibido.
3. O usuário escolhe uma opção.
4. O sistema solicita os dados necessários.
5. Os dados são validados.
6. O funcionário é cadastrado.
7. Os funcionários podem ser consultados.
8. O salário é calculado automaticamente.
9. A folha de pagamento pode ser exibida a qualquer momento.
