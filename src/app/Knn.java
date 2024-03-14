public class Knn {
    private Dataset dataset;
    private int k;

    public Knn(Dataset dataset, int k) {
        this.dataset = dataset;
        this.k = k;
    }

    public String classify(DataPoint attributes) {
        // Implementação do algoritmo K-NN para classificação
        // Retorna a classe prevista para o ponto de dados fornecido
    }

    public String determineHappiness(double hoursOfSleep, double calories) {
        return classify(attributes);
    }
}