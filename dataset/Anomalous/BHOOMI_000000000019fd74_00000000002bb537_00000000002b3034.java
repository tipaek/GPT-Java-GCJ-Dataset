import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String result = solve(sc.nextInt());
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String solve(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            if (i >= 1 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != maxPos) {
                String substring = strings[i].substring(1);
                if (!strings[maxPos].contains(substring)) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid ? strings[maxPos].substring(1) : "*";
    }

    private static class FastReader {
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