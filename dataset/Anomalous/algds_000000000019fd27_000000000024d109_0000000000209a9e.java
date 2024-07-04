import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            if (!processTestCase(scanner, bitLength)) {
                System.out.println("Wrong answer!");
                break;
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength];
        int position = 1;

        for (int i = 1; position <= bitLength; i++) {
            System.out.println(position);
            int bitValue = scanner.nextInt();
            
            if (i % 10 != 1) {
                bits[position - 1] = bitValue;
                position++;
            }
        }

        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();

        String verdict = scanner.next();
        return verdict.equals("Y");
    }
}