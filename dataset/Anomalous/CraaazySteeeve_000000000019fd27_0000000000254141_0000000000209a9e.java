import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] bits = new int[bitCount];

            for (int i = 0; i < bitCount; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt();
            }

            System.out.println(convertBitsToString(bits));
            scanner.nextLine();  // Consume the newline character
            String status = scanner.nextLine();
            return;
        }
    }

    private static String convertBitsToString(int[] bits) {
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }
}