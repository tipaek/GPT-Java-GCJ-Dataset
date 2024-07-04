import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int[] solve(int length, int[][] matrix) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>(length);
        Map<Integer, Set<Integer>> colMap = new HashMap<>(length);

        int diagonalSum = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int value = matrix[i][j];
                
                rowMap.putIfAbsent(i, new HashSet<>(length));
                colMap.putIfAbsent(j, new HashSet<>(length));
                
                Set<Integer> rowSet = rowMap.get(i);
                Set<Integer> colSet = colMap.get(j);

                if (rowSet.contains(value) && rowDuplicates != length) {
                    rowDuplicates++;
                }
                if (colSet.contains(value) && colDuplicates != length) {
                    colDuplicates++;
                }

                rowSet.add(value);
                colSet.add(value);

                if (i == j) {
                    diagonalSum += value;
                }
            }
        }
        return new int[]{diagonalSum, rowDuplicates, colDuplicates};
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                int[] result = solve(size, matrix);
                System.out.println("Case #" + testCase + ": " + result[0] + " " + result[1] + " " + result[2]);
            }
        }
    }
}