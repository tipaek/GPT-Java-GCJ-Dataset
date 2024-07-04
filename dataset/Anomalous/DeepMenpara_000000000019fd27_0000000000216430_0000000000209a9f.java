import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            StringBuilder result = new StringBuilder();
            int parenthesisCount = 0;
            String str = sc.nextLine();
            char[] inpChar = str.toCharArray();

            for (int i = 0; i < inpChar.length; i++) {
                int currentDigit = Character.getNumericValue(inpChar[i]);
                if (i != inpChar.length - 1 && inpChar[i] == inpChar[i + 1]) {
                    continue;
                }

                while (parenthesisCount < currentDigit) {
                    result.append("(");
                    parenthesisCount++;
                }
                while (parenthesisCount > currentDigit) {
                    result.append(")");
                    parenthesisCount--;
                }

                result.append(inpChar[i]);
            }

            while (parenthesisCount > 0) {
                result.append(")");
                parenthesisCount--;
            }

            System.out.println("Case #" + (k + 1) + ": " + result);
        }
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