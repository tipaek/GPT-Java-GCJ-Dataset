import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringBuilder bitString = new StringBuilder();

            for (int bitIndex = 0; bitIndex < bitLength; bitIndex++) {
                System.out.println(bitIndex);
                System.out.flush();
                bitString.append(scanner.next());
            }

            System.out.println(bitString.toString());
            System.out.flush();

            String response = scanner.next();
            if (response.equals("N")) {
                return;
            }
        }
    }
}