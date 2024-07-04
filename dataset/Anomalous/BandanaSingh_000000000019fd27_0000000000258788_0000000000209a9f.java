import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTest = input.nextInt();
        input.nextLine();

        for (int k = 0; k < numOfTest; k++) {
            String inputString = input.nextLine();
            System.out.print("Case #" + (k + 1) + ": ");

            int previousVal = Character.getNumericValue(inputString.charAt(0));
            printBraces(previousVal, previousVal, true);

            for (int i = 1; i < inputString.length(); i++) {
                int currentVal = Character.getNumericValue(inputString.charAt(i));
                if (currentVal > previousVal) {
                    printBraces(currentVal, currentVal - previousVal, true);
                } else if (currentVal < previousVal) {
                    printBraces(currentVal, previousVal - currentVal, false);
                } else {
                    System.out.print(currentVal);
                }
                previousVal = currentVal;
            }

            for (int j = 0; j < previousVal; j++) {
                System.out.print(")");
            }
            System.out.println();
        }
        input.close();
    }

    private static void printBraces(int charValue, int braceCount, boolean isOpening) {
        char brace = isOpening ? '(' : ')';
        for (int i = 0; i < braceCount; i++) {
            System.out.print(brace);
        }
        System.out.print(charValue);
    }
}