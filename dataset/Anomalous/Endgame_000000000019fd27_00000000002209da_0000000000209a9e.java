import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int[] bitArray = new int[B];
        for (int i = 1; i <= T; i++) {
            processTestCase(B, bitArray);
        }
    }

    private static void processTestCase(int B, int[] bitArray) {
        for (int i = 0; i < B / 2; i++) {
            queryAndStoreBit(i + 1, bitArray);
            queryAndStoreBit(B - i, bitArray);
        }

        int times = 41 - (B % 40);
        int numTeams = B / 10;
        int[] representors = new int[numTeams];

        for (int i = 0; i < times - 1; i++) {
            int representorIndex = i % 10 % numTeams;
            queryAndStoreRepresentor(representorIndex * 5 + 1, representors, representorIndex);
        }

        queryAndIgnore(1);

        adjustBitArray(B, bitArray, representors, numTeams);

        String result = buildBitString(bitArray);
        System.out.println(result);

        if (scanner.next().charAt(0) == 'N') {
            String flippedResult = buildFlippedBitString(bitArray);
            System.out.println(flippedResult);
            scanner.nextInt(); // Ensure the next input is read
        }
    }

    private static void queryAndStoreBit(int position, int[] bitArray) {
        System.out.println(position);
        bitArray[position - 1] = scanner.nextInt();
    }

    private static void queryAndStoreRepresentor(int position, int[] representors, int index) {
        System.out.println(position);
        representors[index] = scanner.nextInt();
    }

    private static void queryAndIgnore(int position) {
        System.out.println(position);
        scanner.nextInt(); // Ignore the response
    }

    private static void adjustBitArray(int B, int[] bitArray, int[] representors, int numTeams) {
        for (int i = 0; i < numTeams; i++) {
            int representorValue = representors[i];
            if (representorValue != bitArray[i * 5]) {
                for (int j = 0; j < 5; j++) {
                    int leftIndex = i * 5 + j;
                    int rightIndex = B - 1 - i * 5 - j;
                    bitArray[leftIndex] = (bitArray[leftIndex] + 1) % 2;
                    bitArray[rightIndex] = (bitArray[rightIndex] + 1) % 2;
                }
            }
        }
    }

    private static String buildBitString(int[] bitArray) {
        StringBuilder bitString = new StringBuilder();
        for (int bit : bitArray) {
            bitString.append(bit);
        }
        return bitString.toString();
    }

    private static String buildFlippedBitString(int[] bitArray) {
        StringBuilder flippedBitString = new StringBuilder();
        for (int bit : bitArray) {
            flippedBitString.append((bit + 1) % 2);
        }
        return flippedBitString.toString();
    }
}