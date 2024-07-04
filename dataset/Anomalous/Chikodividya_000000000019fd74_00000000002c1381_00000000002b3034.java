import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int r = sc.nextInt();
        for (int i = 1; i <= r; i++) {
            String result = processTestCase(sc.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String processTestCase(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            if (i > 0 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != maxPos) {
                String substring = strings[i].substring(1);
                if (isValid && !strings[maxPos].contains(substring)) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid ? strings[maxPos].substring(1) : "*";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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