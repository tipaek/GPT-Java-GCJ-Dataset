import java.util.Scanner;

class Solution {
    public static Scanner sc = new Scanner(System.in);

    public static String man(String s) {
        if (s.length() == 1) {
            return s.equals("1") ? "(1)" : "0";
        }

        StringBuilder result = new StringBuilder();
        if (s.charAt(0) == '1') {
            result.append(s.charAt(1) == '1' ? "(1" : "(1)");
        } else {
            result.append(s.charAt(1) == '1' ? "0(" : "0");
        }

        for (int i = 1; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (current == '1') {
                result.append(next == '0' ? "1)" : "1");
            } else {
                result.append(next == '1' ? "0(" : "0");
            }
        }

        result.append(s.charAt(s.length() - 1) == '1' ? "1)" : "0");
        return result.toString();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String a = sc.next();
            String result = man(a);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}