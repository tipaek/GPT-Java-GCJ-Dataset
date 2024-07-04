import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int i = 0; i < testCases; i++) {
            int index = 1;
            int[] bits = new int[bitLength];

            for (int j = 1; j <= 150; j++) {
                System.out.println(index);
                int response = Integer.parseInt(scanner.nextLine());

                if (j % 10 == 1) {
                    // Placeholder for special operations every 10th query
                }

                bits[index - 1] = response;
                index = (index % bitLength) + 1;
            }

            System.out.println(convertToString(bits));
            if (scanner.nextLine().equals("N")) {
                return;
            }
        }
    }

    private static String convertToString(int[] bits) {
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }
}