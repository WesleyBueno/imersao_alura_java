import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        //Leitura da imagem
        //InputStream InputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Criar uma nova imagem com trasnparencia e tamanho novo (em memoria)

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memoria)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //Configurar a fonte

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.BLUE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem

        graphics.drawString("TOPZERA", 500, novaAltura - 100);

        
        // escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}

//Desafios

//Como obter a imagem grande
//Melhorar o texto com base na avaliacao do filme, centralizar, usar a impact(font) e a cor amarela
// olhar a documentacao do inputStream
