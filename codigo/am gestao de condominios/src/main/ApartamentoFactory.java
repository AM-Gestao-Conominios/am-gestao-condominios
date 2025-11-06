package main;

public class ApartamentoFactory {

    public Apartamento criarApartamentoPadrao(int numero, int andar, String tipoArmarios, String tipoPisos) {
        return new ApartamentoPadrao(numero, andar, tipoArmarios, tipoPisos);
    }

    public Apartamento criarApartamentoLuxo(int numero, int andar, String modeloLuminarias, boolean hasGeladeira, boolean hasFogao) {
        return new ApartamentoLuxo(numero, andar, modeloLuminarias, hasGeladeira, hasFogao);
    }
}

