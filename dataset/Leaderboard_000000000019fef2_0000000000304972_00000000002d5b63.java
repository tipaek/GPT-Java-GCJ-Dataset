import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class blindfoldedbullseye {
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
        int a, b;
        a = keyboard.nextInt();
        b = keyboard.nextInt();
        for (int i = 0; i < T; i++) {

            int fl = 0;
            for (int j = -10; j <= 10; j++)
            {
                if (fl != 0)
                    break;
                for (int k = -8; k <= 8; k++)
                {
                    System.out.println (j + " " + k);
                    String str = keyboard.nextLine();
                    if (str.equals("CENTER") || str.equals("WRONG"))
                    {
                     fl++;
                     break;
                    }
                }
            }
        }
    }
}
