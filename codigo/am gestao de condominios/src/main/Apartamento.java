package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Apartamento {
    protected int numero;
    protected int andar;
    protected List<Morador> moradores;

    public Apartamento(int numero, int andar) {
        this.numero = numero;
        this.andar = andar;
        this.moradores = new ArrayList<>();
    }

    public void adicionarMorador(Morador morador) {
        this.moradores.add(morador);
    }

    public double calcularRendaMedia() {
        if (moradores.isEmpty()) {
            return 0.0;
        }
        double somaRendas = 0.0;
        for (Morador morador : moradores) {
            somaRendas += morador.getRenda();
        }
        return somaRendas / moradores.size();
    }

    public abstract String getDescricaoTipo();

    @Override
    public String toString() {
        return "\n  Apartamento [Numero=" + numero + ", Andar=" + andar + ", Tipo=" + getDescricaoTipo() +
                ", Renda Média=R$" + String.format("%.2f", calcularRendaMedia()) + "]";
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }
}
