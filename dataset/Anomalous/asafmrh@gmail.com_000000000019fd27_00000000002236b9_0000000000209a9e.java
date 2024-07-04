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
                bits[index - 1] = response; // Adjusting index to fit 0-based array

                if (queryCount % 10 == 1) {
                    // Placeholder for potential special case handling every 10 queries
                }

                index = (index % bitLength) + 1;
            }

            System.out.println(convertArrayToString(bits));

            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    private static String convertArrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        return result.toString();
    }
}