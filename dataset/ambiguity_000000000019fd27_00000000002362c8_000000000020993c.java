

import java.util.*;
import java.io.*;

class Sol {

    public int[] solve(int mat[][], int n) {
        int rows = n;
        int cols = n;
        int res[] = new int[3];
        for (int i=0;i<rows;i++) {
            res[0] += mat[i][i];
        }
        for (int i=0;i<rows;i++) {
            Set<Integer> st = new HashSet<>();
            for (int j=0;j<cols;j++) {
                if (st.contains(mat[i][j])) {
                    res[1]++;
                    break;
                }
                st.add(mat[i][j]);
            }
        }
        for (int j=0;j<cols;j++) {
            Set<Integer> st = new HashSet<>();
            for (int i=0;i<rows;i++) {
                if (st.contains(mat[i][j])) {
                    res[2]++;
                    break;
                }
                st.add(mat[i][j]);
            }
        }
        return res;
    }

}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tt = in.nextInt();
        Sol s = new Sol();
        while (tt > 0) {

            int n = in.nextInt();
            int mat[][] = new int[n][n];
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            int[] res = s.solve(mat, n);
            out.println(res[0] + " " + res[1] + " " + res[2]);
            tt--;
        }
        out.close();
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

    }

}
