import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int k = 1; k <= testCases; k++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int i = 0, j = 0; j < y && i < x; i++, j++) {
                if (x % 2 == 0 && y < 0) {
                    result.append("S");
                } else if (x % y == 0 && y > 0) {
                    result.append("N");
                } else if (x % 2 != 0 && x > 0) {
                    result.append("E");
                } else if (x % 2 != 0 && x < 0) {
                    result.append("W");
                }

                int decrement = (int) Math.pow(2, i - 1);
                x -= decrement;
                y -= decrement;
            }

            System.out.println("Case " + k + ": " + result.toString());
        }
    }
}