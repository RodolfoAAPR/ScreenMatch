package principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.servicos.GerenciadorDeTitulos;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.setDuracaoEmMinutos(175);
        System.out.println("A duração do filme é " + meuFilme.getDuracaoEmMinutos() + " minutos.");

        meuFilme.exibeFichaTecnica();
        meuFilme.avaliarFilme(8);
        meuFilme.avaliarFilme(6.5);
        meuFilme.avaliarFilme(10);

        System.out.println("A soma das notas é " + meuFilme.getTotalDeAvaliacoes());
        System.out.printf("A média de notas é %.1f%n", meuFilme.pegaMedia());

        Filme meuFilme1 = new Filme("Velozes e Furiosos: Desafio em Tóquio", 2006);
        meuFilme1.setDuracaoEmMinutos(104);

        meuFilme1.exibeFichaTecnica();
        meuFilme1.avaliarFilme(10);
        meuFilme1.avaliarFilme(8.5);
        meuFilme1.avaliarFilme(9);

        System.out.println("A soma das notas é " + meuFilme1.getTotalDeAvaliacoes());
        System.out.printf("A média das notas é %.1f%n", meuFilme1.pegaMedia());

        Serie Supernatural = new Serie("Supernatural", 2005);
        Supernatural.exibeFichaTecnica();
        Supernatural.setTemporadas(15);
        Supernatural.setEpisodiosPorTemporada(23);
        Supernatural.setMinutosPorEpisodio(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme1);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(meuFilme1);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(Supernatural);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avaliarFilme(10);


        GerenciadorDeTitulos gerenciadorDeTitulos = new GerenciadorDeTitulos();
        gerenciadorDeTitulos.adicionaTitulo(meuFilme);
        gerenciadorDeTitulos.adicionaTitulo(meuFilme1);
        gerenciadorDeTitulos.adicionaTitulo(filmeDoPaulo);
        gerenciadorDeTitulos.exibeTamanhoPrimeiroLista();
    }
}
