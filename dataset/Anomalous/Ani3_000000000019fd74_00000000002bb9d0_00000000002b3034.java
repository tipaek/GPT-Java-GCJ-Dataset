import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = solve(in.nextInt(), in);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String solve(int N, FastReader in) {
        String[] arr = new String[N];
        int maxLength = 0;
        int pos = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextLine();
            if (i >= 1 && maxLength < arr[i].length()) {
                maxLength = arr[i].length();
                pos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String sub = arr[i].substring(1);
            if (isValid && !arr[pos].contains(sub)) {
                isValid = false;
                break;
            }
        }

        return isValid ? arr[pos].substring(1) : "*";
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