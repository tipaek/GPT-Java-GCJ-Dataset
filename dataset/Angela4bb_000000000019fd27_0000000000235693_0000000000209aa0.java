import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Indicium solver = new Indicium();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        // t is number of testcases
        for(int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt();
            int[][] res = new int[n][n];
            boolean valid = helper(res, 0, k, n);
            if (!valid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: POSSIBLE\n", testNumber);
                printArray(res, out);
            }
        }

        void printArray(int[][] arr, PrintWriter out) {
            for(int[] a : arr) {
                for(int n : a) {
                    out.printf("%d ", n);
                }
                out.print("\n");
            }
        }

        boolean helper(int[][] arr, int i, int total, int n) {
            if (total == 0 && i == n) {
                return isValid(arr, n);
            }

            if (total == 0 || i == n) return false;

            for (int num = 1; num <= n; num++) {
                arr[i][i] = num;
                if (helper(arr, i + 1, total - num, n)) {
                    return true;
                }
            }
            return false;
        }

        boolean isValid(int[][] arr, int n) {
            boolean[][] row = new boolean[n][n], col = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                row[i][arr[i][i] - 1] = true;
                col[i][arr[i][i] - 1] = true;
            }

            return fillAndCheck(arr, 0, 0, row, col);
        }

        boolean fillAndCheck(int[][] arr, int i, int j, boolean[][] row, boolean[][] col) {
            if (i == j) j++;
            if (j == arr.length) {
                i++;
                j = 0;
            }
            if (i == arr.length) return true;
            for(int num = 1; num <= arr.length; num++) {
                if (row[i][num - 1] == false && col[j][num - 1] == false) {
                    row[i][num - 1] = true;
                    col[j][num - 1] = true;
                    arr[i][j] = num;
                    if (fillAndCheck(arr, i, j + 1, row, col)) return true;
                    row[i][num - 1] = false;
                    col[j][num - 1] = false;
                }
            }
            return false;
        }
    }

    static class Schedule {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] intervals = readIntArrays(in, n);
            Arrays.sort(intervals, (a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            });
            char[] res = new char[n];
            Arrays.fill(res, 'C');

            int c = intervals[0][1], j = -1;
            boolean valid = true;
            for(int i = 1; i < intervals.length; i++){
                if(c > intervals[i][0]){
                    // c is busy try assign to j
                    if (j <= intervals[i][0]) {
                        j = intervals[i][1];
                        res[intervals[i][2]] = 'J';
                    } else {
                        valid = false;
                        break;
                    }
                } else{
                    c = intervals[i][1];
                }
            }

            if (!valid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: %s\n", testNumber, String.valueOf(res));
            }


        }

        int[][] readIntArrays(InputReader in, int n) {
            int[][] arr = new int[n][3];
            for(int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = i;
            }
            return arr;
        }
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for(char c : s.toCharArray()) {
                int num = c - '0';
                while(num < cur) {
                    sb.append(")");
                    cur--;
                }
                while(num > cur) {
                    sb.append("(");
                    cur++;
                }
                sb.append(c);
            }
            while(cur > 0) {
                sb.append(")");
                cur--;
            }
            out.printf("Case #%d: %s\n", testNumber, sb.toString());
        }
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] arr = readIntArrays(in, n);
            boolean[][] row = new boolean[n][n+1], col = new boolean[n][n+1];
            int k = 0, r = 0, c = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    if (i == j) k += arr[i][j];
                    int cur = arr[i][j];
                    if (row[i][cur] && !row[i][0]) {
                        r++;
                        row[i][0] = true;
                    }
                    if (col[j][cur] && !col[j][0]) {
                        c++;
                        col[j][0] = true;
                    }
                    row[i][cur] = true;
                    col[j][cur] = true;
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, k, r, c);
        }

        int[][] readIntArrays(InputReader in, int n) {
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.readArray(n);
            }
            return arr;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readArray(int n) {
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

    }
}
