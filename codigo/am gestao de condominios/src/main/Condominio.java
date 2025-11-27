package main;

import java.util.ArrayList;
import java.util.List;


public class Condominio {
    private int id;
    private String nome;
    private String cidade;
    private String bairro;
    private List<Edificio> edificios;

    public Condominio(int id, String nome, String cidade, String bairro) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.edificios = new ArrayList<>();
    }

    public void adicionarEdificio(Edificio edificio) {
        this.edificios.add(edificio);
    }
    
    public Edificio buscarEdificio(int numero) {
        for (Edificio ed : edificios) {
            if (ed.getNumero() == numero) {
                return ed;
            }
        }
        return null;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCidade() { return cidade; }
    public String getBairro() { return bairro; }
    public List<Edificio> getEdificios() { return edificios; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================================\n")
          .append("Condominio: ").append(nome).append(" (Numero: ").append(id).append(")\n")
          .append("Local: ").append(cidade).append(" - ").append(bairro).append("\n")
          .append("==============================================");
          
        for (Edificio ed : edificios) {
            sb.append(ed.toString());
        }
        return sb.toString();
    }
}
