package main;

public class ApartamentoLuxo extends Apartamento {
    private String modeloLuminarias;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoLuxo(int numero, int andar, String modeloLuminarias, boolean possuiGeladeira,
            boolean possuiFogao) {
        super(numero, andar);
        this.modeloLuminarias = modeloLuminarias;
        this.possuiGeladeiraEmbutida = possuiGeladeira;
        this.possuiFogaoEmbutido = possuiFogao;
    }

    @Override
    public String getDescricaoTipo() {
        return "Luxo";
    }

    public String getModeloLuminarias() {
        return modeloLuminarias;
    }

    public void setModeloLuminarias(String modeloLuminarias) {
        this.modeloLuminarias = modeloLuminarias;
    }

    public boolean isPossuiGeladeiraEmbutida() {
        return possuiGeladeiraEmbutida;
    }

    public void setPossuiGeladeiraEmbutida(boolean possuiGeladeira) {
        this.possuiGeladeiraEmbutida = possuiGeladeira;
    }

    public boolean isPossuiFogaoEmbutido() {
        return possuiFogaoEmbutido;
    }

    public void setPossuiFogaoEmbutido(boolean possuiFogao) {
        this.possuiFogaoEmbutido = possuiFogao;
    }

    @Override
    public String toString() {
        String base = super.toString();
        String detalhes = String.format("[Luminárias=%s, Geladeira=%b, Fogão=%b]",
                modeloLuminarias, possuiGeladeiraEmbutida, possuiFogaoEmbutido);
        return base + "\n    Detalhes Luxo: " + detalhes +
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
