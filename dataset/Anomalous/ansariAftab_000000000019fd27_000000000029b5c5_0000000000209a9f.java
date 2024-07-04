import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            boolean openParenthesis = false;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '0') {
                    if (openParenthesis) {
                        result.append(')');
                        openParenthesis = false;
                    }
                    result.append('0');
                } else if (currentChar == '1') {
                    if (!openParenthesis) {
                        result.append('(');
                        openParenthesis = true;
                    }
                    result.append('1');
                }
            }

            if (openParenthesis) {
                result.append(')');
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}