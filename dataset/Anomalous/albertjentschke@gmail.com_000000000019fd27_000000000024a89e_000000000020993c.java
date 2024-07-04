import java.util.*;

public class Solution {

    public static void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        List<String> results = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Size of matrix
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        rowSet.clear(); // Clear to avoid multiple counts
                        break;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        colSet.clear(); // Clear to avoid multiple counts
                        break;
                    }
                }
            }

            results.add("Case #" + (t + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        vestigium();
    }
}