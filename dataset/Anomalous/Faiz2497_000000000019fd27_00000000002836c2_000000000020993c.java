import java.util.Scanner;

public class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] array = new int[N][N];
            int trace = 0, r = 0, c = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    array[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += array[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(array[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(array[i][j])) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }

        sc.close();
    }
}