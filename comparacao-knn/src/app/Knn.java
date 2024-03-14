package app;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;


public class Knn {
    private Dataset dataset;
    private int k;

    public Knn(Dataset dataset, int k) {
        this.dataset = dataset;
        this.k = k;
    }

    public String classify(DataPoint attributes) {
        // Implementação do algoritmo K-NN para classificação
        LinkedList<DataPoint> dataPoints = (LinkedList<DataPoint>) this.dataset.getDataPoints();
        DataPoint dataPointMaisProx = null;
        double distanciaMaisProx = Double.MAX_VALUE;
        double distanciaAux;

        List<DistanciaPonto> listDistancias = new LinkedList<DistanciaPonto>();

        for(DataPoint dataPoint:dataPoints){
            distanciaAux = calcularDistancia(attributes, dataPoint);
            listDistancias.add(new DistanciaPonto(dataPoint, distanciaAux));
        }

        listDistancias.sort(Comparator.reverseOrder());

        Map<String, Integer> mapFrequencia = new HashMap<>();
        listDistancias = listDistancias.stream().limit(this.k).toList();
        for (DistanciaPonto distanciaPonto:listDistancias) {
            mapFrequencia.put(distanciaPonto.dataPoint.getEstado(), mapFrequencia.getOrDefault(distanciaPonto.dataPoint.getEstado(), 0) + 1);
        }

        String maisFrequente = mapFrequencia.keySet().stream().max((estado1, estado2) -> Integer.compare(mapFrequencia.get(estado1), mapFrequencia.get(estado2))).get();

        // Retorna a classe prevista para o ponto de dados fornecido
        return maisFrequente;
    }

    public String determineHappiness(double horaSono, double caloria) {

        return classify(new DataPoint(caloria, horaSono));
    }

    public double calcularDistancia(DataPoint dataPoint1, DataPoint dataPoint2){
        return Math.sqrt(Math.abs(dataPoint2.getCaloria() / 3000 - dataPoint1.getCaloria() / 3000)
                        + Math.abs(dataPoint1.getHora() / 3000 - dataPoint2.getHora()/3000));

    }

    public class DistanciaPonto implements Comparable<DistanciaPonto>{
        private DataPoint dataPoint;
        private double distancia;

        public DistanciaPonto(DataPoint dataPoint, double distancia){
            this.distancia = distancia;
            this.dataPoint = dataPoint;
        }

        public int compareTo(DistanciaPonto o) {
            return Double.compare(o.distancia, this.distancia);
        }
    }

}