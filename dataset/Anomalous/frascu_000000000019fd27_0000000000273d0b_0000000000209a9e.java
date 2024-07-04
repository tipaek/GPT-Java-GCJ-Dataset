import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            char[] bits = new char[bitLength];

            for (int bitPosition = 0; bitPosition < bitLength; bitPosition++) {
                System.out.println(bitPosition + 1);
                bits[bitPosition] = scanner.next().charAt(0);
            }

            System.out.println(new String(bits));
            char judgeResponse = scanner.next().charAt(0);
            if (judgeResponse == 'N') {
                break;
            }
        }

        scanner.close();
    }
}