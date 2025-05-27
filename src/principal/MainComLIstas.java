package principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class MainComLIstas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.avaliarFilme(8);

        Filme meuFilme1 = new Filme("Velozes e Furiosos: Desafio em Tóquio", 2006);
        meuFilme1.avaliarFilme(10);

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avaliarFilme(6);

        Serie serie = new Serie("Supernatural", 2017);

        ArrayList<Titulo> lista = new ArrayList<>();
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
    }
}
