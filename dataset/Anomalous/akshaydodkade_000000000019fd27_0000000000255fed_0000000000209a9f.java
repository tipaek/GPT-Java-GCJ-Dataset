import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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

    private String digitString;
    private String resultString;

    private String getParaString(String digit) {
        int num = Integer.parseInt(digit);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append("(");
        }
        result.append(digit);
        for (int i = 0; i < num; i++) {
            result.append(")");
        }
        return result.toString();
    }

    private void calSolution() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digitString.length(); i++) {
            result.append(getParaString(digitString.substring(i, i + 1)));
        }

        for (int i = 2; i < result.length() - 2; i++) {
            if (result.charAt(i) == ')' && result.charAt(i + 1) == '(') {
                result.delete(i, i + 2);
                int key = i, counter = 0;
                while (result.charAt(key) == '(') {
                    counter++;
                    key++;
                }
                i = i - counter - 1;
            }
        }
        resultString = result.toString();
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.digitString = sc.next();
            obj.calSolution();
            System.out.println("Case #" + t + ": " + obj.resultString);
        }
    }
}