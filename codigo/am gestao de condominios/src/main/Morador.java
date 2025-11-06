package main;

public class Morador {
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private int idade;
    private double renda; 

    public Morador(String nome, String cpf, String rg, String sexo, int idade, double renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.idade = idade;
        this.renda = renda;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public double getRenda() { return renda; }
    public void setRenda(double renda) { this.renda = renda; }

    @Override
    public String toString() {
        return "  - Morador [Nome=" + nome + ", Cpf=" + cpf + ", Renda=R$" + renda + "]";
    }
}
