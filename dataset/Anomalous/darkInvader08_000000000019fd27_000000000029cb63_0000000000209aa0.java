import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int r = 0;

    static void formArr(int[] a, int n, int[][] m) {
        for (int i = 0; i < n; i++) {
            m[r][i] = a[i];
        }
        r++;
    }

    static void heapPermutation(int[] a, int size, int n, int[][] m) {
        if (size == 1) {
            formArr(a, n, m);
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n, m);

            int temp;
            if (size % 2 == 1) {
                temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            } else {
                temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int u = 0; u < t; u++) {
            r = 0;
            int cs = u + 1;
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);

            int[] a = new int[n];
            for (int z = 0; z < n; z++) {
                a[z] = z + 1;
            }

            int p = factorial(n);
            int[][] m = new int[p][n];
            int[][] m1 = new int[n][n];

            heapPermutation(a, n, n, m);

            boolean possible = false;
            for (int i = 0; i < p; i++) {
                latin(m1, n, m, i);
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += m1[j][j];
                }
                if (sum == x) {
                    possible = true;
                    System.out.println("Case #" + cs + ": POSSIBLE");
                    printMatrix(m1, n);
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + cs + ": IMPOSSIBLE");
            }
        }
    }

    static void latin(int[][] m1, int n, int[][] m, int d) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int o = n - i;
                int v = (o + j) % n + 1;
                m1[i][j] = m[d][v - 1];
            }
        }
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}