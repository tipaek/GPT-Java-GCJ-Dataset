
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
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
        FastReader sc = new FastReader();
        /*
          1     ->(1)
          101   ->(1)0(1)
          111000->(111)000
          1111  -> 1111
         */
        int t = sc.nextInt();
        int m=0;
        while (t-->0){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int k = 0, r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                k += arr[j][j];
            }
            for (int j = 0; j < n; j++) {
                Set<Integer> hs = new HashSet<>();
                for (int k1 = 0; k1 < n; k1++) {
                    hs.add(arr[j][k1]);
                }
                if ( hs.size() < n ) {
                    r++;
                }
            }
            for (int j = 0; j < n; j++) {
                Set<Integer> hs = new HashSet<>();
                for (int k1 = 0; k1 < n; k1++) {
                    hs.add(arr[k1][j]);
                }
                if ( hs.size() < n ) {
                    c++;
                }
            }
            m++;
            System.out.println("Case #" + m +": " + k + " " + r + " " + c);
        }
    }
}