import java.util.Objects;

public class Conta {

    private Integer Numero;
    private String Agencia, Nome;
    private Double Saldo;

    public Conta(Integer numero, String agencia, String nome) {
        Numero = numero;
        Agencia = agencia;
        Nome = nome;
    }

    public Conta() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return Objects.equals(getNumero(), conta.getNumero()) && Objects.equals(getAgencia(), conta.getAgencia()) && Objects.equals(getNome(), conta.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getAgencia(), getNome());
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        if (numero < 0 )
            throw new IllegalArgumentException("Número inválido");
        Numero = numero;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String agencia) {
        if(!agencia.matches("\\d{3}-\\d{1}"))
            throw new IllegalArgumentException("Agência inválida");
        Agencia = agencia;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank() && !nome.matches("[a-zA-Z]+\\s[a-zA-Z]+"))
            throw new IllegalArgumentException("Nome inválido, Deve conter nome e sobrenome.");
        Nome = nome.toUpperCase();
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        if (saldo >= 0)
            Saldo = saldo;
        else
            throw new IllegalArgumentException("Saldo não pode ser negativo");
    }
}
