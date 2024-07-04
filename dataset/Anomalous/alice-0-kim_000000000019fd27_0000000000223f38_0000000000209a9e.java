import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            char[] bits = new char[bitLength];

            for (int i = 0; i < bitLength; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 0 ? '0' : '1';
            }
            scanner.nextLine();

            // Original sequence
            System.out.println(new String(bits));
            if (scanner.nextLine().contains("Y")) continue;

            // Complementary sequence
            char[] complementary = complement(bits);
            System.out.println(new String(complementary));
            if (scanner.nextLine().contains("Y")) continue;

            // Reversed sequence
            char[] reversed = reverse(bits);
            System.out.println(new String(reversed));
            if (scanner.nextLine().contains("Y")) continue;

            // Complementary and Reversed sequence
            char[] complementaryReversed = complement(reversed);
            System.out.println(new String(complementaryReversed));
            if (scanner.nextLine().contains("Y")) continue;
        }
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
        int left = 0, right = result.length - 1;
        while (left < right) {
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left++;
            right--;
        }
        return result;
    }
}