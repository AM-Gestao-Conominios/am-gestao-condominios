package main;

public class ApartamentoPadrao extends Apartamento {
    private String tipoArmarios;
    private String tipoPisos;

    public ApartamentoPadrao(int numero, int andar, String tipoArmarios, String tipoPisos) {
        super(numero, andar);
        this.tipoArmarios = tipoArmarios;
        this.tipoPisos = tipoPisos;
    }

    @Override
    public String getDescricaoTipo() {
        return "Padrão";
    }

    public String getTipoArmarios() {
        return tipoArmarios;
    }

    public void setTipoArmarios(String tipoArmarios) {
        this.tipoArmarios = tipoArmarios;
    }

    public String getTipoPisos() {
        return tipoPisos;
    }

    public void setTipoPisos(String tipoPisos) {
        this.tipoPisos = tipoPisos;
    }

    @Override
    public String toString() {
        String base = super.toString();
        return base + "\n    Detalhes Padrão: [Armários=" + tipoArmarios + ", Pisos=" + tipoPisos + "]" +
                "\n    Moradores:" + (moradores.isEmpty() ? " (Vazio)" : formatarMoradores());
    }

    private String formatarMoradores() {
        StringBuilder sb = new StringBuilder();
        for (Morador m : moradores) {
            sb.append("\n").append(m.toString());
        }
        return sb.toString();
    }
}
