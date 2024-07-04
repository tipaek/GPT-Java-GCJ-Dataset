import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
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
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int t = s.nextInt();
        int test = 0;
        while(++test <= t) {
            int n = s.nextInt();
            long trace = 0;
            int rowCount = 0;
            int colCount = 0;
            int mat[][] = new int[n][n];
            Set<Integer> dupSet;
            for(int i=0; i<n; i++) {
                dupSet = new HashSet<>();
                for(int j=0 ; j<n; j++) {
                    mat[i][j] = s.nextInt();
                    if(i == j) trace += mat[i][j];
                    dupSet.add(mat[i][j]);
                }
                if(dupSet.size() != n) rowCount += 1;
            }

            for(int i=0; i<n; i++) {
                dupSet = new HashSet<>();
                for(int j=0; j<n; j++) {
                    dupSet.add(mat[j][i]);
                }
                if(dupSet.size() !=n) colCount += 1;
            }

            System.out.println("Case #" + test + ": " + trace + " " + rowCount + " " + colCount);
        }


    }
}