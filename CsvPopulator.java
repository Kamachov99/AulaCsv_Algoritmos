import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class CsvPopulator {

    private static final String filePath = "registros.csv";
    private static final String[] nomes = {
        "Cristiano Ronaldo", "Lionel Messi", "Zlatan Ibrahimović", "Daniel Alves", "Ronaldo Luís Nazário", "Thierry Henry",
        "Paolo Maldini", "Ronaldinho Gaucho", "Kaká", "Luis", "Andrés", "Iker", "Wayne",
        "David", "Gerard", "Arjen", "Zinedine", "Samuel", "Didier", "Luis",
        "Gianluigi", "Romário", "Cafú", "Miroslav", "Sergio"
    };
    private static final String[] sobreNomes = {
        "Messi", "Ibrahimović", "Alves", "Nazário", "Henry", "Maldini", "Gaúcho",
        "Leite", "Suárez", "Iniesta", "Casillas", "Rooney", "Beckham", "Piqué",
        "Robben", "Zidane", "Eto'o", "Drogba", "Figo", "Buffon", "Klose",
        "Ramos"
    };    
    private static final String[] países = {
        "Brasil", "Alemanha", "França", "Espanha", "Itália",
        "Portugal", "Argentina", "Holanda", "Camarões", "Costa do Marfim",
        "Inglaterra", "Suécia", "Uruguai"
    };

    public static void popularArquivoCsv() {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < 50; i++) {
                String nome = nomes[random.nextInt(nomes.length)]+' '+sobreNomes[random.nextInt(sobreNomes.length)];
                int idade = random.nextInt(63) + 18; // Idade entre 18 e 80
                String cidade = cidades[random.nextInt(cidades.length)];

                writer.append(nome).append(",")
                      .append(String.valueOf(idade)).append(",")
                      .append(cidade).append("\n");
            }
            JOptionPane.showMessageDialog(null, "50 registros aleatórios adicionados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        popularArquivoCsv(); // Chama a função para popular o arquivo
    }
}