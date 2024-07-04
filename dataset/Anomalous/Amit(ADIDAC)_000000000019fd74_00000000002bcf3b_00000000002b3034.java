import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastInput input = new FastInput();

    public static void main(String[] args) {
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = findPattern(input.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findPattern(int N) {
        String[] patterns = new String[N];
        int maxLength = 0;
        int maxIndex = -1;
        boolean isValid = true;
        
        for (int i = 0; i < N; i++) {
            patterns[i] = input.nextLine();
            if (i > 0 && patterns[i].length() > maxLength) {
                maxLength = patterns[i].length();
                maxIndex = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String subPattern = patterns[i].substring(1);
            if (isValid && !patterns[maxIndex].contains(subPattern)) {
                isValid = false;
                break;
            }
        }

        return isValid ? patterns[maxIndex].substring(1) : "*";
    }

    static class FastInput {
        BufferedReader br;
        StringTokenizer st;

        public FastInput() {
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