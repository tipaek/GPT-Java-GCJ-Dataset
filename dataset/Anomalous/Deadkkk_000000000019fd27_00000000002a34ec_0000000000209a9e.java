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
            readBitArray(scanner, bitArray, arraySize, 0);
            printAndValidate(bitArray, arraySize);
        } else {
            readBitArray(scanner, bitArray, 10, 0);
            printIndices(30);
            readBitArray(scanner, bitArray, 10, 10);
            printAndValidate(bitArray, arraySize);
        }

        return true;
    }

    private static void readBitArray(Scanner scanner, int[] bitArray, int length, int offset) {
        for (int i = 0; i < length; i++) {
            System.out.println(i + 1 + offset);
            System.out.flush();
            bitArray[i + offset] = scanner.nextInt();
        }
    }

    private static void printIndices(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(i);
        }
        System.out.flush();
    }

    private static void printAndValidate(int[] bitArray, int arraySize) throws IOException {
        displayBitArray(bitArray, arraySize);
        if (System.in.read() != 'Y') {
            throw new IOException("Incorrect response");
        }
    }

    private static void displayBitArray(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitArray[i]);
        }
        System.out.println();
        System.out.flush();
    }
}