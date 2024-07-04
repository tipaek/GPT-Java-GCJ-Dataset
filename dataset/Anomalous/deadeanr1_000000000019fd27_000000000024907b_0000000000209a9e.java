import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final Random RANDOM = new Random(123);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            char[] bitArray = new char[bitLength];
            for (int i = 0; i < bitLength; i++) {
                System.out.println(i + 1);
                System.out.flush();
                bitArray[i] = (char) (scanner.nextInt() + '0');
            }
            System.out.println(new String(bitArray));
            System.out.flush();
            String response = scanner.next();

            int maxIterations = 150;
            for (int i = bitLength; i < maxIterations && response.equals("N"); i++) {
                modifyArray(bitArray);
                System.out.println(new String(bitArray));
                System.out.flush();
                response = scanner.next();
            }
        }
    }

    private static void modifyArray(char[] array) {
        int operation = Math.abs(RANDOM.nextInt()) % 4;
        switch (operation) {
            case 1:
                complement(array);
                break;
            case 2:
                invert(array);
                break;
            case 3:
                invertAndComplement(array);
                break;
            default:
                break;
        }
    }

    private static void invertAndComplement(char[] array) {
        invert(array);
        complement(array);
    }

    private static void invert(char[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    private static void complement(char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == '0' ? '1' : '0';
        }
    }
}