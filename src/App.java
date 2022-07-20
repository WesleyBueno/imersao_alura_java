import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
// Fazer uma conexao HTTP e buscar o top 250 filmes do imdb

        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var Client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = Client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

// Extrair os dados que nos interessam (título, poster, rating) (Parsear as informacoes)
        var parser = new JsonParser(); 
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());
// Exibir e manipular os dados

    GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImage = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = titulo + ".png";

            
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }

    //DESAFIOS

    //acessar outro endpoint
    //Melhorar a saída da informacao
    //extrair as chaves para um arquivo .env

    //MEGA DESAFIOS
    //Usar uma biblioteca (jacskon) para fazer o parser
    //Criar um método para você dar uma avaliação para o filme (Scanner)
}
