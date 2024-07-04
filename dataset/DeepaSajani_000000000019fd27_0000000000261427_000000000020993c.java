import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfInputs = input.nextInt();
        for (int number = 1; number <= numberOfInputs; number++) {
            int sizeOfMatrix = input.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
            for (int row = 0; row < sizeOfMatrix; row++) {
                for (int column = 0; column < sizeOfMatrix; column++) {
                    int elem = input.nextInt();
                    matrix[row][column] = elem;
                }
            }
            System.out.println("Case #" + number + ": " + solution(matrix));
        }
    }

    private static String solution(int[][] matrix) {
        int rowCountsWithDuplicates = 0;
        int columnCountsWithDuplicates = 0;
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowElems = new HashSet<>();
            Set<Integer> columnElems = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                int rowElem = matrix[i][j];
                int columnElem = matrix[j][i];
                if (rowElems.contains(rowElem) && rowElems.size() == j) {
                    rowCountsWithDuplicates++;
                } else
                    rowElems.add(rowElem);
                if (columnElems.contains(columnElem) && columnElems.size() == j)
                    columnCountsWithDuplicates++;
                else
                    columnElems.add(columnElem);
                if (i == j) trace += rowElem;
            }
        }
        return trace + " " + rowCountsWithDuplicates + " " + columnCountsWithDuplicates;
    }
}
