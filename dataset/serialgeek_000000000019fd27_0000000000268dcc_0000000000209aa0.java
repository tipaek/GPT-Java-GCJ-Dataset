import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static class Operation {
        public void solve(Scanner scan) throws IOException {
            int T = scan.nextInt(), t = 0;
            while (T-- > 0) {
                t++;
                int N = scan.nextInt();
                int K = scan.nextInt();
                int[][] arr = new int[N][N];
                createInitialLatinMatrix(arr, N);
                System.out.println("Case #" + t + ": " + getLatinMatrixWithTrace(arr, N, K));
                if (arr[0][0] != -1) {
                    displayArr(arr);
                }
            }
        }

        public int trace(int[][] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][i];
            }
            return sum;
        }

        private String getLatinMatrixWithTrace(int[][] arr, int N, int K) {
            if (trace(arr) == K)
                return "POSSIBLE";
            // row swaps
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j)
                        continue;
                    swapRow(arr, i, j);
                    if (trace(arr) == K)
                        return "POSSIBLE";
                    else {
                        swapRow(arr, i, j);
                    }
                }
            }
            // col swaps
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j)
                        continue;
                    swapCol(arr, i, j);
                    if (trace(arr) == K)
                        return "POSSIBLE";
                    else {
                        swapCol(arr, i, j);
                    }
                }
            }
            arr[0][0] = -1;
            return "IMPOSSIBLE";
        }

        private void swapRow(int[][] arr, int ii, int jj) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[ii][i];
                arr[ii][i] = arr[jj][i];
                arr[jj][i] = temp;
            }

        }

        private void swapCol(int[][] arr, int ii, int jj) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i][ii];
                arr[i][ii] = arr[i][jj];
                arr[i][jj] = temp;
            }

        }

        private void createInitialLatinMatrix(int[][] arr, int N) {
            int start = 0, counter;
            for (int i = 0; i < N; i++) {
                counter = 1;
                while (start < N) {
                    arr[i][start++] = counter++;
                }
                for (int j = 0; arr[i][j] == 0 && j < N; j++) {
                    arr[i][j] = counter++;
                }
                start = i + 1;
            }
        }

        public void displayArr(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Operation obj = new Operation();
        obj.solve(scan);
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}