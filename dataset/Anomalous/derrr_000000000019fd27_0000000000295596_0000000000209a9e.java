import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            if (!processTestCase(scanner, bitLength)) {
                System.exit(0);
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int diffIndex = -1, sameIndex = -1;
        int[] resultArray = new int[bitLength];
        for (int i = 0, queryCount = 0; i <= (resultArray.length - 1) / 2; i++) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                handleChange(scanner, resultArray, i, diffIndex, sameIndex);
                queryCount += 2;
            }

            resultArray[i] = getBit(scanner, i + 1);
            queryCount++;
            resultArray[bitLength - i - 1] = getBit(scanner, bitLength - i);
            queryCount++;

            if (diffIndex == -1 && resultArray[i] != resultArray[bitLength - i - 1]) {
                diffIndex = i;
            }
            if (sameIndex == -1 && resultArray[i] == resultArray[bitLength - i - 1]) {
                sameIndex = i;
            }
        }

        System.out.println(arrayToString(resultArray));
        return "Y".equals(scanner.next());
    }

    private static void handleChange(Scanner scanner, int[] resultArray, int i, int diffIndex, int sameIndex) {
        if (diffIndex == -1 || sameIndex == -1) {
            int targetIndex = (diffIndex == -1) ? sameIndex : diffIndex;
            System.out.println(targetIndex + 1);
            if (scanner.nextInt() != resultArray[targetIndex]) {
                complementArray(resultArray, i);
            }
            System.out.println(1);
            scanner.nextLine();
        } else {
            boolean sameChanged = checkChange(scanner, resultArray, sameIndex);
            boolean diffChanged = checkChange(scanner, resultArray, diffIndex);

            if (diffChanged && sameChanged) {
                complementArray(resultArray, i);
            } else if (diffChanged) {
                reverseArray(resultArray, i);
            } else if (sameChanged) {
                complementAndReverseArray(resultArray, i);
            }
        }
    }

    private static boolean checkChange(Scanner scanner, int[] resultArray, int index) {
        System.out.println(index + 1);
        return scanner.nextInt() != resultArray[index];
    }

    private static int getBit(Scanner scanner, int position) {
        System.out.println(position);
        return scanner.nextInt();
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int bit : array) {
            sb.append(bit);
        }
        return sb.toString();
    }

    private static void complementArray(int[] array, int length) {
        for (int left = 0, right = array.length - 1; left <= length; left++, right--) {
            array[left] = 1 - array[left];
            array[right] = 1 - array[right];
        }
    }

    private static void reverseArray(int[] array, int length) {
        for (int left = 0, right = array.length - 1; left <= length; left++, right--) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    private static void complementAndReverseArray(int[] array, int length) {
        for (int left = 0, right = array.length - 1; left <= length; left++, right--) {
            int temp = 1 - array[left];
            array[left] = 1 - array[right];
            array[right] = temp;
        }
    }
}