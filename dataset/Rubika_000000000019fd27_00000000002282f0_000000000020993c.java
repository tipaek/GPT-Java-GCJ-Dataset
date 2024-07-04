import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
       public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            int matrixSize = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            for (int row=0; row<matrixSize; row++) {
                String[] numbers = in.nextLine().split("\\s");
                Set<Integer> nonRowDuplicates = new HashSet<>();
                Set<Integer> nonColumnDuplicates = new HashSet<>();
                for (int column=0;column<matrixSize;column++){
                    matrix[row][column] = Integer.parseInt(numbers[column]);
                    nonRowDuplicates.add(matrix[row][column]);
                    if (row==column) {
                        diagonalSum = diagonalSum + matrix[row][column];
                    }
                }
                rowDuplicates = rowDuplicates + (matrixSize-nonRowDuplicates.size());
            }
           
             System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}