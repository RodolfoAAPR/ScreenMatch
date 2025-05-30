package principal;

import br.com.alura.screenmatch.excecao.ErroConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String busca = "";

        while (!busca.equalsIgnoreCase("SAIR")) {

            System.out.print("Insira o filme que deseja buscar: ");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("SAIR")){
                break;
            }

            String encoded = URLEncoder
                    .encode(busca, StandardCharsets.UTF_8)
                    .replace("+", "%20");

            String url = "https://www.omdbapi.com/?t=" + encoded + "&apikey=57134a81";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);


//      Titulo meuTitulo = gson.fromJson(json, Titulo.class);

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println("Titulo: " + meuTituloOmdb);
            try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("TÍTULO CONVERTIDO!");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException error) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(error.getMessage());
            } catch (IllegalArgumentException error) {
                System.out.println("Aconteceu um erro no endereço de busca. Verifique! ");
            } catch (ErroConversaoDeAnoException error) {
                System.out.println(error.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("Filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("\nO programa foi finalizado corretamente!");
    }
}
