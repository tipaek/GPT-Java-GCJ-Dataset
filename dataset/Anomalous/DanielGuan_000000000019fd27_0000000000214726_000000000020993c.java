import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int diagonalSum = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    columnSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) rowDuplicates++;
                if (columnSet.size() != matrixSize) columnDuplicates++;
                diagonalSum += matrix[i][i];
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}