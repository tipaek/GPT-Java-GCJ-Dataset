import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int i = 0; i < noOfTestCases; i++) {
            try {
                if (!processTestCase(arraySize)) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean processTestCase(int arraySize) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] bitArray = new int[arraySize];
        
        if (arraySize <= 10) {
            readAndPrintBitArray(scanner, bitArray, arraySize);
        } else {
            readAndPrintBitArray(scanner, bitArray, 10);
            skipInputs(scanner, 30);
            readAndPrintBitArray(scanner, bitArray, 10, 9);
        }
        
        displayArray(bitArray, arraySize);
        
        char isCorrect = (char) System.in.read();
        return isCorrect == 'Y';
    }

    private static void readAndPrintBitArray(Scanner scanner, int[] bitArray, int limit) {
        readAndPrintBitArray(scanner, bitArray, limit, 0);
    }

    private static void readAndPrintBitArray(Scanner scanner, int[] bitArray, int limit, int offset) {
        for (int i = 0; i < limit; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bitArray[offset + i] = scanner.nextInt();
        }
    }

    private static void skipInputs(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(1);
            scanner.nextInt();
        }
        System.out.flush();
    }

    private static void displayArray(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitArray[i]);
        }
        System.out.println();
        System.out.flush();
    }
}