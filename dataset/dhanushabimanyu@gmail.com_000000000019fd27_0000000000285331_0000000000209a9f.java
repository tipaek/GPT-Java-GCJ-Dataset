import java.util.Scanner;

public class Solution {

    static int countopen(StringBuilder sb) {
        int count = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == '(') {
                count++;
            }
        }
        return count;
    }

    static int countclose(StringBuilder sb) {
        int count = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == ')') {
                count++;
            }
        }
        return count;
    }

    static String addopen(int t) {
        String result = "";
        for (int i = 0; i < t; i++) {
            result += "(";
        }
        return result;
    }

    static String addclose(int t) {
        String result = "";
        for (int i = 0; i < t; i++) {
            result += ")";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[][] arr;
        for (int i = 0; i < t; i++) {
            String str = s.next();
            int len = str.length();
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < len; j++) {
                int n = Character.getNumericValue(str.charAt(j));
                int open = countopen(sb);
                int close = countclose(sb);
                if (n == 0) {
                    sb.append(addclose(open - close));
                    sb.append(0);
                } else if (open == close) {
                    sb.append(addopen(n));
                    sb.append(n);
                } else if (open - close == n) {
                    sb.append(n);
                } else if (open - close < n) {
                    sb.append(addopen(n - open + close));
                    //sb.append(addclose(open - close));
                    //sb.append(addopen(n));
                    sb.append(n);
                } else if (open - close > n) {
                    sb.append(addclose(open - close - n));
                    sb.append(n);
                }
                open = countopen(sb);
                close = countclose(sb);
                if (j == len - 1) {
                    sb.append(addclose(open - close));
                }
            }
                System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }

}
