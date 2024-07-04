import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.nextLine();
            System.out.print("Case #" + testCase + ": ");
            System.out.println(calculateNestingDepth(inputString.trim()));
        }
    }

    static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = Character.getNumericValue(input.charAt(0));

        for (int i = 0; i < currentDepth; i++) {
            result.append("(");
        }
        result.append(input.charAt(0));

        int remainingDepth = currentDepth;

        for (int i = 1; i < input.length(); i++) {
            int currentNumber = Character.getNumericValue(input.charAt(i));

            if (currentNumber == currentDepth) {
                result.append(currentNumber);
            } else if (currentNumber == 0) {
                for (int j = 0; j < remainingDepth; j++) {
                    result.append(")");
                }
                result.append(currentNumber);
                remainingDepth = 0;
            } else {
                if (remainingDepth == 0) {
                    for (int j = 0; j < currentNumber; j++) {
                        result.append("(");
                    }
                    result.append(currentNumber);
                    remainingDepth = currentNumber;
                } else if (remainingDepth > 0) {
                    remainingDepth -= currentNumber;
                    if (remainingDepth > 0) {
                        for (int j = 0; j < remainingDepth; j++) {
                            result.append(")");
                        }
                    } else {
                        for (int j = 0; j < Math.abs(remainingDepth); j++) {
                            result.append("(");
                        }
                    }
                    result.append(currentNumber);
                    remainingDepth = currentNumber;
                }
            }
            currentDepth = currentNumber;
        }
        for (int j = 0; j < remainingDepth; j++) {
            result.append(")");
        }

        return result.toString();
    }
}