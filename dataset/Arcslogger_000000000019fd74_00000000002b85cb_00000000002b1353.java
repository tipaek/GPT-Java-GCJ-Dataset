import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader read = new FastReader ();
        
        int T = read.nextInt();
        for (int t = 0; t < T; t++) {

            int N = read.nextInt();
            System.out.println("Case #" + (t + 1) + ":");

            if(N == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                for(int i = 3; i <= 497; i++) System.out.println(i + " " + i);
            } else {
                for(int i = 1; i <= N; i++) {
                    System.out.println(i + " " + i);
                }
            }        
        }
        

    }

    public static class FastReader {
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
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}