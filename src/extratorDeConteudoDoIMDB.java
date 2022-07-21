import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudoDoIMDB implements extradorDeConteudo {

    public List<conteudo> extraiConteudos(String json) {

        // Extrair os dados que nos interessam (título, poster, rating) (Parsear as
        // informacoes)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        System.out.println(listaDeAtributos.size());

        List<conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;

    }

}
