import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            String result = solve(n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int N) {
        String[] arr = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            if (i > 0 && arr[i].length() > maxLength) {
                maxLength = arr[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == maxPos) continue;
            String sub = arr[i].substring(1);
            if (!arr[maxPos].contains(sub)) {
                isValid = false;
                break;
            }
        }

        return isValid ? arr[maxPos].substring(1) : "*";
    }

    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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