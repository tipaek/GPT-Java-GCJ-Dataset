import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        Scanner input = new Scanner(System.in);
        int caseNum = fastReader.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            String str = fastReader.next();
            System.out.println(String.format("Case #%d: %s", ks, solve(str)));
        }
    }

    public static String solve(String str) {
        StringBuilder sb = new StringBuilder();
        int firstNum = Character.getNumericValue(str.charAt(0));
        sb.append(generateParentheses(firstNum, firstNum));

        for (int i = 1; i < str.length(); i++) {
            int index = sb.length();
            int count = 0;
            int num = Character.getNumericValue(str.charAt(i));

            for (int j = sb.length() - 1; j >= 0; j--) {
                char ch = sb.charAt(j);

                if (ch != ')') {
                    break;
                }
                if (ch == '0') {
                    sb.append(0);
                    break;
                }
                if (count == num) {
                    break;
                }

                index--;
                count++;
            }

            if (count == 0) {
                sb.append(generateParentheses(num, num));
            } else if (count == num) {
                sb.insert(index, Integer.toString(num));
            } else {
                sb.insert(index, generateParentheses(num, count));
            }
        }

        return sb.toString();
    }

    public static String generateParentheses(int num, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("(");
        }
        sb.append(num);
        for (int i = 0; i < len; i++) {
            sb.append(")");
        }
        return sb.toString();
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