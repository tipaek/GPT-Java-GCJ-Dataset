import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            char[] bitArray = new char[bitLength];
            int count = 0;

            for (int i = 1; i <= bitLength; i++) {
                if (i % 10 == 1) count++;
                System.out.println(i);
                bitArray[i - 1] = scanner.nextInt() == 0 ? '0' : '1';
            }
            scanner.nextLine();

            if (processAndCheck(scanner, bitArray)) continue;

            char[] complementArray = complement(bitArray);
            if (processAndCheck(scanner, complementArray)) continue;

            char[] reversedArray = reverse(bitArray);
            if (processAndCheck(scanner, reversedArray)) continue;

            char[] complementReversedArray = complement(reversedArray);
            if (processAndCheck(scanner, complementReversedArray)) continue;

            char[] tempArray = new char[10];
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                tempArray[i - 1] = scanner.nextInt() == 0 ? '0' : '1';
            }
            scanner.nextLine();

            char[] combinedArray = Arrays.copyOf(bitArray, bitArray.length);
            System.arraycopy(tempArray, 0, combinedArray, 0, 10);

            if (processAndCheck(scanner, combinedArray)) continue;

            complementArray = complement(combinedArray);
            if (processAndCheck(scanner, complementArray)) continue;

            reversedArray = reverse(combinedArray);
            if (processAndCheck(scanner, reversedArray)) continue;

            complementReversedArray = complement(reversedArray);
            if (processAndCheck(scanner, complementReversedArray)) continue;
        }

        scanner.close();
    }

    private static boolean processAndCheck(Scanner scanner, char[] array) {
        System.out.println(new String(array));
        return scanner.nextLine().contains("Y");
    }

    private static char[] complement(char[] array) {
        char[] result = array.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] == '0' ? '1' : '0';
        }
        return result;
    }

    private static char[] reverse(char[] array) {
        char[] result = array.clone();
        for (int left = 0, right = result.length - 1; left < right; left++, right--) {
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
        }
        return result;
    }
}