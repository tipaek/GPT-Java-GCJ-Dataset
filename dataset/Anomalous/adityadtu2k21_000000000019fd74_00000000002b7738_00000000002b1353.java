import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        
        int tc = scn.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = scn.nextInt();
            System.out.println("Case #" + t + ": ");
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
        }
    }

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
}