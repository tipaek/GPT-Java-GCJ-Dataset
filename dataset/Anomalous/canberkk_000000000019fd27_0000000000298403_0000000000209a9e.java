import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = scanner.nextLine().split(" ");
        int numCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int[][] bitArrays = new int[4][bitLength];
            boolean[] validity = new boolean[4];
            int knownBits = 0;
            int queriesBeforeShuffle = 10;

            for (int i = 0; i < bitLength; i++) {
                bitArrays[0][i] = -1;
            }

            while (knownBits <= bitLength / 2) {
                if (queriesBeforeShuffle == 0) {
                    prepareBitArrays(bitArrays, bitLength);
                    queriesBeforeShuffle = 10;

                    for (int i = 0; i < 4; i++) {
                        validity[i] = true;
                    }

                    int testIndex = selectTestIndex(bitArrays, validity);
                    while (testIndex != -1) {
                        writer.println(testIndex + 1);
                        writer.flush();
                        queriesBeforeShuffle--;

                        int response = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < 4; i++) {
                            validity[i] &= (response == bitArrays[i][testIndex]);
                        }

                        testIndex = selectTestIndex(bitArrays, validity);
                    }

                    int validIndex = 0;
                    while (!validity[validIndex]) {
                        validIndex++;
                    }

                    bitArrays[0] = bitArrays[validIndex].clone();
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
                    } else {
                        knownBits++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bitArrays[0]) {
                result.append(bit);
            }

            writer.println(result.toString());
            writer.flush();

            if (scanner.nextLine().equals("N")) {
                System.exit(1);
            }
        }

        scanner.close();
        writer.close();
    }

    private static void prepareBitArrays(int[][] bitArrays, int bitLength) {
        for (int i = 0; i < bitLength; i++) {
            if (bitArrays[0][i] == -1) {
                bitArrays[1][i] = -1;
                bitArrays[2][bitLength - i - 1] = -1;
                bitArrays[3][bitLength - i - 1] = -1;
            } else {
                bitArrays[1][i] = 1 - bitArrays[0][i]; // Complement
                bitArrays[2][bitLength - i - 1] = bitArrays[0][i]; // Reverse
                bitArrays[3][bitLength - i - 1] = 1 - bitArrays[0][i]; // Both
            }
        }
    }

    private static int selectTestIndex(int[][] bitArrays, boolean[] validity) {
        int validCount = 0;
        for (boolean isValid : validity) {
            if (isValid) {
                validCount++;
            }
        }

        if (validCount == 1) {
            return -1;
        }

        for (int i = 0; i < bitArrays[0].length; i++) {
            int zeroCount = 0;
            int oneCount = 0;

            for (int j = 0; j < 4; j++) {
                if (validity[j]) {
                    if (bitArrays[j][i] == 0) {
                        zeroCount++;
                    } else if (bitArrays[j][i] == 1) {
                        oneCount++;
                    }
                }
            }

            if (Math.min(zeroCount, oneCount) == validCount / 2) {
                return i;
            }
        }

        return -1;
    }
}