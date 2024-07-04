import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = scanner.nextLine().split(" ");
        int cases = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int[][] bits = new int[4][B];
        boolean[] valid = new boolean[4];
        int knownBits = 0;
        int queriesBeforeShuffle = 10;

        for (int c = 1; c <= cases; c++) {
            knownBits = 0;
            for (int i = 0; i < B; i++) {
                bits[0][i] = -1;
            }
            while (knownBits <= B / 2) {
                if (queriesBeforeShuffle == 0) {
                    for (int i = 0; i < B; i++) {
                        if (bits[0][i] == -1) {
                            bits[1][i] = -1;
                            bits[2][B - i - 1] = -1;
                            bits[3][B - i - 1] = -1;
                        } else {
                            bits[1][i] = 1 - bits[0][i]; // complement
                            bits[2][B - i - 1] = bits[0][i]; // reverse
                            bits[3][B - i - 1] = 1 - bits[0][i]; // both
                        }
                    }
                    queriesBeforeShuffle = 10;
                    for (int i = 0; i < 4; i++) valid[i] = true;
                    int index = selectTestIndex(bits, valid);
                    while (index != -1) {
                        writer.println(index + 1);
                        writer.flush();
                        queriesBeforeShuffle--;
                        int result = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < 4; i++) {
                            valid[i] = valid[i] && result == bits[i][index];
                        }
                        index = selectTestIndex(bits, valid);
                    }
                    if (!valid[0]) {
                        int i = 1;
                        while (!valid[i]) i++;
                        bits[0] = bits[i].clone();
                    }
                }

                while (queriesBeforeShuffle > 0 && knownBits <= B / 2) {
                    if (bits[0][knownBits] == -1) {
                        writer.println(knownBits + 1);
                        writer.flush();
                        queriesBeforeShuffle--;
                        bits[0][knownBits] = Integer.parseInt(scanner.nextLine());
                    } else if (bits[0][B - knownBits - 1] == -1) {
                        writer.println(B - knownBits);
                        writer.flush();
                        queriesBeforeShuffle--;
                        bits[0][B - knownBits - 1] = Integer.parseInt(scanner.nextLine());
                    }
                    if (bits[0][knownBits] != -1 && bits[0][B - knownBits - 1] != -1) knownBits++;
                }
            }
            StringBuilder guess = new StringBuilder();
            for (int bit : bits[0]) guess.append(bit);
            writer.println(guess);
            writer.flush();
            if (scanner.nextLine().equals("N")) System.exit(0);
        }
        scanner.close();
        writer.close();
    }

    private static int selectTestIndex(int[][] bits, boolean[] valid) {
        int validCount = 0;
        for (boolean v : valid) if (v) validCount++;
        if (validCount == 1) return -1;

        int index = -1;
        int max = 0;
        for (int i = 0; i < bits[0].length; i++) {
            int zeroes = 0;
            int ones = 0;
            for (int j = 0; j < 4; j++) {
                if (valid[j]) {
                    if (bits[j][i] == 0) zeroes++;
                    if (bits[j][i] == 1) ones++;
                }
            }
            int min = Math.min(zeroes, ones);
            if (min == validCount / 2) return i;
            if (min > max) {
                max = min;
                index = i;
            }
        }
        return index;
    }
}