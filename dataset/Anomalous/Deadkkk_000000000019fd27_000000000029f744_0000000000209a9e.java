import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int noOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            if (!processTestCase(arraySize)) {
                return;
            }
        }
    }

    private static boolean processTestCase(int arraySize) {
        int[] bitArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.print(i);
            bitArray[i] = scanner.nextInt();
        }

        if (arraySize <= 10) {
            displayArray(bitArray);
            String isCorrect = scanner.next();
            if (!isCorrect.equalsIgnoreCase("Y")) {
                return false;
            }
        }

        return true;
    }

    private static void displayArray(int[] bitArray) {
        for (int bit : bitArray) {
            System.out.print(bit);
        }
    }
}