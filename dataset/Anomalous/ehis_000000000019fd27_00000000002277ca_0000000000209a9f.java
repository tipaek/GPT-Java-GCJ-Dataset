import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        try {
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                String input = scanner.nextLine();
                System.out.println("Case #" + caseNumber + ": " + resolve(input));
            }
        } catch (NegativeArraySizeException e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String resolve(String input) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean isParenthesisOpen = false;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '1') {
                if (!isParenthesisOpen) {
                    result.append('(');
                    isParenthesisOpen = true;
                }
                result.append('1');
                if (i == characters.length - 1 || characters[i + 1] == '0') {
                    result.append(')');
                    isParenthesisOpen = false;
                }
            } else if (characters[i] == '0') {
                if (isParenthesisOpen) {
                    result.append(')');
                    isParenthesisOpen = false;
                }
                result.append('0');
            }
        }

        return result.toString();
    }
}