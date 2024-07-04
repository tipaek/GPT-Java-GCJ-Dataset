import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int i = 0; i < testCases; i++) {
            int index = 1;
            int[] bytes = new int[bitLength];

            for (int j = 1; j <= 150; j++) {
                System.out.println(index);
                int response = scanner.nextInt();
                bytes[index - 1] = response; // Adjusted for zero-based indexing

                if (j % 10 == 1) {
                    // Placeholder for potential logic to be added every 10th query
                }

                index = (index % bitLength) + 1;
            }

            System.out.println(convertArrayToString(bytes));
            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    public static String convertArrayToString(int[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int byteValue : bytes) {
            result.append(byteValue);
        }
        return result.toString();
    }
}