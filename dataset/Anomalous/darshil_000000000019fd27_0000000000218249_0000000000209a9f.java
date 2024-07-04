import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;
            int closeBrackets = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));

                if (currentDigit == 0) {
                    int balance = openBrackets - closeBrackets;
                    for (int k = 0; k < balance; k++) {
                        output.append(')');
                        closeBrackets++;
                    }
                    output.append('0');
                } else {
                    int neededOpenBrackets = currentDigit - (openBrackets - closeBrackets);
                    if (neededOpenBrackets >= 0) {
                        for (int k = 0; k < neededOpenBrackets; k++) {
                            output.append('(');
                            openBrackets++;
                        }
                    } else {
                        for (int k = neededOpenBrackets; k < 0; k++) {
                            output.append(')');
                            closeBrackets++;
                        }
                    }
                    output.append(currentDigit);
                }
            }

            int remainingBrackets = openBrackets - closeBrackets;
            for (int j = 0; j < remainingBrackets; j++) {
                output.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}