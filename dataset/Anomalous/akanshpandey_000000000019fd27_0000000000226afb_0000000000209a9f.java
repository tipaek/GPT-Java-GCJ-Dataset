import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String numberString = scanner.next();
            char[] numberArray = numberString.toCharArray();
            int length = numberArray.length;
            int[] digitArray = new int[length];

            for (int index = 0; index < length; index++) {
                digitArray[index] = Character.getNumericValue(numberArray[index]);
            }

            System.out.print("Case #" + caseNumber + ": ");
            int openBrackets = 0;

            for (int j = 0; j < length; j++) {
                int currentDigit = digitArray[j];
                int difference = currentDigit - openBrackets;

                if (difference > 0) {
                    for (int k = 0; k < difference; k++) {
                        System.out.print("(");
                        openBrackets++;
                    }
                } else if (difference < 0) {
                    for (int k = 0; k < -difference; k++) {
                        System.out.print(")");
                        openBrackets--;
                    }
                }
                System.out.print(currentDigit);
            }

            for (int k = 0; k < openBrackets; k++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}