import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static class Operation {
        public int repeatedElemColCount(int[][] arr) {
            int sum = 0, N = arr.length;
            List<Integer> intList;
            for (int i = 0; i < N; i++) {
                intList = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    if (!intList.contains(arr[j][i])) {
                        intList.add(arr[j][i]);
                    } else {
                        sum++;
                        break;
                    }
                }
            }
            return sum;
        }

        public int repeatedElemRowCount(int[][] arr) {
            int sum = 0, N = arr.length;
            List<Integer> intList;
            for (int i = 0; i < N; i++) {
                intList = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    if (!intList.contains(arr[i][j])) {
                        intList.add(arr[i][j]);
                    } else {
                        sum++;
                        break;
                    }
                }
            }
            return sum;
        }

        public int trace(int[][] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][i];
            }
            return sum;
        }

        public void solve(Scanner scan) throws IOException {
            int T = scan.nextInt(), t = 0;
            while (T-- > 0) {
                t++;
                int N = scan.nextInt();
                int[][] arr = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = scan.nextInt();
                    }
                }
                System.out.println("Case #" + t + ": " + trace(arr) + " " + repeatedElemRowCount(arr) + " "
                        + repeatedElemColCount(arr));
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
