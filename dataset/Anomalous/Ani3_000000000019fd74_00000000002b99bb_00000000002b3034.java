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
            String result = solve(N);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String solve(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPosition = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            if (i >= 1 && maxLength < strings[i].length()) {
                maxLength = strings[i].length();
                maxPosition = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = strings[i].substring(1);
            if (isValid && !strings[maxPosition].contains(substring)) {
                isValid = false;
                break;
            }
        }

        return isValid ? strings[maxPosition].substring(1) : "*";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
}