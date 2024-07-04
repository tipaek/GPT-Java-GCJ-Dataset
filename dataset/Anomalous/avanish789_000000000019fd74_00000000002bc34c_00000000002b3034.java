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
            String result = findPattern(N);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findPattern(int N) {
        String[] strings = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isPatternFound = true;

        for (int i = 0; i < N; i++) {
            strings[i] = sc.nextLine();
            if (i >= 1 && maxLength < strings[i].length()) {
                maxLength = strings[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = strings[i].substring(1);
            if (isPatternFound && !strings[maxPos].contains(substring)) {
                isPatternFound = false;
                break;
            }
        }

        if (isPatternFound) {
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