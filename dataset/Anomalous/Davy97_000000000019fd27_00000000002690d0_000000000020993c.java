import java.util.Scanner;

public class Solution {
    static int[][] map = new int[101][101];
    static int k, r, c;
    static int[] counter = new int[101];

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

            // Perform calculations
            calculateTrace(N);
            calculateRows(N);
            calculateColumns(N);

            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
        scan.close();
    }

    private static void calculateTrace(int N) {
        for (int i = 0; i < N; i++) {
            k += map[i][i];
        }
    }

    private static void calculateRows(int N) {
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

    private static void calculateColumns(int N) {
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