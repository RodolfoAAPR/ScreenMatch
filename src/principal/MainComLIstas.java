package principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainComLIstas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.avaliarFilme(8);

        Filme meuFilme1 = new Filme("Velozes e Furiosos: Desafio em Tóquio", 2006);
        meuFilme1.avaliarFilme(10);

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avaliarFilme(6);

        Serie serie = new Serie("Supernatural", 2017);

        List<Titulo> lista = new LinkedList<>();
        lista.add(meuFilme);
        lista.add(meuFilme1);
        lista.add(filmeDoPaulo);
        lista.add(serie);

        for(Titulo titulo : lista) {
            System.out.println("Nome: " + titulo.getNome());
            if (titulo instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista= new LinkedList<>();
        buscaPorArtista.add("Misha Collins");
        buscaPorArtista.add("Jensen Ackles");
        buscaPorArtista.add("Jared Padalecki");
        System.out.println("\nArtistas Antes da Ordenação: " + buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("\nLista de Títulos Ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Filmes Ordenados por Ano: " + lista);
    }
}
