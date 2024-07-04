import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            try {
                if (!processArray(arraySize)) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean processArray(int arraySize) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] bitArray = new int[arraySize];

        if (arraySize <= 10) {
            populateArray(scanner, bitArray, 0, arraySize);
            displayArray(bitArray, arraySize);
        } else {
            populateArray(scanner, bitArray, 0, 10);
            skipInputs(scanner, 30);
            populateArray(scanner, bitArray, 10, 10);
            displayArray(bitArray, arraySize);
        }

        return checkCorrectness();
    }

    private static void populateArray(Scanner scanner, int[] bitArray, int start, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(start + i + 1);
            System.out.flush();
            bitArray[start + i] = scanner.nextInt();
        }
    }

    private static void skipInputs(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(1);
            System.out.flush();
            scanner.nextInt();
        }
    }

    private static void displayArray(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitArray[i]);
        }
        System.out.println();
        System.out.flush();
    }

    private static boolean checkCorrectness() throws IOException {
        char response = (char) System.in.read();
        return response == 'Y';
    }
}