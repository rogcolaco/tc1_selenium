package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Filme {

    public int codigo, ano_de_lancamento;
    public String nome, diretor, ator;
    public ArrayList<Filme> filmes = new ArrayList<>();

    public Filme() {
    }

    public Filme(int codigo, int ano_de_lancamento, String nome, String diretor, String ator) {
        this.codigo = codigo;
        this.ano_de_lancamento = ano_de_lancamento;
        this.nome = nome;
        this.diretor = diretor;
        this.ator = ator;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(int ano_de_lancamento) {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

    @Override
    public String toString() {
        return  "\ncodigo do filme = " + codigo +
                "\nano_de_lancamento = " + ano_de_lancamento +
                "\nnome = " + nome +
                "\ndiretor = " + diretor +
                "\nator = " + ator +
                "\n#######\n";
    }

    public ArrayList<Filme> incluirFilme(ArrayList<Filme> filmes, Filme filme){
        filmes.add(filme);
        return filmes;
    }

    public ArrayList<Filme> carregaFilmes(ArrayList<Filme> filmes){

        this.filmes.add(new Filme(1,1999,"Matrix","Lilly Wachowski","Keanu Reeves"));
        this.filmes.add(new Filme(2,2014,"Guardiões da Galáxia","James Gunn","Chris Pratt"));
        this.filmes.add(new Filme(3,2018,"Hereditário","Ari Aster","Toni Collette"));
        this.filmes.add(new Filme(4,2019,"Midsommar: O Mal Não Espera a Noite","Ari Aster"," Florence Pugh"));
        this.filmes.add(new Filme(5,2017,"It: A Coisa","Andy Muschietti","Bill Skarsgård"));
        this.filmes.add(new Filme(6,1988,"Os Fantasmas se Divertem","Tim Burton","Alec Baldwin"));

        return this.filmes;
    }

    public Filme buscarFilme(ArrayList<Filme> filmes, Integer codigo){

        for (Filme f : filmes) {
            if (f.codigo == codigo){
                return f;
            }
        }
            return null;
    }

    public void deletaFilme(ArrayList<Filme> filmes, int codigo){
        for (Filme f : filmes) {
            if (f.codigo == codigo){
                filmes.remove(f);
                System.out.println("\n ### Filme deletado com sucesso ###\n");
                break;
            }
        }
    }

    public void alteraFilme(ArrayList<Filme> filmes, Filme filme){

        for (Filme f : filmes) {
            if (f.codigo == filme.codigo){
                f.setNome(filme.nome);
                f.setDiretor(filme.diretor);
                f.setAno_de_lancamento(filme.ano_de_lancamento);
                f.setAtor(filme.ator);
                break;
            }
        }
    }

}
