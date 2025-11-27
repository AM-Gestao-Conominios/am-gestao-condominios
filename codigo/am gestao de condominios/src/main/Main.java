package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    private static ApartamentoFactory factory = new ApartamentoFactory();
    
    private static ArrayList<Condominio> condominios = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("### Iniciando Sistema de Gerenciamento de Condominios (SGC) ###\n");
        
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch (opcao) {
                    case 1:
                        cadastrarCondominio();
                        break;
                    case 2:
                        cadastrarEdificio();
                        break;
                    case 3:
                        cadastrarApartamento();
                        break;
                    case 4:
                        cadastrarMorador();
                        break;
                    case 5:
                        listarEstruturaCompleta();
                        break;
                    case 6:
                        visualizarElemento();
                        break;
                    case 7:
                        gerenciarApartamento();
                        break;
                    case 0:
                        System.out.println("\nEncerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um numero valido.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
            if (opcao != 0) {
                 System.out.println("\nPressione Enter para continuar...");
                 scanner.nextLine();
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Cadastrar Novo Condominio");
        System.out.println("2. Cadastrar Novo Edificio");
        System.out.println("3. Cadastrar Novo Apartamento");
        System.out.println("4. Cadastrar Novo Morador");
        System.out.println("5. Listar Estrutura Completa");
        System.out.println("6. Visualizar Detalhes de Elemento");
        System.out.println("7. Gerenciar Apartamento");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void cadastrarCondominio() {
        System.out.println("\n-- Cadastro de Condominio --");
        System.out.print("Numero: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        Condominio c = new Condominio(id, nome, cidade, bairro);
        condominios.add(c);
        System.out.println("Condominio '" + nome + "' cadastrado com sucesso!");
    }

    private static void cadastrarEdificio() {
        System.out.println("\n-- Cadastro de Edificio --");
        Condominio c = selecionarCondominio();
        if (c == null) return;

        System.out.print("NNumero do Edificio: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Total de Andares: ");
        int totalAndares = Integer.parseInt(scanner.nextLine());

        Edificio e = new Edificio(id, cor, totalAndares);
        c.adicionarEdificio(e);
        System.out.println("Edificio Numero " + id + " cadastrado no " + c.getNome() + "!");
    }

    private static void cadastrarApartamento() {
        System.out.println("\n-- Cadastro de Apartamento --");
        Condominio c = selecionarCondominio();
        if (c == null) return;
        
        Edificio e = selecionarEdificio(c);
        if (e == null) return;

        System.out.print("Tipo (1- Padrao, 2- Luxo): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Numero do Apartamento: ");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.print("Andar: ");
        int andar = Integer.parseInt(scanner.nextLine());

        Apartamento ap;
        if (tipo == 1) {
            System.out.print("Tipo de Armario: ");
            String arm = scanner.nextLine();
            System.out.print("Tipo de Piso: ");
            String piso = scanner.nextLine();
            ap = factory.criarApartamentoPadrao(num, andar, arm, piso);
        } else if (tipo == 2) {
            System.out.print("Modelo das Luminarias: ");
            String luz = scanner.nextLine();
            System.out.print("Possui Geladeira Embutida (true/false): ");
            boolean geladeira = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Possui Fogao Embutido (true/false): ");
            boolean fogao = Boolean.parseBoolean(scanner.nextLine());
            ap = factory.criarApartamentoLuxo(num, andar, luz, geladeira, fogao);
        } else {
            System.out.println("Tipo invalido!");
            return;
        }

        e.adicionarApartamento(ap);
        System.out.println("Apartamento " + num + " cadastrado no Edificio Numero " + e.getNumero() + "!");
    }

    private static void cadastrarMorador() {
        System.out.println("\n-- Cadastro de Morador --");
        Condominio c = selecionarCondominio();
        if (c == null) return;
        
        Edificio e = selecionarEdificio(c);
        if (e == null) return;
        
        Apartamento ap = selecionarApartamento(e);
        if (ap == null) return;

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Renda: ");
        double renda = Double.parseDouble(scanner.nextLine());

        Morador m = new Morador(nome, cpf, rg, sexo, idade, renda);
        ap.adicionarMorador(m);
        System.out.println("Morador " + nome + " cadastrado no Apartamento " + ap.getNumero() + "!");
    }

    private static void listarEstruturaCompleta() {
        System.out.println("\n--- ESTRUTURA COMPLETA ---");
        if (condominios.isEmpty()) {
            System.out.println("Nenhum condominio cadastrado.");
            return;
        }
        for (Condominio c : condominios) {
            System.out.println(c.toString());
        }
    }

    private static Condominio selecionarCondominio() {
        if (condominios.isEmpty()) {
            System.out.println("Nenhum condominio cadastrado. Cadastre um primeiro.");
            return null;
        }

        System.out.println("Selecione um Condominio:");
        for (int i = 0; i < condominios.size(); i++) {
            System.out.println((i + 1) + ". " + condominios.get(i).getNome());
        }
        System.out.print("Opcao: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (idx < 0 || idx >= condominios.size()) {
            System.out.println("Selecao invalida!");
            return null;
        }
        return condominios.get(idx);
    }

    private static Edificio selecionarEdificio(Condominio c) {
        if (c.getEdificios().isEmpty()) {
            System.out.println("Nenhum edificio cadastrado neste condominio.");
            return null;
        }

        System.out.println("Selecione um Edificio:");
        for (int i = 0; i < c.getEdificios().size(); i++) {
            System.out.println((i + 1) + ". Numero " + c.getEdificios().get(i).getNumero());
        }
        System.out.print("Opcao: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (idx < 0 || idx >= c.getEdificios().size()) {
            System.out.println("Selecao invalida!");
            return null;
        }
        return c.getEdificios().get(idx);
    }

    private static Apartamento selecionarApartamento(Edificio e) {
        if (e.getApartamentos().isEmpty()) {
            System.out.println("Nenhum apartamento cadastrado neste edificio.");
            return null;
        }

        System.out.println("Selecione um Apartamento:");
        for (int i = 0; i < e.getApartamentos().size(); i++) {
            System.out.println((i + 1) + ". Numero " + e.getApartamentos().get(i).getNumero());
        }
        System.out.print("Opcao: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (idx < 0 || idx >= e.getApartamentos().size()) {
            System.out.println("Selecao invalida!");
            return null;
        }
        return e.getApartamentos().get(idx);
    }

    private static void visualizarElemento() {
        System.out.println("\n-- Visualizar Detalhes --");
        System.out.println("1. Visualizar Condominio");
        System.out.println("2. Visualizar Edificio");
        System.out.println("3. Visualizar Apartamento");
        System.out.print("Escolha uma opcao: ");
        int op = Integer.parseInt(scanner.nextLine());

        Condominio c;
        Edificio e;
        Apartamento ap;

        switch (op) {
            case 1:
                c = selecionarCondominio();
                if (c != null) System.out.println(c.toString());
                break;
            case 2:
                c = selecionarCondominio();
                if (c == null) return;
                e = selecionarEdificio(c);
                if (e != null) System.out.println(e.toString());
                break;
            case 3:
                c = selecionarCondominio();
                if (c == null) return;
                e = selecionarEdificio(c);
                if (e == null) return;
                ap = selecionarApartamento(e);
                if (ap != null) System.out.println(ap.toString());
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }

    private static void gerenciarApartamento() {
        System.out.println("\n-- Gerenciamento de Apartamento --");
        Condominio c = selecionarCondominio();
        if (c == null) return;
        Edificio e = selecionarEdificio(c);
        if (e == null) return;
        Apartamento ap = selecionarApartamento(e);
        if (ap == null) return;

        System.out.println("\nApartamento Selecionado:");
        System.out.println(ap.toString());
        System.out.println("---------------------------------");

        int op = -1;
        while (op != 0) {
            exibirMenuApartamento(ap);
            try {
                op = Integer.parseInt(scanner.nextLine());
                processarOpcaoApartamento(op, ap);
            } catch (NumberFormatException ex) {
                System.out.println("Erro: Insira um numero.");
                op = -1;
            }
        }
    }

    private static void exibirMenuApartamento(Apartamento ap) {
        System.out.println("\n--- Gerenciar AP " + ap.getNumero() + " ---");
        System.out.println("1. Visualizar Detalhes Novamente");
        System.out.println("2. Despejar Moradores");
        if (ap instanceof ApartamentoPadrao) {
            System.out.println("3. Trocar Piso");
            System.out.println("4. Trocar Armarios");
        } 
        else if (ap instanceof ApartamentoLuxo) {
            ApartamentoLuxo al = (ApartamentoLuxo) ap;
            System.out.println("3. Instalar/Remover Geladeira (Atual: " + al.isPossuiGeladeiraEmbutida() + ")");
            System.out.println("4. Instalar/Remover Fogao (Atual: " + al.isPossuiFogaoEmbutido() + ")");
        }
        
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

    private static void processarOpcaoApartamento(int op, Apartamento ap) {
        switch (op) {
            case 1:
                System.out.println(ap.toString());
                break;
            case 2:
                ap.despejarMoradores();
                System.out.println("Moradores despejados com sucesso!");
                break;
            case 3:
                if (ap instanceof ApartamentoPadrao) {
                    System.out.print("Novo tipo de piso: ");
                    String novoPiso = scanner.nextLine();
                    ((ApartamentoPadrao) ap).setTipoPisos(novoPiso);
                    System.out.println("Piso atualizado!");
                } else if (ap instanceof ApartamentoLuxo) {
                	ApartamentoLuxo al = (ApartamentoLuxo) ap;
                    al.setPossuiGeladeiraEmbutida(!al.isPossuiGeladeiraEmbutida());
                    System.out.println("Status da geladeira atualizado para: " + al.isPossuiGeladeiraEmbutida());
                } else {
                    System.out.println("Opcao invalida para este tipo de apartamento.");
                }
                break;
            case 4:
                if (ap instanceof ApartamentoPadrao) {
                    System.out.print("Novo tipo de armario: ");
                    String novoArmario = scanner.nextLine();
                    ((ApartamentoPadrao) ap).setTipoArmarios(novoArmario);
                    System.out.println("Armarios atualizados!");
                } else if (ap instanceof ApartamentoLuxo) {
                    ApartamentoLuxo al = (ApartamentoLuxo) ap;
                    al.setPossuiFogaoEmbutido(!al.isPossuiFogaoEmbutido());
                    System.out.println("Status do fogao atualizado para: " + al.isPossuiFogaoEmbutido());
                } else {
                    System.out.println("Opcao invalida para este tipo de apartamento.");
                }
                break;
            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
}