import java.util.*;

public class Solution {
    public static int[] solve(int length, int[][] matrix) {
        Map<Integer, Set<Integer>> rowElements = new HashMap<>(length);
        Map<Integer, Set<Integer>> colElements = new HashMap<>(length);
        int[] rowDuplicates = new int[length];
        int[] colDuplicates = new int[length];

        int diagonalSum = 0;
        int rowDupCount = 0;
        int colDupCount = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int element = matrix[i][j];

                rowElements.computeIfAbsent(i, k -> new HashSet<>(length));
                colElements.computeIfAbsent(j, k -> new HashSet<>(length));

                if (rowElements.get(i).contains(element) && rowDuplicates[i] == 0) {
                    rowDuplicates[i] = 1;
                    rowDupCount++;
                }
                if (colElements.get(j).contains(element) && colDuplicates[j] == 0) {
                    colDuplicates[j] = 1;
                    colDupCount++;
                }

                rowElements.get(i).add(element);
                colElements.get(j).add(element);

                if (i == j) {
                    diagonalSum += element;
                }
            }
        }
        return new int[]{diagonalSum, rowDupCount, colDupCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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