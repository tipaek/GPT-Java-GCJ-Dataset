import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTestCases = input.nextInt();
        input.nextLine();

        for (int k = 0; k < numOfTestCases; k++) {
            String inputString = input.nextLine();
            System.out.print("Case #" + k + ": ");

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

    private static void printBraces(int value, int count, boolean open) {
        for (int i = 0; i < count; i++) {
            System.out.print(open ? "(" : ")");
        }
        System.out.print(value);
    }
}