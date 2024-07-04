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
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++)
        {
            String str = keyboard.nextLine();
            int init_value = 0;
            System.out.print("Case #"+(i + 1)+": ");
            for (int j = 0; j < str.length(); j++)
            {
                int val = (char)str.charAt(j) - 48;
                if (val > init_value)
                {
                    for (int k = 0; k < val - init_value; k++)
                        System.out.print("(");
                }
                else if (val < init_value)
                {
                    for (int k = 0; k < init_value - val; k++)
                        System.out.print(")");
                }
                init_value = val;
                System.out.print(val);
            }
            for (int j = 0; j < init_value; j++)
                System.out.print(")");
            System.out.println();
        }
    }
}
