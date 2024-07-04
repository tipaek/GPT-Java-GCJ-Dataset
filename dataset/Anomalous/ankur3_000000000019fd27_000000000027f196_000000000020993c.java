import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = 0, rowDupCount = 0, colDupCount = 0;
            
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDupCount++;
                        break;
                    }
                }
                for (int j = 0; j < size; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDupCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDupCount + " " + colDupCount);
        }
    }
}