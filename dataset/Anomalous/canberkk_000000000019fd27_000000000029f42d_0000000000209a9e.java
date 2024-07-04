import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        int[][] bitArrays = new int[4][bitLength];
        boolean[] isValid = new boolean[4];
        int knownBits = 0;
        int queriesBeforeShuffle = 10;

        for (int testCase = 1; testCase <= testCases; testCase++) {
            knownBits = 0;
            queriesBeforeShuffle = 10;
            for (int i = 0; i < bitLength; i++) {
                bitArrays[0][i] = -1;
            }
            while (knownBits <= bitLength / 2) {
                if (queriesBeforeShuffle == 0) {
                    for (int i = 0; i < bitLength; i++) {
                        if (bitArrays[0][i] == -1) {
                            bitArrays[1][i] = -1;
                            bitArrays[2][bitLength - i - 1] = -1;
                            bitArrays[3][bitLength - i - 1] = -1;
                        } else {
                            bitArrays[1][i] = 1 - bitArrays[0][i];
                            bitArrays[2][bitLength - i - 1] = bitArrays[0][i];
                            bitArrays[3][bitLength - i - 1] = 1 - bitArrays[0][i];
                        }
                    }
                    queriesBeforeShuffle = 10;
                    for (int i = 0; i < 4; i++) isValid[i] = true;
                    int index = selectTestIndex(bitArrays, isValid);
                    do {
                        writer.println(index + 1);
                        writer.flush();
                        queriesBeforeShuffle--;
                        int result = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < 4; i++) {
                            isValid[i] = isValid[i] && result == bitArrays[i][index];
                        }
                        index = selectTestIndex(bitArrays, isValid);
                    } while (index != -1);
                    if (!isValid[0]) {
                        int i = 1;
                        while (!isValid[i]) i++;
                        bitArrays[0] = bitArrays[i].clone();
                    }
                }

                while (queriesBeforeShuffle > 0 && knownBits <= bitLength / 2) {
                    if (bitArrays[0][knownBits] == -1) {
                        writer.println(knownBits + 1);
                        writer.flush();
                        queriesBeforeShuffle--;
                        bitArrays[0][knownBits] = Integer.parseInt(scanner.nextLine());
                    } else if (bitArrays[0][bitLength - knownBits - 1] == -1) {
                        writer.println(bitLength - knownBits);
                        writer.flush();
                        queriesBeforeShuffle--;
                        bitArrays[0][bitLength - knownBits - 1] = Integer.parseInt(scanner.nextLine());
                    }
                    if (bitArrays[0][knownBits] != -1 && bitArrays[0][bitLength - knownBits - 1] != -1) {
                        knownBits++;
                    }
                }
            }
            StringBuilder guess = new StringBuilder();
            for (int bit : bitArrays[0]) guess.append(bit);
            writer.println(guess.toString());
            writer.flush();
            if (scanner.nextLine().equals("N")) System.exit(0);
        }
        scanner.close();
        writer.close();
    }

    private static int selectTestIndex(int[][] bitArrays, boolean[] isValid) {
        int validCount = 0;
        for (boolean valid : isValid) if (valid) validCount++;
        if (validCount == 1) return -1;
        int index = -1;
        int maxMin = 0;
        for (int i = 0; i < bitArrays[0].length; i++) {
            int zeroes = 0;
            int ones = 0;
            for (int j = 0; j < 4; j++) {
                if (isValid[j] && bitArrays[j][i] == 0) zeroes++;
                if (isValid[j] && bitArrays[j][i] == 1) ones++;
            }
            int minCount = Math.min(zeroes, ones);
            if (minCount == validCount / 2) return i;
            if (minCount > maxMin) {
                maxMin = minCount;
                index = i;
            }
        }
        return index;
    }
}