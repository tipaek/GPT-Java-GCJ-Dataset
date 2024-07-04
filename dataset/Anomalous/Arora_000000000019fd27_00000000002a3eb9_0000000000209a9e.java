import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        if (b == 1) {
            for (int p1 = 0; p1 < t; p1++) {
                char[] ch = new char[10];
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    ch[i - 1] = scanner.next().charAt(0);
                }
                String ans = new String(ch);
                System.out.println(ans);
                char ch1 = scanner.next().charAt(0);
                if (ch1 == 'N') {
                    return;
                }
            }
        }
    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}