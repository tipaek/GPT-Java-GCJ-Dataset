import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int test = 0; test < testCases; test++) {
            StringBuilder bitString = new StringBuilder();

            for (int position = 0; position < bitLength; position++) {
                System.out.println(position + 1);
                System.out.flush();
                bitString.append(scanner.nextInt());
            }

            System.out.println(bitString.toString());
            System.out.flush();
            scanner.next(); // Read the result of the verification
        }

        scanner.close();
    }
}