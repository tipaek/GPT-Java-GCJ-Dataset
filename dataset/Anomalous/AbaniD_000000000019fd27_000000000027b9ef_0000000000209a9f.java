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

                if (openParenthesis) {
                    while (i < input.length() && input.charAt(i) == currentChar) {
                        result.append(currentChar);
                        i++;
                    }
                    result.append(")");
                    openParenthesis = false;
                }

                if (i < input.length()) {
                    currentChar = input.charAt(i);
                    if (currentChar != '0') {
                        result.append("(").append(currentChar);
                        openParenthesis = true;
                    } else {
                        result.append(currentChar);
                    }
                }
            }

            if (openParenthesis) {
                result.append(")");
            }

            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}