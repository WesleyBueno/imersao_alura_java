import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexao HTTP e buscar o top 250 filmes do imdb

         String url = "https://alura-imdb-api.herokuapp.com/movies";
        //String url = "https://api.nasa.gov/planetary/apod?api_key=V2bmZkbDzlM0axxIFmU0tOU7d1pENOmNpjMepbVs&start_date=2022-07-17&end_date=2022-07-20";

        var http = new clientHttp();
        String json = http.buscaDados(url);
        // System.out.println(body);

        // Exibir e manipular os dados
        //extratorDeConteudoDoIMDB extrator = new extratorDeConteudoDoIMDB();
        extratorDeConteudoDaNasa extrator = new extratorDeConteudoDaNasa();
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 1; i++) {

            conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }

    // DESAFIOS

    // acessar outro endpoint
    // Melhorar a saída da informacao
    // extrair as chaves para um arquivo .env

    // MEGA DESAFIOS
    // Usar uma biblioteca (jacskon) para fazer o parser
    // Criar um método para você dar uma avaliação para o filme (Scanner)
}
