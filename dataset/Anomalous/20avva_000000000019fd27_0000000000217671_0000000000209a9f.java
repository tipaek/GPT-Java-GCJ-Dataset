import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            StringBuilder inputString = new StringBuilder(scanner.next());
            int currentDepth = 0;

            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);

                if (Character.isDigit(currentChar)) {
                    int currentValue = Character.getNumericValue(currentChar);

                    while (currentDepth < currentValue) {
                        inputString.insert(i, '(');
                        currentDepth++;
                        i++;
                    }

                    while (currentDepth > currentValue) {
                        inputString.insert(i, ')');
                        currentDepth--;
                        i++;
                    }
                }
            }

            while (currentDepth > 0) {
                inputString.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNum + ": " + inputString);
        }
    }
}