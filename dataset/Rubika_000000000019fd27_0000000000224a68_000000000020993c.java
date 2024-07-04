import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());
        int matrixSize = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer> nonColumnDuplicates = new HashSet<>();
            Set<Integer> nonRowDuplicates = new HashSet<>();
            int diagonalSum = 0;
            for (int row=0; row<matrixSize; row++) {
                String[] numbers = in.nextLine().split("\\s");
                System.out.println(numbers.length);
                for (int column=0;column<matrixSize;column++){
                    matrix[row][column] = Integer.parseInt(numbers[column]);
                }
            }
            for (int j=0; j<matrixSize; j++) {
                    diagonalSum = diagonalSum + matrix[j][j];
                    for (int k=0;k<matrixSize;k++){
                        nonColumnDuplicates.add(matrix[k][j]);
                        nonRowDuplicates.add(matrix[j][k]);
                    }
            }
            int rowDuplicates = matrixSize - nonRowDuplicates.size();
            int columnDuplicates = matrixSize - nonColumnDuplicates.size();
             System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}