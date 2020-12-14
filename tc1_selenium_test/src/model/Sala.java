package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Sala {

    private int codigo, capacidade;
    private String nome, tipo_de_exibicao, telefone_sala;
    private boolean acessivel;

    public Sala() {
    }

    public Sala(int codigo, int capacidade, String nome, String tipo_de_exibicao, String telefone_sala, boolean acessivel) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.nome = nome;
        this.tipo_de_exibicao = tipo_de_exibicao;
        this.telefone_sala = telefone_sala;
        this.acessivel = acessivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_de_exibicao() {
        return tipo_de_exibicao;
    }

    public void setTipo_de_exibicao(String tipo_de_exibicao) {
        this.tipo_de_exibicao = tipo_de_exibicao;
    }

    public String getTelefone_sala() {
        return telefone_sala;
    }

    public void setTelefone_sala(String telefone_sala) {
        this.telefone_sala = telefone_sala;
    }

    public boolean isAcessivel() {
        return acessivel;
    }

    public void setAcessivel(boolean acessivel) {
        this.acessivel = acessivel;
    }

    @Override
    public String toString() {

        return  "\ncodigo da sala = " + codigo +
                "\ncapacidade = " + capacidade +
                "\nnome = " + nome +
                "\ntipo de exibição = " + tipo_de_exibicao +
                "\ntelefone da sala = " + telefone_sala +
                "\nacessivel = " + acessivel +
                "\n#######\n";
    }

    public ArrayList<Sala> carregaSalas(){
        ArrayList carregaArraySala = new ArrayList();

        carregaArraySala.add(new Sala(1,20,"Sala 1","2D","(16)3351-1010",true));
        carregaArraySala.add(new Sala(2,25,"Sala 2","2D","(16)3351-1020",true));
        carregaArraySala.add(new Sala(3,20,"Sala 3","2D","(16)3351-1030", false));
        carregaArraySala.add(new Sala(4,30,"Sala 4","3D","(16)3351-1040",true));
        carregaArraySala.add(new Sala(5,15,"Sala 5","3D","(16)3351-1050", false));
        carregaArraySala.add(new Sala(6,22,"Sala 6","2D","(16)3351-1060", true));
        carregaArraySala.add(new Sala(7,25,"Sala 7","3D","(16)3351-1070", false));

        return carregaArraySala;
    }

    public Sala buscarSala(ArrayList<Sala> salas){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInforme o códiogo da Sala:");
        codigo = Integer.parseInt(scanner.nextLine());

        for (Sala s : salas) {
            if (s.codigo == codigo){
                return s;
            }
        }
        return null;
    }

    public void deletaSala(ArrayList<Sala> salas, int codigo){
        for (Sala s : salas) {
            if (s.codigo == codigo){
                salas.remove(s);
                System.out.println("\n ### Filme deletado com sucesso ###\n");
                break;
            }
        }
    }

    public ArrayList<Sala> incluirSala(ArrayList<Sala> salas){
        int codigo, capacidade;
        String nome, tipo_de_exibicao, telefone_sala;
        boolean acessivel;
        boolean checkCodigo = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInforme o códiogo do filme:");
        codigo = Integer.parseInt(scanner.nextLine());
        for (Sala s : salas){
            if (s.codigo == codigo){
                System.out.println("Código já Cadastrado");
                checkCodigo = false;
                break;
            }
        }
        if (checkCodigo == true) {
            System.out.println("\nInforme a capacidade da sala:");
            capacidade = Integer.parseInt(scanner.nextLine());
            System.out.println("\nInforme o nome dda sala:");
            nome = scanner.nextLine();
            System.out.println("\nInforme o tipo de exibição da sala:");
            tipo_de_exibicao = scanner.nextLine();
            System.out.println("\nInforme o telefone da sala:");
            telefone_sala = scanner.nextLine();
            System.out.println("\nInforme se existe acessibilidade na sala:");
            acessivel = Boolean.parseBoolean(scanner.nextLine());

            Sala novaSala = new Sala(codigo, capacidade,nome,tipo_de_exibicao,telefone_sala,acessivel);
            salas.add(novaSala);
            System.out.println("\n ### Sala incluída com sucesso ### \n");
        } else {
            System.out.println("\n ### Sala não cadastrado ### \n");
        }
        return salas;
    }

    public void alterarSala(ArrayList<Sala> salas, Sala sala){
        Scanner scanner = new Scanner(System.in);

        for (Sala s : salas) {
            if (s.codigo == sala.codigo){
                System.out.println("\nInforme a capacidade da sala:");
                s.setCapacidade(Integer.parseInt(scanner.nextLine()));
                System.out.println("\nInforme o nome dda sala:");
                s.setNome(scanner.nextLine());
                System.out.println("\nInforme o tipo de exibição da sala:");
                s.setTipo_de_exibicao(scanner.nextLine());
                System.out.println("\nInforme o telefone da sala:");
                s.setTelefone_sala(scanner.nextLine());
                System.out.println("\nInforme se existe acessibilidade na sala:");
                s.setAcessivel(Boolean.parseBoolean(scanner.nextLine()));
                break;
            }
        }
    }
}
