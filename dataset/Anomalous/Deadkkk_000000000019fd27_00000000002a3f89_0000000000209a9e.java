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
        int[] bitset = new int[arraySize];

        if (arraySize <= 10) {
            readAndStoreBits(scanner, bitset, 0, arraySize);
        } else {
            readAndStoreBits(scanner, bitset, 0, 10);
            skipBits(scanner, 30);
            readAndStoreBits(scanner, bitset, 10, 10);
        }

        display(bitset, arraySize);
        return isCorrectResponse();
    }

    private static void readAndStoreBits(Scanner scanner, int[] bitset, int start, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(start + i + 1);
            System.out.flush();
            bitset[start + i] = scanner.nextInt();
        }
    }

    private static void skipBits(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(1);
            System.out.flush();
            scanner.nextInt();
        }
    }

    private static void display(int[] bitset, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(bitset[i]);
        }
        System.out.println();
        System.out.flush();
    }

    private static boolean isCorrectResponse() throws IOException {
        char response = (char) System.in.read();
        return response == 'Y';
    }
}