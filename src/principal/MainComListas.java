package principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.servicos.GerenciadorDeTitulos;

public class MainComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.avaliarFilme(8);

        Filme meuFilme1 = new Filme("Velozes e Furiosos: Desafio em Tóquio", 2006);
        meuFilme1.avaliarFilme(10);

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avaliarFilme(6);

        Serie serie = new Serie("Supernatural", 2017);

        GerenciadorDeTitulos gerenciadorDeTitulos = new GerenciadorDeTitulos();
        gerenciadorDeTitulos.adicionaTitulo(meuFilme);
        gerenciadorDeTitulos.adicionaTitulo(meuFilme1);
        gerenciadorDeTitulos.adicionaTitulo(filmeDoPaulo);
        gerenciadorDeTitulos.adicionaTitulo(serie);

        gerenciadorDeTitulos.exibeNomeClassificacao();

        gerenciadorDeTitulos.adicionaArtistas("Misha Collins");
        gerenciadorDeTitulos.adicionaArtistas("Jensen Ackles");
        gerenciadorDeTitulos.adicionaArtistas("Jared Padalecki");
        gerenciadorDeTitulos.exibeArtistasDesordenados();

        gerenciadorDeTitulos.exibeArtistasOrdenados();
        gerenciadorDeTitulos.exibeTitulosOrdenados();
        gerenciadorDeTitulos.exibeTitulosOrdenadosPorAno();
    }
}
