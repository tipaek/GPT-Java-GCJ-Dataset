import java.util.Scanner;

public class Q2 {
    public static String transformString(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '1' ? "(1)" : "0";
        }

        StringBuilder result = new StringBuilder();
        if (s.charAt(0) == '1') {
            result.append(s.charAt(1) == '1' ? "(1" : "(1)");
        } else {
            result.append(s.charAt(1) == '1' ? "0(" : "0");
        }

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                result.append(s.charAt(i + 1) == '0' ? "1)" : "1");
            } else if (s.charAt(i) == '0') {
                result.append(s.charAt(i + 1) == '1' ? "0(" : "0");
            }
        }

        if (s.charAt(s.length() - 1) == '1') {
            result.append("1)");
        } else {
            result.append("0");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String input = sc.next();
            String transformed = transformString(input);
            System.out.println("Case #" + i + ": " + transformed);
        }
        sc.close();
    }
}