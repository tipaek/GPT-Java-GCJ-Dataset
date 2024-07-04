import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = sc.nextInt();
            sc.nextLine(); // Consume the newline character after the integer input
            for (int t = 1; t <= testCaseCount; t++) {
                String line = sc.nextLine();
                String result = solve(line);
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    public static String solve(String line) {
        int currentOpenParentheses = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            int digit = Character.getNumericValue(line.charAt(i));
            while (currentOpenParentheses < digit) {
                sb.append("(");
                currentOpenParentheses++;
            }
            while (currentOpenParentheses > digit) {
                sb.append(")");
                currentOpenParentheses--;
            }
            sb.append(digit);
        }

        while (currentOpenParentheses > 0) {
            sb.append(")");
            currentOpenParentheses--;
        }

        return sb.toString();
    }
}