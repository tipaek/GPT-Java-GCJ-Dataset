/**
 * BaZ :D
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    private static MyScanner scan;
    private static PrintWriter pw;
    private static final long MOD = 1_000_000_007;
    private static final long INF = 1_000_000_000_000_000_000L;
    private static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "BaZ", 1 << 27).start();
    }

    private static int[][] permutations;
    private static int permutationIndex;

    private static void solve() throws IOException {
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int[] N = new int[44];
        int[] K = new int[44];
        int pt = 0;
        for (int i = 2; i <= 5; ++i) {
            for (int j = i; j <= i * i; j++) {
                N[pt] = i;
                K[pt++] = j;
            }
        }
        int[] factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; ++i) {
            factorials[i] = factorials[i - 1] * i;
        }
        int t = ni();
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            int n = ni(), k = ni();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = (i + 1 + j);
                    if (matrix[i][j] > n) {
                        matrix[i][j] -= n;
                    }
                }
            }
            permutationIndex = 0;
            permutations = new int[factorials[n]][n];
            generatePermutations(matrix[0], 0);
            boolean found = false;
            int[][] newMatrix = new int[n][n];
            for (int i = 0; i < factorials[n]; i++) {
                int[] p = permutations[i];
                for (int col = 0; col < n; ++col) {
                    int newPos = p[col] - 1;
                    for (int row = 0; row < n; ++row) {
                        newMatrix[row][newPos] = matrix[row][col];
                    }
                }
                int sum = 0;
                for (int j = 0; j < n; ++j) {
                    sum += newMatrix[j][j];
                }
                if (sum == k) {
                    found = true;
                    pw.println("Case #" + caseNum + ": POSSIBLE");
                    for (int[] row : newMatrix) {
                        for (int val : row) {
                            pw.print(val + " ");
                        }
                        pw.println();
                    }
                    break;
                }
            }
            if (!found) {
                pw.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        pw.flush();
        pw.close();
    }

    private static void generatePermutations(int[] arr, int idx) {
        if (idx == arr.length) {
            System.arraycopy(arr, 0, permutations[permutationIndex], 0, arr.length);
            permutationIndex++;
            return;
        }
        for (int i = idx; i < arr.length; ++i) {
            swap(arr, i, idx);
            generatePermutations(arr, idx + 1);
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            pw = new PrintWriter(System.out, true);
        }
    }

    private static int ni() throws IOException {
        return scan.nextInt();
    }

    private static long nl() throws IOException {
        return scan.nextLong();
    }

    private static double nd() throws IOException {
        return scan.nextDouble();
    }

    private static String ne() throws IOException {
        return scan.next();
    }

    private static String nel() throws IOException {
        return scan.nextLine();
    }

    private static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}