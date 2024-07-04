import java.util.Scanner;

public class LongestCount {
    private static final int MAX_SIZE = 101;
    private static int[][] map = new int[MAX_SIZE][MAX_SIZE];
    private static int k, r, c;
    private static int[] counter = new int[MAX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            resetValues();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            calculateTrace(N);
            countRowsWithDuplicates(N);
            countColsWithDuplicates(N);

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
        scanner.close();
    }

    private static void resetValues() {
        k = 0;
        r = 0;
        c = 0;
    }

    private static void calculateTrace(int N) {
        for (int i = 0; i < N; i++) {
            k += map[i][i];
        }
    }

    private static void countRowsWithDuplicates(int N) {
        r = 0;
        for (int i = 0; i < N; i++) {
            resetCounter(N);
            for (int j = 0; j < N; j++) {
                if (++counter[map[i][j]] > 1) {
                    r++;
                    break;
                }
            }
        }
    }

    private static void countColsWithDuplicates(int N) {
        c = 0;
        for (int j = 0; j < N; j++) {
            resetCounter(N);
            for (int i = 0; i < N; i++) {
                if (++counter[map[i][j]] > 1) {
                    c++;
                    break;
                }
            }
        }
    }

    private static void resetCounter(int N) {
        for (int i = 0; i <= N; i++) {
            counter[i] = 0;
        }
    }
}