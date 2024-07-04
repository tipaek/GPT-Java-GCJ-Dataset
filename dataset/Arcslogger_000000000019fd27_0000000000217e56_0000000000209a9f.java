import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader read = new FastReader ();
        
        int T = read.nextInt();
        for(int t = 0; t < T; t++) {

            String s = read.nextLine(), nest = s;

            System.out.print("Case #" + (t + 1) + ": ");
            int currDepth = 0;
            for(int i = 0; i < s.length(); i++) {

                int val = s.charAt(i) - '0';
                while(val > currDepth) {
                    System.out.print("(");
                    currDepth++;
                }   
                while(val < currDepth) {
                    System.out.print(")");
                    currDepth--;
                }
                System.out.print(val);
            }

            while(currDepth > 0) {
                System.out.print(")");
                currDepth--;
            }   
            while(currDepth < 0) {
                System.out.print("(");
                currDepth++;
            }
               
            System.out.println();

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