import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder bitString = new StringBuilder();
            int queryCount = 1;
            int index = 1;

            while (bitString.length() < bitLength) {
                System.out.println(index);
                System.out.flush();
                String bit = scanner.next();
                if (queryCount % 10 != 1) {
                    bitString.append(bit);
                    index++;
                }
                queryCount++;
            }

            System.out.println(bitString.toString());
            System.out.flush();
            char response = scanner.next().charAt(0);
            if (response == 'Y') {
                continue;
            } else {
                System.exit(0);
            }
        }
    }
}