import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import Algoritmos.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int size = 1000;
        int[] array = generateRandomArray(size);

        double totalTime = 0;
        for (int i = 0; i < 10; i++) {
            totalTime += benchmark(array);
        }

        double averageTime = totalTime / 10;
        //System.out.println("Tempo médio de execução: " + averageTime + " segundos\n\n");

        String[] dataBaseNames = {
                
                "1m desordenados",
                "1m ordenados",
                "1m ordernadosF",
                "2m desordenados",
                "2m ordernados",
                "2m ordernadosF",
                "3m desordenados",
                "3m ordenados",
                "3m ordenadosF",

        };

        String[] dataBaseSearchName = { "busca_1m" };

        ArrayList<double[]> vectors = ProcessFiles.process_Files("/home/gui/Desktop/Projeto_Arvores_Binarias/MassaDeTestes");
        ArrayList<double[]> vectorsToSearch = ProcessFiles.process_Files("/home/gui/Desktop/Projeto_Arvores_Binarias/MassaBusca");

        for (double[] ds : vectors) {





            SplayTree arvore = new SplayTree();





            ArrayList<Algoritmo> algoritmos = new ArrayList<>();

            System.out.printf("> %s\n", dataBaseNames[vectors.indexOf(ds)]);
            long startTime = System.currentTimeMillis();

            for (double data : ds) {
                arvore.insert(data);
            }
            long endTime = System.currentTimeMillis();
            int quantRotations = arvore.countRotations();




            algoritmos.add(new Algoritmo("SPLAY", (endTime - startTime) / averageTime, quantRotations, arvore.getHeight(), dataBaseNames[vectors.indexOf(ds)]));





            AlgoritmoUtils.gerarCsv(algoritmos, "ResultsInsertion");
            ArrayList<Algoritmo> algoritmosSearch = new ArrayList<>();



            if (vectors.indexOf(ds) > 5) {




                vectorsToSearch.stream().forEach(data -> {
                    long startTimeSearch = System.currentTimeMillis();
                    for (double dado : data) {
                        arvore.search(dado);
                    }
                    long endTimeSearch = System.currentTimeMillis();




                    algoritmosSearch.add(new Algoritmo("SPLAY", dataBaseNames[vectors.indexOf(ds)], dataBaseSearchName[vectorsToSearch.indexOf(data)], (endTimeSearch - startTimeSearch) / averageTime));




                });
                AlgoritmoUtils.gerarCsvBusca(algoritmosSearch, "ResultsSearch");
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int sumArray(int[] array, int index) {
        if (index >= array.length) return 0;
        return array[index] + sumArray(array, index + 1);
    }

    public static double benchmark(int[] array) {
        long startTime = System.nanoTime();
        int sum = sumArray(array, 0);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000_000.0;
        //System.out.println("Soma dos elementos do array: " + sum);
        return elapsedTime;
    }
}
