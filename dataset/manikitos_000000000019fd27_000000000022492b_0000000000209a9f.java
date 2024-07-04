import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            char startChar = s.charAt(0);
            int initDepth = (int) startChar - 48;
            addBraces(sb, initDepth, '(');
            sb.append(startChar);
            if (s.length() == 1) {
                addBraces(sb, initDepth, ')');
                System.out.println("Case #" + i + ": " + sb.toString());
                continue;
            }

            for (int j = 1; j < s.length(); j++) {
                char curChar = s.charAt(j);
                char prevChar = s.charAt(j - 1);
                if (prevChar != curChar) {
                    char brace = prevChar < curChar ? '(' : ')';
                    addBraces(sb, Math.abs(prevChar - curChar), brace);
                }
                sb.append(curChar);
            }

            addBraces(sb, (int) s.charAt(s.length() - 1) - 48, ')');

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    private static void addBraces(StringBuilder sb, int number, char brace) {
        for (int j = 0; j < number; j++) {
            sb.append(brace);
        }
    }
}