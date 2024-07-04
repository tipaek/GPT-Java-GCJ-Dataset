import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int element : matrix[i]) {
                    uniqueElements.add(element);
                }
                if (uniqueElements.size() != matrixSize) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    uniqueElements.add(matrix[i][j]);
                }
                if (uniqueElements.size() != matrixSize) {
                    colRepeats++;
                }
            }

            writer.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        writer.close();
    }
}