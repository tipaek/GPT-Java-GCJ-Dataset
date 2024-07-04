import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            if (bitLength == 10) {
                int[] bitsArray = new int[bitLength];

                for (int j = 0; j < bitLength; j++) {
                    System.out.println(j + 1);
                    bitsArray[j] = scanner.nextInt();
                }

                for (int bit : bitsArray) {
                    System.out.print(bit);
                }
                System.out.println();

                String response = scanner.next();
                if ("N".equals(response)) {
                    break;
                }
            }
        }

        scanner.close();
    }
}