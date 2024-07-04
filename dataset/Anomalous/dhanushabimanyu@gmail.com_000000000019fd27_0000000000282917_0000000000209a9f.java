import java.util.Scanner;

public class Solution {

    static int countCharOccurrences(StringBuilder sb, char ch) {
        int count = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == ch) {
                count++;
            }
        }
        return count;
    }

    static String repeatChar(int count, char ch) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            String str = s.next();
            int len = str.length();
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < len; j++) {
                int n = Character.getNumericValue(str.charAt(j));
                int open = countCharOccurrences(sb, '(');
                int close = countCharOccurrences(sb, ')');
                int balance = open - close;

                if (n == 0 || j == len - 1) {
                    if (balance == 0) {
                        sb.append(repeatChar(n, '(')).append(n).append(repeatChar(n, ')'));
                    } else {
                        sb.append(repeatChar(balance - n, ')')).append(n).append(repeatChar(n, ')'));
                    }
                } else if (balance == 0) {
                    sb.append(repeatChar(n, '(')).append(n);
                } else if (balance == n) {
                    sb.append(n);
                } else if (balance < n) {
                    sb.append(repeatChar(balance, ')')).append(repeatChar(n, '(')).append(n);
                } else {
                    sb.append(repeatChar(balance - n, ')')).append(n).append(repeatChar(n, ')'));
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
        s.close();
    }
}