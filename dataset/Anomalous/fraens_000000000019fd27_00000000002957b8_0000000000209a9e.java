import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public static int[] complementAndReverseArray(int[] array) {
        int[] reversedArray = reverseArray(array);
        complementArray(reversedArray);
        return reversedArray;
    }

    public static void handleGuessingFor10Bits(Scanner scanner) {
        int[] bitsArray = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            System.out.flush();
            bitsArray[i - 1] = scanner.nextInt();
        }
        for (int bit : bitsArray) {
            System.out.print(bit);
            System.out.flush();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();
        if (bits == 10) {
            handleGuessingFor10Bits(scanner);
        }
    }
}