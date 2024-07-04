import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            char[] characters = input.toCharArray();
            boolean openParenthesis = false;

            for (char character : characters) {
                if (character == '1') {
                    if (!openParenthesis) {
                        result.append('(');
                        openParenthesis = true;
                    }
                } else {
                    if (openParenthesis) {
                        result.append(')');
                        openParenthesis = false;
                    }
                }
                result.append(character);
            }

            if (openParenthesis) {
                result.append(')');
            }

            results[caseNumber - 1] = "Case #" + caseNumber + ": " + result;
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}