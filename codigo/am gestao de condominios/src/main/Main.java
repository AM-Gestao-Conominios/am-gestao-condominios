package main;

public class Main {

    public static void main(String[] args) {
        System.out.println("### Iniciando Sistema de Gerenciamento de Condomínios (SGC) ###\n");
 
        ApartamentoFactory factory = new ApartamentoFactory();
 
        Condominio condominio = new Condominio(1, "Residencial Bela Vista", "Feliz", "Centro");
 
        Edificio blocoA = new Edificio(10, "Branco e Azul", 5);
        Edificio blocoB = new Edificio(20, "Bege", 3);

        Apartamento ap101 = factory.criarApartamentoPadrao(101, 1, "MDF", "Porcelanato");
        Apartamento ap102 = factory.criarApartamentoLuxo(102, 1, "LED Spot", true, true);
        
        Apartamento ap201 = factory.criarApartamentoPadrao(201, 2, "Compensado", "Laminado");

        ap101.adicionarMorador(new Morador("João Silva", "111.111.111-11", "123456", "M", 30, 4500.00));
        ap101.adicionarMorador(new Morador("Maria Silva", "222.222.222-22", "789012", "F", 28, 5500.00));
        
        ap102.adicionarMorador(new Morador("Pedro Souza", "333.333.333-33", "345678", "M", 45, 12000.00));
 
        blocoA.adicionarApartamento(ap101);
        blocoA.adicionarApartamento(ap102);
        blocoB.adicionarApartamento(ap201);

        condominio.adicionarEdificio(blocoA);
        condominio.adicionarEdificio(blocoB);
        
        System.out.println(condominio.toString());
    }
}

