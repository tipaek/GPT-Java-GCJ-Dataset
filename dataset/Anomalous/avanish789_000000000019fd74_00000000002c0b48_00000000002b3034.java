import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = solve(sc.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int N) {
        String[] arr = new String[N];
        int maxLength = 0;
        int maxIndex = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            if (i >= 1 && maxLength < arr[i].length()) {
                maxLength = arr[i].length();
                maxIndex = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = arr[i].substring(1);
            if (isValid && !arr[maxIndex].contains(substring)) {
                isValid = false;
                break;
            }
        }

        return isValid ? arr[maxIndex].substring(1) : "*";
    }

    private static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
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