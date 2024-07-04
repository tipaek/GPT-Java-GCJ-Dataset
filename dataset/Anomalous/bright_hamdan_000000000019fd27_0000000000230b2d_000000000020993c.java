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
            int tr = 0, r = 0, c = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        tr += matrix[i][j];
                    }
                }
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[j][i])) {
                        c++;
                        break;
                    }
                }
            }

            trace[a] = tr;
            rowRepeats[a] = r;
            colRepeats[a] = c;
            System.out.println("Case #" + (a + 1) + ": " + trace[a] + " " + rowRepeats[a] + " " + colRepeats[a]);
        }
    }
}