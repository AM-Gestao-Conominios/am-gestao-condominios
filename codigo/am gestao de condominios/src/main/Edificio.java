package main;

import java.util.ArrayList;
import java.util.List;


public class Edificio {
    private int numero;
    private String corPintura;
    private int quantidadeAndares;
    private List<Apartamento> apartamentos;

    public Edificio(int numero, String corPintura, int quantidadeAndares) {
        this.numero = numero;
        this.corPintura = corPintura;
        this.quantidadeAndares = quantidadeAndares;
        this.apartamentos = new ArrayList<>();
    }

    public void adicionarApartamento(Apartamento apartamento) {
        this.apartamentos.add(apartamento);
    }
    
    public Apartamento buscarApartamento(int numero) {
        for (Apartamento ap : apartamentos) {
            if (ap.getNumero() == numero) {
                return ap;
            }
        }
        return null;
    }

    public int getNumero() { return numero; }
    public String getcorPintura() { return corPintura; }
    public int getquantidadeAndares() { return quantidadeAndares; }
    public List<Apartamento> getApartamentos() { return apartamentos; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEdifício [Numero=").append(numero)
          .append(", Cor=").append(corPintura)
          .append(", Andares=").append(quantidadeAndares).append("]");
        
        for (Apartamento ap : apartamentos) {
            sb.append(ap.toString());
        }
        return sb.toString();
    }
}

