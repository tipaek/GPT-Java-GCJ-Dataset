import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            char previousChar = '0';

            for (char currentChar : input.toCharArray()) {
                if (currentChar == previousChar) {
                    result.append(currentChar);
                } else if (currentChar > previousChar) {
                    while (currentChar > previousChar) {
                        result.append('(');
                        previousChar++;
                    }
                    result.append(currentChar);
                } else {
                    while (currentChar < previousChar) {
                        result.append(')');
                        previousChar--;
                    }
                    result.append(currentChar);
                }
            }

            while ('0' < previousChar) {
                result.append(')');
                previousChar--;
            }

            System.out.println("Case #" + caseNumber++ + ": " + result);
        }

        scanner.close();
    }
}