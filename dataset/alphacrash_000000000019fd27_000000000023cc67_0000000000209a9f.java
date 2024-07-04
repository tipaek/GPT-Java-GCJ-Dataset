import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            String s = sc.next();
            String y = rebalanceString(s);
            System.out.println("Case #" + x + ": " + y);
        }
        sc.close();
    }

    public static String getResult(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            int x = Character.getNumericValue(s.charAt(i));
            // System.out.println("Now: " + x);
            for (int j = 0; j < x; j++) {
                result += "(";
            }
            result += x;
            i++;
            while (i < s.length()) {
                int c = Character.getNumericValue(s.charAt(i));
                // System.out.println("Now, Inner Loop : " + c);
                if (c == x) {
                    result += c;
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            for (int j = 0; j < x; j++) {
                result += ")";
            }
            i++;
        }
        return result;
    }

    public static String rebalanceString(String s) {
        s = getResult(s);
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i == s.length() - 1) {
                result += c;
            } else if (!(c == ')' && s.charAt(i + 1) == '(')) {
                result += c;
            } else {
                i++;
            }
            i++;
        }
        return result;
    }
}