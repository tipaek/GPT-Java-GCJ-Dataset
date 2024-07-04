import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String solve(int B) {
        int[] array = new int[B + 1];
        for (int i = 1; i <= B / 2; ++i) {
            System.out.printf("%d\n", i);
            array[i] = scanner.nextInt();

            System.out.printf("%d\n", B - i + 1);
            array[B - i + 1] = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= B; ++i) {
            result.append(array[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= T; ++i) {
            String result = solve(B);
            System.out.printf("%s\n", result);
            String response = scanner.next();
            if (response.equals("N")) {
                System.exit(1);
            }
        }

        scanner.close();
    }
}