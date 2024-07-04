import java.util.Scanner;

public class Solution {
    private int t;
    private String inputString, outputString;
    private final char openingBracket = '(';
    private final char closingBracket = ')';

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    private void takeInputAndSolve() {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        for (int a = 0; a < t; a++) {
            inputString = scanner.next();
            outputString = "";

            if (inputString.length() == 1) {
                handleSingleCharacter();
            } else {
                handleMultipleCharacters();
            }

            System.out.println(outputString);
        }
    }

    private void handleSingleCharacter() {
        int num = Character.getNumericValue(inputString.charAt(0));
        outputString = repeatChar(openingBracket, num) + num + repeatChar(closingBracket, num);
    }

    private void handleMultipleCharacters() {
        for (int b = 0; b < inputString.length(); b++) {
            int num = Character.getNumericValue(inputString.charAt(b));

            if (b == 0) {
                handleFirstCharacter(num, Character.getNumericValue(inputString.charAt(b + 1)));
            } else if (b == inputString.length() - 1) {
                handleLastCharacter(num);
            } else {
                handleMiddleCharacter(b, num);
            }
        }
    }

    private void handleFirstCharacter(int num, int nextNum) {
        outputString += repeatChar(openingBracket, num) + num;
        outputString += handleBracketDifference(num, nextNum);
    }

    private void handleLastCharacter(int num) {
        outputString += num + repeatChar(closingBracket, num);
    }

    private void handleMiddleCharacter(int b, int num) {
        int nextNum = Character.getNumericValue(inputString.charAt(b + 1));
        outputString += num + handleBracketDifference(num, nextNum);
    }

    private String handleBracketDifference(int num, int nextNum) {
        int diff = num - nextNum;
        return repeatChar(diff < 0 ? openingBracket : closingBracket, Math.abs(diff));
    }

    private String repeatChar(char ch, int count) {
        StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }
}