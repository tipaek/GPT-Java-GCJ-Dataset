import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = findSolution(sc.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findSolution(int N) {
        String[] array = new String[N];
        int maxLength = 0;
        int maxPosition = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextLine();
            if (i >= 1 && maxLength < array[i].length()) {
                maxLength = array[i].length();
                maxPosition = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String substring = array[i].substring(1);
            if (isValid && !array[maxPosition].contains(substring)) {
                isValid = false;
                break;
            }
        }

        return isValid ? array[maxPosition].substring(1) : "*";
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