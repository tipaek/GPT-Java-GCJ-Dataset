import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int u = 0; u < t; u++) {
            r = 0;
            int cs = u + 1;
            String[] da = br.readLine().split(" ");
            int n = Integer.parseInt(da[0]);
            int x = Integer.parseInt(da[1]);
            int[] a = new int[n];
            for (int z = 0; z < n; z++) {
                a[z] = z + 1;
            }

            int p = 1;
            for (int i = 1; i <= a.length; i++) {
                p *= i;
            }
            int[][] m = new int[p][a.length];
            int[][] m1 = new int[a.length][a.length];

            boolean found = false;
            heapPermutation(a, a.length, a.length, m);
            for (int i = 0; i < p; i++) {
                latin(m1, a.length, m, i);
                int sum = 0;
                for (int j = 0; j < a.length; j++) {
                    sum += m1[j][j];
                }
                if (sum == x) {
                    found = true;
                    System.out.println("Case #" + cs + ": POSSIBLE");
                    for (int[] row : m1) {
                        for (int val : row) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Case #" + cs + ": IMPOSSIBLE");
            }
            System.out.flush();
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
}