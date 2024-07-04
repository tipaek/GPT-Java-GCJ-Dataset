import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int SIZE = 10;
    private static final int CASES = 3;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int z = Integer.parseInt(scanner.nextLine());
        int[][] a = new int[SIZE][SIZE];
        int[] b = new int[SIZE];
        int[] d = new int[SIZE];
        int[] r = new int[CASES];
        int[] c = new int[CASES];
        int[] s = new int[CASES];

        for (int x = 0; x < z; x++) {
            int l = 0;
            resetArray(b);
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        s[x] += a[i][j];
                    }
                }
            }

            l = processRows(a, b, n, l);
            r[x] = findMax(b);

            resetArray(d);
            l = processColumns(a, d, n, l);
            c[x] = findMax(d);
        }

        printResults(r, c, s);
    }

    private static void resetArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static int processRows(int[][] a, int[] b, int n, int l) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                int t = a[k][i];
                for (int j = i; j < n; j++) {
                    if (t == a[k][j]) {
                        b[l]++;
                    }
                }
                l++;
            }
        }
        return l;
    }

    private static int processColumns(int[][] a, int[] d, int n, int l) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                int t = a[i][k];
                for (int j = i; j < n; j++) {
                    if (t == a[j][k]) {
                        d[l]++;
                    }
                }
                l++;
            }
        }
        return l;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max == 1 ? 0 : max;
    }

    private static void printResults(int[] r, int[] c, int[] s) {
        for (int i = 0; i < CASES; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, s[i], r[i], c[i]);
        }
    }
}