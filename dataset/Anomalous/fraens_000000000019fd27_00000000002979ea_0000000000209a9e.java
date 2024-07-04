import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static int[] reverseArray(int[] array) {
        int length = array.length;
        int[] reversedArray = new int[length];
        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i];
        }
        return reversedArray;
    }

    public static int[] complementAndReverseArray(int[] array) {
        int[] reversedArray = reverseArray(array);
        complementArray(reversedArray);
        return reversedArray;
    }

    public static void handleGuessingFor10Bits(Scanner scanner) {
        int[] bits = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bits[i] = scanner.nextInt();
        }
        StringBuilder output = new StringBuilder();
        for (int bit : bits) {
            output.append(bit);
        }
        System.out.println(output.toString());
        scanner.nextLine(); // Consume newline
        scanner.nextLine(); // Read answer
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        if (bitLength == 10) {
            for (int i = 0; i < testCases; i++) {
                handleGuessingFor10Bits(scanner);
            }
        }
    }
}