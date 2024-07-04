import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());
        int bitLength = Integer.parseInt(scanner.next());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] bits = new boolean[bitLength];

            if (bitLength == 10) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    bits[i] = Integer.parseInt(scanner.next()) == 1;
                }

                StringBuilder result = new StringBuilder();
                for (boolean bit : bits) {
                    result.append(bit ? 1 : 0);
                }

                System.out.println(result);
                if (!scanner.next().equals("Y")) {
                    return;
                }
            } else {
                System.out.println("00000000000000000000");
                scanner.next();
                return;
            }
        }
    }
}