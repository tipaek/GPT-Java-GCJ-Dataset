import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] bits = new int[bitLength];

            for (int i = 0; i < bitLength; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt();
            }

            System.out.println(convertBitsToString(bits));
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine();

            if ("N".equals(response)) {
                return;
            }
        }
    }

    private static String convertBitsToString(int[] bits) {
        StringBuilder result = new StringBuilder(bits.length);
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }
}