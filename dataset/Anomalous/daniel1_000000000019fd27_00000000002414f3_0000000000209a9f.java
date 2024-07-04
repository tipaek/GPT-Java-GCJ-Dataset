import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {

    public static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                if (openParentheses > 0) {
                    result.append(')');
                    openParentheses--;
                }
                result.append('0');
            } else {
                if (openParentheses == 0) {
                    result.append('(');
                    openParentheses++;
                }
                result.append('1');
            }
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            System.out.println("Case #" + t + ": " + solve(input));
        }
    }
}