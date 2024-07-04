import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            for (int i = 0; i < T; i++) {
                String input = scanner.nextLine();
                System.out.println("Case #" + (i + 1) + ": " + processLine(input));
            }
        }
    }

    private static String processLine(String input) {
        StringBuilder sb = new StringBuilder();
        int openBraces = 0;
        for (char c : input.toCharArray()) {
            int num = Character.getNumericValue(c);
            if (openBraces < num) {
                appendBraces(sb, num - openBraces, '(');
                openBraces = num;
            } else if (openBraces > num) {
                appendBraces(sb, openBraces - num, ')');
                openBraces = num;
            }
            sb.append(num);
        }
        appendBraces(sb, openBraces, ')');
        return sb.toString();
    }

    private static void appendBraces(StringBuilder sb, int count, char brace) {
        for (int i = 0; i < count; i++) {
            sb.append(brace);
        }
    }
}