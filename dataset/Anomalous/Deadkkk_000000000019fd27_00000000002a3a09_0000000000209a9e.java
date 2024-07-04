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
            readBitArray(scanner, bitArray, arraySize);
        } else {
            readBitArray(scanner, bitArray, 10);
            outputDummyData();
            readBitArray(scanner, bitArray, 10, 10);
        }
        
        displayBitArray(bitArray, arraySize);
        
        char isCorrect = (char) System.in.read();
        return isCorrect == 'Y';
    }

    private static void readBitArray(Scanner scanner, int[] bitArray, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bitArray[i] = scanner.nextInt();
        }
    }

    private static void readBitArray(Scanner scanner, int[] bitArray, int length, int offset) {
        for (int i = 0; i < length; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bitArray[offset + i] = scanner.nextInt();
        }
    }

    private static void outputDummyData() {
        for (int i = 0; i < 30; i++) {
            System.out.println(1);
        }
        System.out.flush();
    }

    private static void displayBitArray(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitArray[i]);
        }
        System.out.println();
        System.out.flush();
    }
}