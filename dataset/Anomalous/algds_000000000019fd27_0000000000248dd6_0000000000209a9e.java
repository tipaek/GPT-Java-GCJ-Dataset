import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            boolean isCorrect = processTestCase(scanner, bitLength);
            if (!isCorrect) {
                System.out.println("Wrong answer!");
                break;
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int currentPosition = 1;
        int[] bits = new int[bitLength];

        for (int i = 1; currentPosition <= bitLength; i++) {
            System.out.println(currentPosition);
            int bitValue = scanner.nextInt();

            if (i % 10 != 1) {
                bits[currentPosition++ - 1] = bitValue;
            }
        }

        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();

        String result = scanner.next();
        return result.equals("Y");
    }
}