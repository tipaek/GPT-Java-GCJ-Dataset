import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.err.println("Test " + testCase);
            int[] bits = new int[bitLength];
            Arrays.fill(bits, 2);
            int offset = 0;
            int remainingQueries = 10;

            while (true) {
                System.err.println("Starting loop");
                System.err.println(Arrays.toString(bits));

                while (remainingQueries > 1 && offset <= bitLength / 2) {
                    System.out.println(offset + 1);
                    remainingQueries--;
                    bits[offset] = scanner.nextInt();
                    System.err.println("Wrote " + bits[offset] + " to pos " + offset);

                    System.out.println(bitLength - offset);
                    remainingQueries--;
                    bits[bitLength - offset - 1] = scanner.nextInt();
                    System.err.println("Wrote " + bits[bitLength - offset - 1] + " to pos " + (bitLength - offset - 1));
                    offset++;
                    System.err.println("Remaining " + remainingQueries + " offset " + offset);
                }

                if (offset > bitLength / 2) {
                    StringBuilder result = new StringBuilder();
                    for (int bit : bits) {
                        result.append(bit);
                    }
                    System.out.println(result.toString());
                    String response = scanner.next();
                    if (response.equals("Y")) {
                        break;
                    } else {
                        throw new RuntimeException(response);
                    }
                }

                while (remainingQueries > 0) {
                    System.out.println(offset);
                    scanner.nextInt();
                    remainingQueries--;
                    System.err.println("Remaining " + remainingQueries);
                }

                System.err.println("New info");
                System.err.println(Arrays.toString(bits));

                remainingQueries = 10;
                int[][] options = generateVariants(bits);
                List<int[]> validOptions = new ArrayList<>(Arrays.asList(options));

                System.err.println("Generated options");
                for (int[] option : validOptions) {
                    System.err.println(Arrays.toString(option));
                }

                while (validOptions.size() > 1) {
                    int differingIndex = findDifferingIndex(validOptions.get(0), validOptions.get(1));
                    if (differingIndex == -1) {
                        System.err.println("Two similar arrays, removing one");
                        validOptions.remove(0);
                        continue;
                    }
                    System.out.println(differingIndex + 1);
                    remainingQueries--;
                    System.err.println("Remaining " + remainingQueries);
                    int responseValue = scanner.nextInt();
                    System.err.println("Checked " + differingIndex + " received " + responseValue);

                    validOptions.removeIf(option -> option[differingIndex] != responseValue);
                }
                bits = validOptions.get(0);
            }
        }
    }

    private static int findDifferingIndex(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 2) continue;
            if (array1[i] != array2[i]) return i;
        }
        return -1;
    }

    private static int[][] generateVariants(int[] array) {
        int[][] variants = new int[4][array.length];
        variants[0] = Arrays.copyOf(array, array.length);
        variants[1] = new int[array.length];
        variants[2] = new int[array.length];
        variants[3] = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) variants[1][i] = 0;
            else if (array[i] == 0) variants[1][i] = 1;
            else variants[1][i] = 2;

            variants[2][array.length - 1 - i] = variants[0][i];
            variants[3][array.length - 1 - i] = variants[1][i];
        }
        return variants;
    }
}