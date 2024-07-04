import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        for (int i = 0; i < t; i++) {
            int index = 1;
            int[] bytes = new int[b];

            for (int j = 1; j <= 150; j++) {
                System.out.println(index);
                int response = scanner.nextInt();
                if (j % 10 == 1) {
                    // Placeholder for potential future logic
                }
                bytes[index - 1] = response;
                index = (index % b) + 1;
            }

            System.out.println(convertToString(bytes));
            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    private static String convertToString(int[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int b : bytes) {
            result.append(b);
        }
        return result.toString();
    }
}