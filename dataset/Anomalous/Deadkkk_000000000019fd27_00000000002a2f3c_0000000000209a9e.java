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
            readInput(bitArray, arraySize, scanner);
            displayArray(bitArray, arraySize);
            return checkCorrectness();
        } else {
            readInput(bitArray, 10, scanner);
            skipInput(30);
            readInput(bitArray, 10, scanner, 10);
            displayArray(bitArray, arraySize);
            return checkCorrectness();
        }
    }

    private static void readInput(int[] bitArray, int size, Scanner scanner) {
        readInput(bitArray, size, scanner, 0);
    }

    private static void readInput(int[] bitArray, int size, Scanner scanner, int offset) {
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + offset);
            System.out.flush();
            bitArray[i + offset] = scanner.nextInt();
        }
    }

    private static void skipInput(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1);
            System.out.flush();
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
        char isCorrect = (char) System.in.read();
        return isCorrect == 'Y';
    }
}