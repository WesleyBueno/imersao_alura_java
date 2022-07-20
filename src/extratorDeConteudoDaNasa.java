
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudoDaNasa {
    
    public List<conteudo> extraiConteudos(String json){

        // Extrair os dados que nos interessam (título, poster, rating) (Parsear as informacoes)
        var parser = new JsonParser(); 
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        System.out.println(listaDeAtributos.size());

        List<conteudo> conteudos = new ArrayList<>();

        

        return conteudos;

    }

}
