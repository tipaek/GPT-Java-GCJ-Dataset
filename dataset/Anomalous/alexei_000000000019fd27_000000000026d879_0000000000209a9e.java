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
            int[] bitsArray = new int[bitLength];
            Arrays.fill(bitsArray, 2);
            int offset = 0;
            int remainingQueries = 10;

            while (true) {
                System.err.println("Starting loop");
                System.err.println(Arrays.toString(bitsArray));

                while (remainingQueries > 1 && offset <= bitLength / 2) {
                    System.out.println(offset + 1);
                    remainingQueries--;
                    bitsArray[offset] = scanner.nextInt();
                    System.err.println("Wrote " + bitsArray[offset] + " to pos " + offset);

                    System.out.println(bitLength - offset);
                    remainingQueries--;
                    bitsArray[bitLength - offset - 1] = scanner.nextInt();
                    System.err.println("Wrote " + bitsArray[bitLength - offset - 1] + " to pos " + (bitLength - offset - 1));
                    offset++;
                    System.err.println("Remaining " + remainingQueries + " offset " + offset);
                }

                if (offset > bitLength / 2) {
                    StringBuilder result = new StringBuilder();
                    for (int bit : bitsArray) {
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
                    remainingQueries--;
                    System.err.println("Remaining " + remainingQueries);
                }

                System.err.println("New info");
                System.err.println(Arrays.toString(bitsArray));

                remainingQueries = 10;
                int[][] possibleArrays = generatePossibleArrays(bitsArray);
                List<int[]> optionsList = new ArrayList<>(Arrays.asList(possibleArrays));

                System.err.println("Generated options");
                for (int[] option : optionsList) {
                    System.err.println(Arrays.toString(option));
                }

                while (optionsList.size() > 1) {
                    int differingIndex = findDifferingIndex(optionsList.get(0), optionsList.get(1));
                    if (differingIndex == -1) {
                        System.err.println("Two similar arrays, removing one");
                        optionsList.remove(0);
                        continue;
                    }
                    System.out.println(differingIndex + 1);
                    remainingQueries--;
                    System.err.println("Remaining " + remainingQueries);
                    int receivedBit = scanner.nextInt();
                    System.err.println("Checked " + differingIndex + " received " + receivedBit);

                    optionsList.removeIf(option -> option[differingIndex] != receivedBit);
                }
                bitsArray = optionsList.get(0);
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

    private static int[][] generatePossibleArrays(int[] originalArray) {
        int[][] result = new int[4][originalArray.length];
        result[0] = Arrays.copyOf(originalArray, originalArray.length);
        result[1] = new int[originalArray.length];
        result[2] = new int[originalArray.length];
        result[3] = new int[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == 1) result[1][i] = 0;
            else if (originalArray[i] == 0) result[1][i] = 1;
            else result[1][i] = 2;

            result[2][originalArray.length - 1 - i] = result[0][i];
            result[3][originalArray.length - 1 - i] = result[1][i];
        }
        return result;
    }
}