import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            if (!processTestCase(scanner, bitLength)) {
                System.out.println("Wrong answer!");
                break;
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength];
        int position = 1;

        for (int queryCount = 1; position <= bitLength; queryCount++) {
            System.out.println(position);
            int bit = Integer.parseInt(scanner.nextLine());

            if (queryCount % 10 != 1) {
                bits[position - 1] = bit;
                position++;
            }
        }

        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();

        String response = scanner.nextLine();
        return response.equals("Y");
    }
}