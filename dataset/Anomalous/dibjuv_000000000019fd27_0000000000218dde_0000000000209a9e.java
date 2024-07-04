import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            if (bitLength == 10) {
                handleBitLength10(scanner);
            } else if (bitLength == 20) {
                handleBitLength20(scanner, bitLength);
            } else {
                // Additional handling for other bit lengths can be implemented here
            }
        }
    }

    private static void handleBitLength10(Scanner scanner) {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            result[i] = scanner.nextInt();
        }
        printArray(result);
    }

    private static void handleBitLength20(Scanner scanner, int bitLength) {
        int[] result = new int[bitLength];
        boolean[] isSame = new boolean[10];

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            result[i] = scanner.nextInt();
            System.out.println(bitLength - i);
            result[bitLength - i - 1] = scanner.nextInt();
            isSame[i] = (result[i] == result[bitLength - i - 1]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            result[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            if (isSame[i]) {
                result[bitLength - i - 1] = result[i];
            } else {
                result[bitLength - i - 1] = 1 - result[i];
            }
        }

        printArray(result);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
    }
}