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

            StringBuilder answer = new StringBuilder();
            for (int bit : bits) {
                answer.append(bit);
            }

            System.out.println(answer.toString());
            String response = scanner.next();
            if ("N".equals(response)) {
                System.exit(0);
            }
        }
    }
}