
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.*;

class Solution {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {

            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {

            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        byte nextByte() {
            return Byte.parseByte(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) throws Exception {

        FastReader s = new FastReader();
        OutputStream out = new BufferedOutputStream(System.out);
        int test = s.nextInt();

        for (int i = 1; i <= test; i++) {

            int n = s.nextInt();
            int mat[][] = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = s.nextInt();
                }
            }
            long trace = 0;
            for (int j = 0; j < n; j++) {
                trace += mat[j][j];
            }
            int row = 0;
            for (int j = 0; j < n; j++) {

                HashSet<Integer> set = new HashSet<Integer>();
                for (int l = n - 1; l >= 0; l--) {
                    if (set.contains(mat[j][l])) {
                        row++;
                        break;
                    } else {
                        set.add(mat[j][l]);
                    }
                }

            }
            int col = 0;
            for (int j = 0; j < n; j++) {

                HashSet<Integer> set = new HashSet<Integer>();
                for (int l = n - 1; l >= 0; l--) {
                    if (set.contains(mat[l][j])) {
                        col++;
                        break;
                    } else {
                        set.add(mat[l][j]);
                    }
                }

            }
            out.write(("Case #" +i+": "+trace+" "+row+" "+col+" "+"\n").getBytes());
            out.flush();

        }
               
    }

}
