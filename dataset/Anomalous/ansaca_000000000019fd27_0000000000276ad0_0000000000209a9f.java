import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            if (caseNumber == 1) scanner.nextLine();
            String input = scanner.nextLine();
            int currentPointer = 0, depth = 0;
            StringBuilder resultBuilder = new StringBuilder();

            while (currentPointer < input.length()) {
                int currentDigit = Character.getNumericValue(input.charAt(currentPointer));
                if (currentDigit == depth) {
                    resultBuilder.append(input.charAt(currentPointer));
                    currentPointer++;
                } else {
                    if (currentDigit > depth) {
                        resultBuilder.append('(');
                        depth++;
                    } else {
                        resultBuilder.append(')');
                        depth--;
                    }
                }
            }

            while (depth > 0) {
                resultBuilder.append(')');
                depth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        }
    }
}