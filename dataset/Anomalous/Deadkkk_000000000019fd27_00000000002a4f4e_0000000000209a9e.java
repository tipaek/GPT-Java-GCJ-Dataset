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
            readBitArray(scanner, bitArray, arraySize, 0, arraySize);
        } else {
            readBitArrayWithSkip(scanner, bitArray, arraySize);
        }

        displayBitArray(bitArray);

        char isCorrect = (char) System.in.read();
        return isCorrect == 'Y';
    }

    private static void readBitArray(Scanner scanner, int[] bitArray, int arraySize, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bitArray[i] = scanner.nextInt();
        }
    }

    private static void readBitArrayWithSkip(Scanner scanner, int[] bitArray, int arraySize) {
        int j = 1;
        for (int i = 0; i < arraySize;) {
            if (j % 40 <= 10 && j % 40 > 0) {
                System.out.println(i + 1);
                System.out.flush();
                bitArray[i] = scanner.nextInt();
                i++;
            } else {
                System.out.println(1);
                scanner.nextInt();
            }
            j++;
        }
    }

    private static void displayBitArray(int[] bitArray) {
        for (int bit : bitArray) {
            System.out.print(bit);
        }
        System.out.println();
        System.out.flush();
    }
}