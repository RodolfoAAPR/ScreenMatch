package br.com.alura.screenmatch.servicos;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;


public class GerenciadorDeTitulos {
    protected ArrayList<Titulo> listaDeFilmes = new ArrayList<>();
    protected List<String> buscaPorArtista = new LinkedList<>();

    public void adicionaTitulo(Titulo titulo){
        listaDeFilmes.add(titulo);
    }

    public void exibeTamanhoPrimeiroLista(){
        System.out.println("\nO tamanho da lista é " + listaDeFilmes.size());
        System.out.println("O primeiro filme é " + listaDeFilmes.getFirst().getNome());
        System.out.println("O primeiro é " + listaDeFilmes.getFirst().toString());
        System.out.println("\nA lista completa é");
        for (Titulo filmes : listaDeFilmes)
            System.out.println(filmes);
    }

    public void exibeNomeClassificacao(){
        for (Titulo titulo : listaDeFilmes){
            System.out.println("Nome: " + titulo.getNome());
            if (titulo instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }
    }

    public void adicionaArtistas(String artista){
        buscaPorArtista.add(artista);
    }

    public void exibeArtistasDesordenados(){
        System.out.println("\nArtistas antes da Ordenação: " + buscaPorArtista);
    }
    public void exibeArtistasOrdenados(){
        Collections.sort(buscaPorArtista);
        System.out.println("Artistas em Ordem Alfabética: " +buscaPorArtista);
    }

    public void exibeTitulosOrdenados(){
        Collections.sort(listaDeFilmes);
        System.out.println("Filmes Organizados: " + listaDeFilmes);
    }

    public void exibeTitulosOrdenadosPorAno(){
        listaDeFilmes
                .sort(Comparator
                        .comparing(Titulo::getAnoDeLancamento));
        System.out.println("Títulos Organizados por Ano: " + listaDeFilmes);
    }
}
