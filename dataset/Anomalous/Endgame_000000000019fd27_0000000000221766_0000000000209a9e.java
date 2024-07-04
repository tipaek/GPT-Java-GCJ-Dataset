import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        int[] bitArray = new int[bitLength];

        for (int i = 1; i <= testCases; i++) {
            processBits(bitLength, bitArray);
        }
    }

    private static void processBits(int bitLength, int[] bitArray) {
        for (int i = 0; i < bitLength / 2; i++) {
            queryAndStoreBit(i + 1, bitArray); // Query and store bit at position i+1
            queryAndStoreBit(bitLength - i, bitArray); // Query and store bit at position bitLength-i
        }

        int numTeams = bitLength / 10;
        int[] representors = new int[numTeams];

        for (int i = 0; i < numTeams; i++) {
            int representorIndex = (i * 5) + 1;
            System.out.println(representorIndex);
            representors[i] = scanner.nextInt();
        }

        adjustBits(bitLength, bitArray, numTeams, representors);

        printBitArray(bitArray);

        String response = scanner.next();
        if (response.charAt(0) == 'N') {
            System.exit(0);
        }
    }

    private static void queryAndStoreBit(int position, int[] bitArray) {
        System.out.println(position);
        bitArray[position - 1] = scanner.nextInt();
    }

    private static void adjustBits(int bitLength, int[] bitArray, int numTeams, int[] representors) {
        for (int i = 0; i < numTeams; i++) {
            int representorValue = representors[i];
            if (representorValue != bitArray[i * 5]) {
                for (int j = 0; j < 5; j++) {
                    int leftIndex = i * 5 + j;
                    int rightIndex = bitLength - 1 - (i * 5 + j);

                    bitArray[leftIndex] = (bitArray[leftIndex] + 1) % 2;
                    bitArray[rightIndex] = (bitArray[rightIndex] + 1) % 2;
                }
            }
        }
    }

    private static void printBitArray(int[] bitArray) {
        StringBuilder bitString = new StringBuilder();
        for (int bit : bitArray) {
            bitString.append(bit);
        }
        System.out.println(bitString.toString());
    }
}