import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
// Fazer uma conexao HTTP e buscar o top 250 filmes do imdb

        //String url = "https://alura-imdb-api.herokuapp.com/movies";
        String url = "https://api.nasa.gov/planetary/apod?api_key=V2bmZkbDzlM0axxIFmU0tOU7d1pENOmNpjMepbVs&start_date=2022-07-20&end_date=2022-07-20";
        

        var http = new clientHttp();
        String json = http.buscaDados(url);
        //System.out.println(body);


// Exibir e manipular os dados

    var geradora = new GeradoraDeFigurinhas();

    for (int i = 0; i < 1; i++) {
        
        Map<String,String> conteudo = listaDeConteudos.get(i);

        String urlImage = conteudo.get("url").replaceAll("(@+)(.*).jpg$", "$1.jpg");

        String titulo = conteudo.get("title");

        InputStream inputStream = new URL(urlImage).openStream();
        String nomeArquivo = "saida/" + titulo + ".png";

        
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
