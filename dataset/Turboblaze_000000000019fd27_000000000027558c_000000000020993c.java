import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i=0; i<n; i++) {
                trace += mat[i][i];
            }
            boolean[] elts;
            int countRows = 0;
            for (int i=0; i<n; i++) {
                elts = new boolean[n];
                for (int j=0; j<n; j++) {
                    if (elts[mat[i][j]-1]) {
                        countRows++;
                        break;
                    } else {
                        elts[mat[i][j]-1] = true;
                    }
                }
            }
            int countCols = 0;
            for (int i=0; i<n; i++) {
                elts = new boolean[n];
                for (int j=0; j<n; j++) {
                    if (elts[mat[j][i]-1]) {
                        countCols++;
                        break;
                    } else {
                        elts[mat[j][i]-1] = true;
                    }
                }
            }
            pw.println("Case #" + t + ": " + trace + " " + countRows + " " + countCols);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
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
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
