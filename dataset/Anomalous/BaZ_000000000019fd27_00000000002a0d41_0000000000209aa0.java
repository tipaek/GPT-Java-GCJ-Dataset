import java.util.*;
import java.io.*;

public class Solution {
    static MyScanner scanner;
    static PrintWriter writer;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (i + 1 + j) % n + 1;
                }
            }

            boolean found = false;
            int[][] newMatrix = new int[n][n];
            for (int i = 0; i < 8000; i++) {
                int[] permutation = getRandomPermutation(n);
                for (int col = 0; col < n; col++) {
                    int newPos = permutation[col] - 1;
                    for (int row = 0; row < n; row++) {
                        newMatrix[row][newPos] = matrix[row][col];
                    }
                }

                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += matrix[j][j];
                }

                if (sum == k) {
                    found = true;
                    writer.println("Case #" + caseNum + ": POSSIBLE");
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {
                            writer.print(matrix[row][col] + " ");
                        }
                        writer.println();
                    }
                    break;
                }
            }

            if (!found) {
                writer.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        writer.flush();
        writer.close();
    }

    static int[] getRandomPermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < n - 1; i++) {
            int idx = rand.nextInt(n - i) + i;
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scanner = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            writer = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            writer = new PrintWriter(System.out, true);
        }
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
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