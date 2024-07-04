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
            readBits(scanner, bitArray, arraySize);
            display(bitArray, arraySize);
            if (!isCorrect()) {
                return false;
            }
        } else {
            readBits(scanner, bitArray, 10);
            skipBits(scanner, 30);
            readBits(scanner, bitArray, 10, 10);
            display(bitArray, arraySize);
            if (!isCorrect()) {
                return false;
            }
        }
        return true;
    }

    private static void readBits(Scanner scanner, int[] bitArray, int count) {
        readBits(scanner, bitArray, count, 0);
    }

    private static void readBits(Scanner scanner, int[] bitArray, int count, int offset) {
        for (int i = 0; i < count; i++) {
            System.out.println(offset + i + 1);
            System.out.flush();
            bitArray[offset + i] = scanner.nextInt();
        }
    }

    private static void skipBits(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(1);
            System.out.flush();
            scanner.nextInt();
        }
    }

    private static boolean isCorrect() throws IOException {
        return (char) System.in.read() == 'Y';
    }

    private static void display(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitArray[i]);
        }
        System.out.println();
        System.out.flush();
    }
}