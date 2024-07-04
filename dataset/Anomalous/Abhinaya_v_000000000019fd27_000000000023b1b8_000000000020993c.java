import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int h = 0; h < t; h++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            boolean validInput = true;

            for (int i = 0; i < n && validInput; i++) {
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (value > n || value <= 0) {
                        validInput = false;
                        break;
                    }
                    matrix[i][j] = value;
                }
            }

            if (!validInput) {
                continue;
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            results[h][0] = trace;
            results[h][1] = rowDuplicates;
            results[h][2] = colDuplicates;
        }

        for (int i = 0; i < t; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, results[i][0], results[i][1], results[i][2]);
        }
    }
}