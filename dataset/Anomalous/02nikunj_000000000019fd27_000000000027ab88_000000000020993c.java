import java.util.HashMap;
import java.util.Scanner;

public class Jam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            testCase++;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0, colDuplicates = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map.containsKey(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    } else {
                        map.put(matrix[i][j], j);
                    }
                }
                map.clear();
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (map.containsKey(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    } else {
                        map.put(matrix[i][j], i);
                    }
                }
                map.clear();
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}