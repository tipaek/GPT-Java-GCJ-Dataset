import java.util.*;
import java.io.*;

class Solution {
    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String temp = "";
            try {
                temp = br.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }
    }

    public static PrintWriter out;

    public static void main(String args[]) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int rowCount = n;
            int colCount = n;
            int finalSum = (n * (n + 1)) / 2;
            int arr[][] = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    arr[r][c] = in.nextInt();
                }
            }
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace = trace + arr[j][j];
            }
            for (int r = 0; r < n; r++) {
                Set<Integer> set = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    set.add(arr[r][c]);
                }
                if (set.size() == n) {
                    rowCount--;
                }
            }
            for (int c = 0; c < n; c++) {
                Set<Integer> set = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    set.add(arr[r][c]);
                }
                if (set.size() == n) {
                    colCount--;
                }
            }
            out.printf("Case #%d: %d %d %d\n", i + 1, trace, rowCount, colCount);
        }
    }
}