import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int t = 0; t < testCases; t++) {
            int index = 1;
            int[] bits = new int[bitLength];

            for (int j = 1; j <= 150; j++) {
                System.out.println(index);
                int response = Integer.parseInt(scanner.nextLine());

                if (j % 10 == 1) {
                    // Placeholder for any special handling every 10th query
                }

                bits[index - 1] = response;
                index = (index % bitLength) + 1;
            }

            System.out.println(arrayToString(bits));

            if (scanner.nextLine().equals("N")) {
                return;
            }
        }
    }

    public static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int bit : array) {
            result.append(bit);
        }
        return result.toString();
    }
}