import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        
        try {
            for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
                String inputString = scanner.nextLine();
                System.out.println("Case #" + caseNumber + ": " + processString(inputString));
            }
        } catch (NegativeArraySizeException exception) {
            System.out.println("Exception: " + exception);
        }
    }

    public static String processString(String input) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean isParenthesisOpen = false;

        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i] + " ");

            if (characters[i] == '1') {
                if (i < characters.length - 1) {
                    if (!isParenthesisOpen) {
                        if (characters[i + 1] == '1') {
                            result.append("(1");
                            isParenthesisOpen = true;
                        } else if (characters[i + 1] == '0') {
                            result.append("(1)");
                        }
                    } else if (characters[i + 1] == '1') {
                        result.append("1");
                    } else if (characters[i + 1] == '0') {
                        result.append("1)");
                        isParenthesisOpen = false;
                    }
                } else {
                    if (!isParenthesisOpen) {
                        result.append("(1)");
                    } else {
                        result.append("1)");
                        isParenthesisOpen = false;
                    }
                }
            } else if (characters[i] == '0') {
                result.append("0");
            }
        }

        return result.toString();
    }
}