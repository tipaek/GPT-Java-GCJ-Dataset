import java.util.Scanner;

public class Solution {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static String solve(int B) {
        int[] array = new int[B];
        int matchIndex1 = -1, matchIndex2 = -1;
        int diffIndex1 = -1, diffIndex2 = -1;
        int queryCount = 0;

        for (int i = 0; i < B / 2; ++i) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                handleQueries(array, B, i, matchIndex1, diffIndex1);
                queryCount++;
            }

            System.out.printf("%d\n", i);
            array[i] = SCANNER.nextInt();
            queryCount++;

            System.out.printf("%d\n", B - i - 1);
            array[B - i - 1] = SCANNER.nextInt();
            queryCount++;

            if (matchIndex1 < 0 && array[i] == array[B - i - 1]) {
                matchIndex1 = i;
                matchIndex2 = B - i - 1;
            } else if (diffIndex1 < 0 && array[i] != array[B - i - 1]) {
                diffIndex1 = i;
                diffIndex2 = B - i - 1;
            }
        }

        return buildResult(array);
    }

    private static void handleQueries(int[] array, int B, int i, int matchIndex1, int diffIndex1) {
        int temp;
        if (matchIndex1 > -1) {
            System.out.printf("%d\n", matchIndex1);
            temp = SCANNER.nextInt();
            if (array[matchIndex1] != temp) {
                invertArray(array, i, B);
            }
        }

        if (diffIndex1 > -1) {
            System.out.printf("%d\n", diffIndex1);
            temp = SCANNER.nextInt();
            if (array[diffIndex1] != temp) {
                reverseArray(array, i, B);
            }
        }

        if (SCANNER.hasNextInt()) {
            System.out.printf("%d\n", diffIndex1);
            SCANNER.nextInt();
        }
    }

    private static void invertArray(int[] array, int i, int B) {
        for (int j = 0; j < i; ++j) {
            array[j] = ~array[j];
            array[B - j - 1] = ~array[B - j - 1];
        }
    }

    private static void reverseArray(int[] array, int i, int B) {
        int temp;
        for (int j = 0; j < i; ++j) {
            temp = array[j];
            array[j] = array[B - j - 1];
            array[B - j - 1] = temp;
        }
    }

    private static String buildResult(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int T = SCANNER.nextInt();

        for (int i = 1; i <= T; ++i) {
            int B = SCANNER.nextInt();
            String result = solve(B);
            System.out.printf("Case #%d: %s\n", i, result);
        }

        SCANNER.close();
    }
}