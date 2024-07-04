import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            String result = findLongestCommonSuffix(n);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String findLongestCommonSuffix(int n) {
        String[] strings = new String[n];
        int maxLength = 0;
        int maxIndex = -1;
        boolean isCommonSuffix = true;

        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
            if (i > 0 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            String suffix = strings[i].substring(1);
            if (isCommonSuffix && !strings[maxIndex].contains(suffix)) {
                isCommonSuffix = false;
                break;
            }
        }

        return isCommonSuffix ? strings[maxIndex].substring(1) : "*";
    }

    private static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}