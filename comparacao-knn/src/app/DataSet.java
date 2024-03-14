package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dataset {
    private List<DataPoint> dataPoints;

    public List<DataPoint> getDataPoints() {
        // retorna o vetor com os dados carregados

        return dataPoints;
    }

    public Dataset(String filename) {
        // Implementar construtor
        this.dataPoints = new LinkedList<>();
        this.loadDataFromCSV(filename);
    }

    public void loadDataFromCSV(String filename) {
        // Implementação para ler dados do arquivo CSV e carregar na lista de pontos de dados

        String divisor = ";";
        String[] componentes;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(divisor);

                dataPoints.add(new DataPoint(Double.parseDouble(campos[0]), Double.parseDouble(campos[1]), campos[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}