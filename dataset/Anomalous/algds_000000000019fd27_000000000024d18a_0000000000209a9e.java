import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean isSuccess = processBits(scanner, bitLength);
            if (!isSuccess) {
                System.out.println("Wrong answer!");
                break;
            }
        }
    }

    private static boolean processBits(Scanner scanner, int bitLength) {
        int position = 1;
        int[] bits = new int[bitLength];

        for (int queryCount = 1; position <= bitLength; queryCount++) {
            System.out.println(position);
            int bitValue = scanner.nextInt();

            if (queryCount % 10 != 1) {
                bits[position - 1] = bitValue;
                position++;
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