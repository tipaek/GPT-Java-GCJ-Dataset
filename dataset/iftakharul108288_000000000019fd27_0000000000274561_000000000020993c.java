import java.io.*;
import java.util.*;

public class Solution {

    public Solution() { }

    public static class FastScanner {

        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        public int nextInt() { return Integer.parseInt(next()); }

        public long nextLong() { return Long.parseLong(next()); }

        public double nextDouble() { return Double.parseDouble(next()); }

    }

    public static class FastWriter {

        private final BufferedWriter bw;

        public FastWriter() { this.bw = new BufferedWriter(new OutputStreamWriter(System.out)); }

        public void print(Object obj) throws IOException { bw.append("" + obj); }

        public void println(Object obj) throws IOException {
            print(obj);
            bw.append("\n");
        }

        public void close() throws IOException { bw.close(); }

    }

    // check if all array elements are distinct
    public static boolean areDistinct(Integer[] arr) {
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        return (arr.length == set.size());
    }

    public static void main(String[] args) throws IOException {

        FastScanner sc = new FastScanner();
        FastWriter out = new FastWriter();

        // number of test cases
        Integer t = sc.nextInt();
        for (Integer x = 1; x <= t; x++) {
            // size of the matrix
            Integer n = sc.nextInt();
            // two dimensional array for the matrix
            Integer[][] mat = new Integer[n][n];
            // elements of the matrix
            for (Integer cl = 0; cl < n; cl++) {
                for (Integer rw = 0; rw < n; rw++) {
                    mat[cl][rw] = sc.nextInt();
                }
            }
            // trace of the matrix
            Integer k = 0;
            for (Integer y = 0; y < n; y++) {
                k += mat[y][y];
            }
            // rows containing repeated elements
            Integer r = 0;
            for (Integer cl = 0; cl < n; cl++) {
                Integer[] temp = new Integer[n];
                for (Integer rw = 0; rw < n; rw++) {
                    temp[rw] = mat[cl][rw];
                }
                if (!areDistinct(temp)) {
                    r++;
                }
            }
            // columns containing repeated elements
            Integer c = 0;
            for (Integer cl = 0; cl < n; cl++) {
                Integer[] temp = new Integer[n];
                for (Integer rw = 0; rw < n; rw++) {
                    temp[rw] = mat[rw][cl];
                }
                if (!areDistinct(temp)) {
                    c++;
                }
            }
            // display output
            out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }

        out.close();

    }

}
