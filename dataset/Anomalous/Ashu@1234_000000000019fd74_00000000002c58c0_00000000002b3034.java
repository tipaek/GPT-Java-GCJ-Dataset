import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String result = processCase(sc.nextInt());
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    static String processCase(int N) {
        String[] inputs = new String[N];
        int maxLength = 0;
        int maxIndex = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextLine();
            if (i >= 1 && maxLength < inputs[i].length()) {
                maxLength = inputs[i].length();
                maxIndex = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = inputs[i].substring(1);
            if (isValid && !inputs[maxIndex].contains(substring)) {
                isValid = false;
                break;
            }
        }

        return isValid ? inputs[maxIndex].substring(1) : "*";
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