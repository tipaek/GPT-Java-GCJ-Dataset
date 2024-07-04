import java.util.Scanner;

public class Jam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];
        int[] rowRepeats = new int[t];
        int[] colRepeats = new int[t];

        for (int a = 0; a < t; a++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int traceSum = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        traceSum += matrix[i][j];
                    }
                }
            }

            // Checking for row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeatCount++;
                        break;
                    }
                }
            }

            // Checking for column duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeatCount++;
                        break;
                    }
                }
            }

            trace[a] = traceSum;
            rowRepeats[a] = rowRepeatCount;
            colRepeats[a] = colRepeatCount;
        }

        // Printing results
        for (int a = 0; a < t; a++) {
            System.out.println("Case #" + (a + 1) + ": " + trace[a] + " " + rowRepeats[a] + " " + colRepeats[a]);
        }
    }
}