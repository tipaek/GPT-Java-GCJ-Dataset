import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
        FastReader keyboard = new FastReader();
        int T, B;
        T = keyboard.nextInt();
        B = keyboard.nextInt();
        for (int i = 0; i < T; i++)
        {
            StringBuilder sb = new StringBuilder(B);
            sb.setLength(B);
            for (int j = 0; j < B; j++)
            {
                // read in from the judge
                System.out.println(j + 1);
                String output = keyboard.next();
                sb.setCharAt(j,output.charAt(0));
            }
            System.out.println(sb.toString());
            String valid = keyboard.next();
            if (valid.equals("N"))
                break;
        }
    }
}
