import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class AlgoritmoUtils {
    public static void gerarCsv(List<Algoritmo> algoritmos, String nomeArquivo) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nomeArquivo + ".csv", "rw")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(raf.getFD()))) {
                if (raf.length() == 0) {
                    bufferedWriter.write("Algoritmo,Base de Dados,Tempo,Rotations,Height");
                    bufferedWriter.newLine();
                }
                raf.seek(raf.length());
                for (Algoritmo algoritmo : algoritmos) {
                    bufferedWriter.write(
                            algoritmo.getNome() + "," + algoritmo.getDataBase() + "," + (int) algoritmo.getTempo() + "," + algoritmo.getRotations() + "," + algoritmo.getHeight());
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static void gerarCsvBusca(List<Algoritmo> algoritmos, String nomeArquivo) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nomeArquivo + ".csv", "rw")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(raf.getFD()))) {
                if (raf.length() == 0) {
                    bufferedWriter.write("Algoritmo,Base de Dados,Base de Dados Pesquisa,Tempo");
                    bufferedWriter.newLine();
                }
                raf.seek(raf.length());
                for (Algoritmo algoritmo : algoritmos) {
                    bufferedWriter.write(
                            algoritmo.getNome() + "," + algoritmo.getNomeBaseDaArvore() + "," + algoritmo.getNomeBaseBusca() + "," + algoritmo.getTempo());
                    bufferedWriter.newLine();
                }
            }
        }
    }
}
