import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void invertArray(int[] array) {
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

    public static int[] invertAndReverseArray(int[] array) {
        int[] reversedArray = reverseArray(array);
        invertArray(reversedArray);
        return reversedArray;
    }

    public static void process10Bits(Scanner scanner) {
        int[] bitsArray = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            bitsArray[i] = scanner.nextInt();
        }
        for (int bit : bitsArray) {
            System.out.print(bit);
            System.out.flush();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitCount = scanner.nextInt();
        
        if (bitCount == 10) {
            for (int i = 0; i < testCases; i++) {
                process10Bits(scanner);
            }
        }
    }
}