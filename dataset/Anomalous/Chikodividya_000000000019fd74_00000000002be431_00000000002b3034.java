import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = sc.nextInt();
            String result = findLongestCommonSuffix(N);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findLongestCommonSuffix(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isCommonSuffix = true;

        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            if (i > 0 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String suffix = strings[i].substring(1);
            if (isCommonSuffix && !strings[maxPos].contains(suffix)) {
                isCommonSuffix = false;
                break;
            }
        }

        return isCommonSuffix ? strings[maxPos].substring(1) : "*";
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