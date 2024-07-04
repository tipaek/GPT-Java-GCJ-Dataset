import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int bitLength = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int index = 1;
            int[] bits = new int[bitLength];

            for (int queryCount = 1; queryCount <= 150; queryCount++) {
                System.out.println(index);
                int response = scanner.nextInt();

                if (queryCount % 10 == 1) {
                    // Placeholder for any special handling every 10th query
                }

                bits[index - 1] = response;
                index = (index % bitLength) + 1;
            }

            System.out.println(formatBits(bits));
            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    public static String formatBits(int[] bits) {
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }
}