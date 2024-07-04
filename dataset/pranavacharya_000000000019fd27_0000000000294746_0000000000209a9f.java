import java.util.Scanner;

public class Solution {

    public void setParenthesis(int caseno, String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length();) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
            int j = i;
            while (j < s.length() && digit == (s.charAt(j) - '0')) {
                j++;
            }
            if (balance >= digit) {
                sb.append(s.substring(i, j));
                if (j >= s.length()) {
                    while (balance > 0) {
                        sb.append(')');
                        balance--;
                    }
                } else {
                    int next = s.charAt(j) - '0';
                    if (next < digit) {
                        int close = digit - next;
                        int temp2 = close;
                        while (temp2 > 0) {
                            sb.append(')');
                            temp2--;
                        }
                        balance -= close;
                    }
                }
            } else {
                int temp = digit - balance;
                balance = balance + temp;
                while (temp > 0) {
                    sb.append('(');
                    temp--;
                }
                sb.append(s.substring(i, j));
                if (j >= s.length()) {
                    while (balance > 0) {
                        sb.append(')');
                        balance--;
                    }
                } else {
                    int next = s.charAt(j) - '0';
                    if (next < digit) {
                        int close = digit - next;
                        int temp2 = close;
                        while (temp2 > 0) {
                            sb.append(')');
                            temp2--;
                        }
                        balance -= close;
                    }
                }
            }
            i = j;
        }
        System.out.format("Case #%d: %s", caseno, sb.toString());
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            String s = sc.next();
            v.setParenthesis(t, s);
        }
    }
}
