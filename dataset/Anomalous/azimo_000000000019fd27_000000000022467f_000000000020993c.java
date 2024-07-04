import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int arraySize = scanner.nextInt();
            scanner.nextLine();
            int[] array = new int[arraySize * arraySize];

            for (int i = 0; i < arraySize; i++) {
                String inputString = scanner.nextLine();
                String[] elements = inputString.split(" ");

                for (int j = 0; j < arraySize; j++) {
                    array[i * arraySize + j] = Integer.parseInt(elements[j]);
                }
            }

            int trace = calculateTrace(array, arraySize);
            int numDuplicateRows = countDuplicates(array, arraySize, true);
            int numDuplicateCols = countDuplicates(array, arraySize, false);

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, numDuplicateRows, numDuplicateCols);
        }

        scanner.close();
    }

    private static int calculateTrace(int[] array, int arraySize) {
        int trace = 0;
        for (int i = 0; i < arraySize; i++) {
            trace += array[i * (arraySize + 1)];
        }
        return trace;
    }

    private static int countDuplicates(int[] array, int arraySize, boolean isRow) {
        int duplicates = 0;
        for (int i = 0; i < arraySize; i++) {
            HashSet<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < arraySize; j++) {
                int value = isRow ? array[i * arraySize + j] : array[j * arraySize + i];
                if (seen.contains(value)) {
                    hasDuplicate = true;
                    break;
                }
                seen.add(value);
            }
            if (hasDuplicate) {
                duplicates++;
            }
        }
        return duplicates;
    }
}