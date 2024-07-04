import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        int[] bitArray = new int[bitLength];

        for (int i = 1; i <= testCases; i++) {
            if (bitLength == 10) {
                processBitLength10(bitArray);
            } else if (bitLength == 20) {
                processBitLength20(bitArray);
            } else {
                processOtherBitLengths(bitLength, bitArray);
            }
        }
    }

    private static void processBitLength10(int[] bitArray) {
        StringBuilder result = new StringBuilder();

        for (int bit = 1; bit <= 10; bit++) {
            System.out.println(bit);
            result.append(scanner.next().charAt(0));
        }

        System.out.println(result.toString());
        scanner.next();
    }

    private static void processBitLength20(int[] bitArray) {
        int bitLength = 20;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bitLength / 2; i++) {
            int position = i + 1;
            System.out.println(position);
            bitArray[position - 1] = scanner.next().charAt(0) - '0';
            position = bitLength - i;
            System.out.println(position);
            bitArray[position - 1] = scanner.next().charAt(0) - '0';
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            int leftValue = scanner.next().charAt(0) - '0';

            if (leftValue != bitArray[i]) {
                bitArray[i] = leftValue;
                bitArray[bitLength - 1 - i] = (bitArray[bitLength - 1 - i] + 1) % 2;
            }
        }

        for (int bit : bitArray) {
            result.append(bit);
        }

        System.out.println(result.toString());
        scanner.next();
    }

    private static void processOtherBitLengths(int bitLength, int[] bitArray) {
        System.exit(0);
    }
}