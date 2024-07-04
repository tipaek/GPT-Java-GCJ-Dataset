import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String result = solve(sc.nextInt());
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static String solve(int n) {
        String[] strings = new String[n];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
            if (i >= 1 && strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < n; i++) {
            String substring = strings[i].substring(1);
            if (isValid && !strings[maxPos].contains(substring)) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return strings[maxPos].substring(1);
        }
        return "*";
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