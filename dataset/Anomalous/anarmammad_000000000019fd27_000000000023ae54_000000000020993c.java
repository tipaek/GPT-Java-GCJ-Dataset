import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int testCases = Integer.parseInt(br.readLine());

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int matrixSize = Integer.parseInt(br.readLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                int diagonalSum = 0;

                for (int i = 0; i < matrixSize; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                        if (i == j) {
                            diagonalSum += matrix[i][j];
                        }
                    }
                }

                HashSet<Integer> repeatedRows = new HashSet<>();
                HashSet<Integer> repeatedColumns = new HashSet<>();

                for (int i = 0; i < matrixSize; i++) {
                    HashSet<Integer> rowElements = new HashSet<>();
                    for (int j = 0; j < matrixSize; j++) {
                        if (!rowElements.add(matrix[i][j])) {
                            repeatedRows.add(i);
                        }
                    }
                }

                for (int j = 0; j < matrixSize; j++) {
                    HashSet<Integer> columnElements = new HashSet<>();
                    for (int i = 0; i < matrixSize; i++) {
                        if (!columnElements.add(matrix[i][j])) {
                            repeatedColumns.add(j);
                        }
                    }
                }

                bw.write(String.format("#%d: %d %d %d%n", testCase, diagonalSum, repeatedRows.size(), repeatedColumns.size()));
            }

            bw.flush();
        }
    }
}