import java.io.*;
import java.util.Scanner;

class Solution {
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
        Solution obj = new Solution();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int u = 0; u < t; u++) {
            r = 0;
            int cs = u + 1;
            String[] da = scanner.nextLine().split(" ");
            int n = Integer.parseInt(da[0]);
            int x = Integer.parseInt(da[1]);
            int[] a = new int[n];
            for (int z = 0; z < n; z++) {
                a[z] = z + 1;
            }

            int p = factorial(a.length);
            int[][] m = new int[p][a.length];
            int[][] m1 = new int[a.length][a.length];

            obj.heapPermutation(a, a.length, a.length, m);

            if (isPossible(m, m1, x, cs, a.length, p)) {
                System.out.println("Case #" + cs + ": POSSIBLE");
                printMatrix(m1, a.length);
            } else {
                System.out.println("Case #" + cs + ": IMPOSSIBLE");
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

    static boolean isPossible(int[][] m, int[][] m1, int x, int cs, int n, int p) {
        for (int i = 0; i < p; i++) {
            latin(m1, n, m, i);
            int s = 0;
            for (int j = 0; j < n; j++) {
                s += m1[j][j];
            }
            if (s == x) {
                return true;
            }
        }
        return false;
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

    static void printMatrix(int[][] matrix, int n) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }
        System.out.flush();
    }
}