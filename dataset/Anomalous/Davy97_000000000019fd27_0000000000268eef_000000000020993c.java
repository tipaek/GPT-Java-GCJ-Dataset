import java.util.Scanner;

public class LongestCount {
    private static final int MAX_SIZE = 101;
    private static int[][] map = new int[MAX_SIZE][MAX_SIZE];
    private static int k, r, c;
    private static int[] counter = new int[MAX_SIZE];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            k = 0;
            r = 0;
            c = 0;
            int N = scan.nextInt();

            // Read map
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    map[row][col] = scan.nextInt();
                }
            }

            // Procedure
            calculateTrace(N);
            countDuplicateRows(N);
            countDuplicateColumns(N);

            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
        scan.close();
    }

    private static void calculateTrace(int N) {
        for (int i = 0; i < N; i++) {
            k += map[i][i];
        }
    }

    private static void countDuplicateRows(int N) {
        for (int i = 0; i < N; i++) {
            resetCounter(N);
            for (int j = 0; j < N; j++) {
                counter[map[i][j]]++;
                if (counter[map[i][j]] > 1) {
                    r++;
                    break;
                }
            }
        }
    }

    private static void countDuplicateColumns(int N) {
        for (int j = 0; j < N; j++) {
            resetCounter(N);
            for (int i = 0; i < N; i++) {
                counter[map[i][j]]++;
                if (counter[map[i][j]] > 1) {
                    c++;
                    break;
                }
            }
        }
    }

    private static void resetCounter(int N) {
        for (int a = 0; a <= N; a++) {
            counter[a] = 0;
        }
    }
}