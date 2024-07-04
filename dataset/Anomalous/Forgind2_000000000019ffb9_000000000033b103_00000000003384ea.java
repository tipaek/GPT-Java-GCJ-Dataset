import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            int j = 1;
            while (true) {
                if (left >= right) {
                    if (left >= j) {
                        left -= j;
                    } else {
                        System.out.printf("Case #%d: %d %d %d%n", i + 1, j - 1, left, right);
                        break;
                    }
                } else {
                    if (right >= j) {
                        right -= j;
                    } else {
                        System.out.printf("Case #%d: %d %d %d%n", i + 1, j - 1, left, right);
                        break;
                    }
                }
                j++;
            }
        }
        scanner.close();
    }
}