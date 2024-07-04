import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] matrix = new int[m][m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int j = 0; j < m; j++) {
                trace += matrix[j][j];
            }

            for (int j = 0; j < m; j++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
                for (int k = 0; k < m; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}