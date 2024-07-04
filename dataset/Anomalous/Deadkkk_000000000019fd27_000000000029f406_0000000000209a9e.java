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
            System.out.println(i + 1); // Output 1-based index
            bitArray[i] = scanner.nextInt();
        }

        if (arraySize <= 10) {
            displayArray(bitArray);
            String response = scanner.next();
            if (!response.equals("Y")) {
                return false;
            }
        }

        return true;
    }

    private static void displayArray(int[] bitArray) {
        for (int bit : bitArray) {
            System.out.print(bit);
        }
        System.out.println();
    }
}