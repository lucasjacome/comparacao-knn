package app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Dataset dataset = new Dataset("feliz.csv");

        Knn knn = new Knn(dataset, 3);
        System.out.println(knn.classify(new DataPoint(1500, 2)));
    }

}