import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class test implements Comparable <test> {
        String val; int length;
        public test (String val) {
            this.val = val;
            length = val.length();
        }

        @Override
        public int compareTo(test o) {
            return this.length - o.length;
        }
    }

    public static void main(String[] args) {

        FastReader read = new FastReader ();
        
        int cases = read.nextInt();
        for(int c = 0; c < cases; c++) {


            int N = read.nextInt();
            test [] input = new test [N];
            for(int i = 0; i < N; i++) input[i] = new test(read.nextLine().substring(1));

            Arrays.sort(input);
            boolean possible = true;

            //for(int i = 0; i < N; i++) System.out.println(input[i].val);

            for(int i = 0; i < N - 1; i++) {
                if(!input[N - 1].val.endsWith(input[i].val)) {
                    possible = false;
                    break;
                }
            }

            if(possible) System.out.println("Case #" + (c + 1) + ": " + input[N - 1].val);
            else System.out.println("Case #" + (c + 1) + ": *");
            
            


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