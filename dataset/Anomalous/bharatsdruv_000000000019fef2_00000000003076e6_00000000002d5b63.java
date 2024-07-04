import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        for (int t = 1; t <= testCases; t++) {
            long xL = 0, xR = 0, yU = 0, yB = 0;
            long x = 0, y = 0;

            // Check left boundary
            for (x = -1_000_000_000; x <= -999_999_950; x++, xL++) {
                System.out.println(x + " " + 0);
                String response = scanner.next();
                if (response.equals("HIT")) break;
            }

            // Check right boundary
            for (x = 1_000_000_000; x >= 999_999_950; x--, xR++) {
                System.out.println(x + " " + 0);
                String response = scanner.next();
                if (response.equals("HIT")) break;
            }

            // Check upper boundary
            for (y = 1_000_000_000; y >= 999_999_950; y--, yU++) {
                System.out.println(0 + " " + y);
                String response = scanner.next();
                if (response.equals("HIT")) break;
            }

            // Check bottom boundary
            for (y = -1_000_000_000; y <= -999_999_950; y++, yB++) {
                System.out.println(0 + " " + y);
                String response = scanner.next();
                if (response.equals("HIT")) break;
            }

            // Output the calculated center point
            System.out.println((0 + xL - xR) + " " + (0 + yB - yU));
            String finalResponse = scanner.next();
        }

        scanner.close();
    }
}